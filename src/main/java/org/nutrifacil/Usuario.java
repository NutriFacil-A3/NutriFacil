package org.nutrifacil;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    public String nome;
    public String dieta;
    public double peso;
    public double altura;
    public int idade;
    public String sexo;
    public String objetivo;
    public List<RestricaoAlimentar> restricoes;
    public double tmb;

    public String calculoTMB() {
        if (peso <= 0 || altura <= 0 || idade <= 0 || sexo == null) {
            throw new IllegalArgumentException("Dados inválidos para cálculo da TMB.");
        }
        double tmb;
        if (sexo.equalsIgnoreCase("masculino")) {
            tmb = 10 * peso + 6.25 * altura - 5 * idade + 5;
            this.tmb = tmb;
        } else if (sexo.equalsIgnoreCase("feminino")) {
            tmb = 10 * peso + 6.25 * altura - 5 * idade - 161;
            this.tmb = tmb;
        } else {
            throw new IllegalArgumentException("Sexo deve ser 'masculino' ou 'feminino'.");
        }
//        System.out.printf("TMB de %s: %.2f kcal/dia%n", nome, tmb);
        return String.format("%.2f",tmb);
    }
    

    public String calculoIMC() {
        if (peso <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Peso e altura devem ser maiores que zero.");
        }
    
        double alturaMetros = altura / 100;
        double imc = peso / (alturaMetros * alturaMetros);
        String classificacao;
    
        if (imc < 18.5) classificacao = "Abaixo do peso";
        else if (imc < 24.9) classificacao = "Peso normal";
        else if (imc < 29.9) classificacao = "Sobrepeso";
        else classificacao = "Obesidade";
    
        return String.format("%.2f - %s", imc, classificacao);
    }

    public String calculoAgua() {
        double aguaRecomendada = peso * 0.035;
        return String.format("%.2f",aguaRecomendada);
    }

    public static List<RestricaoAlimentar> setRestricao(String restricoesInput){
        String[] restricoesArray = restricoesInput.split(",");

        List<RestricaoAlimentar> restricoes = new ArrayList<>();
        for (String restricao : restricoesArray) {
            try {
                restricoes.add(RestricaoAlimentar.valueOf(restricao.trim().toUpperCase()));
            } catch (IllegalArgumentException e) {
                System.out.println("Restrição inválida ignorada: " + restricao);
            }
        }
        return restricoes;
    }

    public void calcKcal(){
        this.calculoTMB();
        // Déficit (para emagrecimento)
        double deficitLeve = tmb * 0.85;     // -15%
        double deficitModerado = tmb * 0.80; // -20%
        double deficitAgressivo = tmb * 0.75; // -25%

        // Superávit (para hipertrofia)
        double superavitLeve = tmb * 1.10;   // +10%
        double superavitModerado = tmb * 1.15; // +15%
        double superavitAgressivo = tmb * 1.20; // +20%
        if (this.objetivo.equalsIgnoreCase("emagrecimento")){
            System.out.printf("TMB calculado: %.2f kcal\n", tmb);
            System.out.println("===== Déficit Calórico (Emagrecimento) =====");
            System.out.printf("Leve (-15%%): %.2f kcal\n", deficitLeve);
            System.out.printf("Moderado (-20%%): %.2f kcal\n", deficitModerado);
            System.out.printf("Agressivo (-25%%): %.2f kcal\n", deficitAgressivo);
        } else if (this.objetivo.equalsIgnoreCase("hipertrofia")){
            System.out.printf("TMB calculado: %.2f kcal\n", tmb);
            System.out.println("===== Superávit Calórico (Hipertrofia) =====");
            System.out.printf("Leve (+10%%): %.2f kcal\n", superavitLeve);
            System.out.printf("Moderado (+15%%): %.2f kcal\n", superavitModerado);
            System.out.printf("Agressivo (+20%%): %.2f kcal\n", superavitAgressivo);
        }
    }

    public Usuario(String nome, double peso, double altura, int idade, String sexo, String objetivo, String dieta, List<RestricaoAlimentar> restricoes) {
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
        this.sexo = sexo;
        this.objetivo = objetivo;
        this.dieta = dieta;
        this.restricoes = restricoes;
    }
}
