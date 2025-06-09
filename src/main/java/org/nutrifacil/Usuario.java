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
