import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private NutriFacilSistema sistema = new NutriFacilSistema(); // Classe que centraliza a lógica

    public void exibirMenuPrincipal() {
        int opcao;

        do {
            System.out.println("\n=== NUTRIFÁCIL ===");
            System.out.println("1. Escolher dieta");
            System.out.println("2. Inserir dados pessoais");
            System.out.println("3. Preferência de alimentos");
            System.out.println("4. Alergias e intolerâncias");
            System.out.println("5. Calcular IMC, TMB e Consumo de Água");
            System.out.println("6. Ver recomendações alimentares");
            System.out.println("7. Salvar plano alimentar");
            System.out.println("8. Carregar plano alimentar");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    sistema.selecionarDieta(scanner);
                    break;
                case 2:
                    sistema.inserirDadosPessoais(scanner);
                    break;
                case 3:
                    sistema.inserirPreferencias(scanner);
                    break;
                case 4:
                    sistema.inserirRestricoes(scanner);
                    break;
                case 5:
                    sistema.calcularMetricas();
                    break;
                case 6:
                    sistema.mostrarRecomendacoes();
                    break;
                case 7:
                    sistema.salvarPlano();
                    break;
                case 8:
                    sistema.carregarPlano();
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 9);
    }
}
