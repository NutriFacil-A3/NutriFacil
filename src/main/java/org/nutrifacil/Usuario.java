package org.nutrifacil;

public class Usuario {

    public Dieta dieta;
    public double peso;
    public double altura;
    public double aguaRecomendada;
    public int idade;
    public String sexo;
    public String objetivo;
    public String restricoes;

    public void calculoTMB() {
        //a ser implementado
    }

    public void calculoIMC() {
        //a ser implementado
    }

    public void calculoAgua() {
            aguaRecomendada = peso * 0.035;
            System.out.printf("Quantidade recomendada de água por dia: %.2f litros%n", aguaRecomendada);
    }


}
