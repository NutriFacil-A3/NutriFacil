import java.util.Scanner;

public class CalculadoraIMC {

    public static double calcularIMC(double pesoKg, double alturaMetros) {
        if (pesoKg <= 0 || alturaMetros <= 0) {
            throw new IllegalArgumentException("Peso e altura devem ser maiores que zero.");
        }
        return pesoKg / (alturaMetros * alturaMetros);
    }

    public static String classificarIMC(double imc) {
        if (imc < 18.5) return "Abaixo do peso";
        else if (imc < 24.9) return "Peso normal";
        else if (imc < 29.9) return "Sobrepeso";
        else if (imc < 34.9) return "Obesidade grau I";
        else if (imc < 39.9) return "Obesidade grau II";
        else return "Obesidade grau III";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite seu peso em kg: ");
            double peso = Double.parseDouble(scanner.next().replace(",", "."));

            System.out.print("Digite sua altura em metros (ex: 1,75 ou 1.75): ");
            double altura = Double.parseDouble(scanner.next().replace(",", "."));

            double imc = calcularIMC(peso, altura);
            String classificacao = classificarIMC(imc);

            System.out.printf("Seu IMC é: %.2f - %s\n", imc, classificacao);
        } catch (NumberFormatException e) {
            System.out.println("Erro: valor inválido digitado. Use números com ponto ou vírgula.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        scanner.close();
    }
}

