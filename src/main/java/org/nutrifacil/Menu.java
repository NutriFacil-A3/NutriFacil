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
            System.out.println("===================");
            System.out.println("- " + d.tipo);
            System.out.println("- " + d.objetivo);
            System.out.println("- " + d.conteudo);
            System.out.println("- " + d.restricao);
        }
    }

    public void exibirUsuarios(){
        System.out.println("=== Usuários cadastrados ===");
        List<Usuario> usuarios = FileDB.lerUsuarios();
        for (Usuario u : usuarios) {
            System.out.println("===================");
            System.out.println("- " + u.nome);
            System.out.println("- " + u.peso);
            System.out.println("- " + u.altura);
            System.out.println("- " + u.idade);
            System.out.println("- " + u.sexo);
            System.out.println("- " + u.objetivo);
            System.out.println("- " + u.restricao);
            System.out.println("- " + u.dieta.tipo);
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
        System.out.print("Objetivo: (Emagrecimento/Hipertrofia)");
        System.out.print(" - Emagrecimento (perda de gordura, redução de medidas, aumento de energia, etc.) - ");
        System.out.print(" - Hipertrofia (ganho de massa, aumento de força, autoestima, etc.) - ");
        String objetivo = sc.nextLine();
        System.out.print("Alergias/Intolerâncias: Lactose, Glúten, Proteína do leite, Ovo, Frutos do mar, Nenhuma");
        String restricao = sc.nextLine();
        System.out.print("Dieta (Mediterrânea, Low Carb, Cetogênica, Vegetariana): ");
        String dieta = sc.nextLine();
        Usuario user = new Usuario(nome,peso,altura,idade,sexo,objetivo,restricao);

        FileDB.salvarUsuario(user);
    }

    public void exibirCalculos() {
        List<Usuario> usuarios = FileDB.lerUsuarios();
        System.out.println("=== Recomendações por usuário ====");
        for (Usuario u : usuarios) {
            System.out.println("===================");
            System.out.println("Usuário: " + u.nome);
//            System.out.println("Taxa de Metabolismo Basal (TMB): " + u.calculoTMB());
//            System.out.println("Índice de Massa Corporal (IMC): " + u.calculoIMC());
            System.out.println("Consumo de Água Diário: " + u.calculoAgua());
        }
    }

    public void exibirMenuPrincipal() {
        int opcao;

        do {
            System.out.println("\n=== NUTRIFÁCIL ===");
            System.out.println("1. Exibir Opções de Dietas");
            System.out.println("2. Exibir Usuários Cadastrados");
            System.out.println("3. Cadastrar usuário");
            System.out.println("4. Calcular IMC, TMB e Consumo de Água");
            System.out.println("5. Ver recomendações alimentares por usuário");
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
