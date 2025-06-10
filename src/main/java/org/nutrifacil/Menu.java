package org.nutrifacil;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);

    public void exibirDietas(){
        System.out.println("=== Dietas ===");
        List<Dieta> dietas = FileDB.lerDietas();
        for (Dieta d : dietas) {
            System.out.print("===================\n");
            System.out.println(d);
        }
    }

    public void exibirUsuarios(){
        System.out.println("\n=== Usuários cadastrados ===");
        List<Usuario> usuarios = FileDB.lerUsuarios();
        for (Usuario u : usuarios) {
            System.out.println("===================");
            System.out.println("-Nome: " + u.nome);
            System.out.printf("-Peso: %.2fkg\n", u.peso);
            System.out.printf("-Altura: %.2fm\n", u.altura/100);
            System.out.println("-Idade: " + u.idade);
            System.out.println("-Sexo: " + u.sexo);
            System.out.println("-Objetivo: " + u.objetivo);
            System.out.println("-Restrição: " + u.restricoes);
            System.out.println("-Dieta: " + u.dieta);
            System.out.println("===================");
        }
    }

    public void cadastrarUsuario(){
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Peso (kg): ");
        double peso = sc.nextDouble();
        System.out.print("Altura (cm): ");
        double altura = sc.nextDouble();
        System.out.print("Idade: ");
        int idade = sc.nextInt();
        sc.nextLine();
        System.out.print("Sexo (Masculino/Feminino): ");
        String sexo = sc.nextLine();
        System.out.println("Objetivo: (Emagrecimento/Hipertrofia)");
        System.out.println("-Emagrecimento (perda de gordura, redução de medidas, aumento de energia, etc.) - ");
        System.out.println("-Hipertrofia (ganho de massa, aumento de força, autoestima, etc.) - ");
        String objetivo = sc.nextLine();
        System.out.println("Informe restrições alimentares (LACTOSE, GLUTEN, OVO, PROTEINA_DO_LEITE, FRUTOS_DO_MAR), separadas por vírgula:");
        String restricoesInput = sc.nextLine();
        System.out.println("Dieta (Mediterrânea, Low Carb, Cetogênica, Vegetariana): ");
        String dieta = sc.nextLine();
        String dietaUser = Dieta.setDieta(restricoesInput,dieta);
        List<RestricaoAlimentar> restUser = Usuario.setRestricao(restricoesInput);
        Usuario user = new Usuario(nome,peso,altura,idade,sexo,objetivo, dietaUser, restUser);

        FileDB.salvarUsuario(user);
    }

    public void exibirCalculos() {
        List<Usuario> usuarios = FileDB.lerUsuarios();
        System.out.println("\n=== Taxas por usuário ====");
        for (Usuario u : usuarios) {
            System.out.println("===================");
            System.out.println("Usuário: " + u.nome);
            System.out.println("Taxa de Metabolismo Basal (TMB): " + u.calculoTMB() + " kcal/dia");
            System.out.println("Índice de Massa Corporal (IMC): " + u.calculoIMC());
            System.out.println("Consumo de Água Diário: " + u.calculoAgua() + "L/dia");
            System.out.println("===================");
        }
    }

    public void exibirRecs(){
        List<Usuario> usuarios = FileDB.lerUsuarios();
        System.out.print("\n=== Recomendações por Usuário ====\n");
        for (Usuario u : usuarios) {
            System.out.println("===================");
            System.out.println("Usuário: " + u.nome);
            u.calcKcal();
            System.out.println("===================");
        }
    }

    public void exibirMenuPrincipal() {
        int opcao;

        do {
            System.out.println("=== NUTRIFÁCIL ===");
            System.out.println("1. Exibir Opções de Dietas");
            System.out.println("2. Exibir Usuários Cadastrados");
            System.out.println("3. Cadastrar usuário");
            System.out.println("4. Calcular IMC, TMB e Consumo de Água");
            System.out.println("5. Ver recomendações calóricas por usuário");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    exibirDietas();
                    break;
                case 2:
                    exibirUsuarios();
                    break;
                case 3:
                    cadastrarUsuario();
                    break;
                case 4:
                    exibirCalculos();
                    break;
                case 5:
                    exibirRecs();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 9);
    }
}
