package org.nutrifacil;

public class Usuario {

    public String nome;
    public Dieta dieta;
    public double peso;
    public double altura;
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

    public double calculoAgua() {
        double aguaRecomendada = peso * 0.035;
        return aguaRecomendada;
    }
}
