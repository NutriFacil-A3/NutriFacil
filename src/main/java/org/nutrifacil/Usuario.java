package org.nutrifacil;

public class Usuario {

    public String nome;
    public Dieta dieta;
    public double peso;
    public double altura;
    public int idade;
    public String sexo;
    public String objetivo;
    public String restricao;
    

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

    public Usuario(String nome, double peso, double altura, int idade, String sexo, String objetivo, String restricao) {
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
        this.sexo = sexo;
        this.objetivo = objetivo;
        this.restricao = restricao;
    }
}
