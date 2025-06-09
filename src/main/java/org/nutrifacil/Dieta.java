package org.nutrifacil;

import java.util.ArrayList;
import java.util.List;

public class Dieta {

    private String tipoBase;
    private List<String> restricoes;
    private List<String> alimentos;

    public Dieta(String tipoBase) {
        this.tipoBase = tipoBase;
        this.restricoes = new ArrayList<>();
        this.alimentos = new ArrayList<>();
    }

    public void adicionarRestricao(String restricao) {
        restricoes.add(restricao);
    }

    public void gerarDieta() {
        alimentos.clear();

        if (tipoBase.equalsIgnoreCase("Mediterrânea")) {
            alimentos.add("Peixe grelhado");
            alimentos.add("Salada de folhas verdes");
            alimentos.add("Azeite de oliva");
            alimentos.add("Frutas frescas");
            alimentos.add("Arroz integral");
        }

        if (restricoes.contains("intolerante a lactose")) {
            alimentos.remove("Queijo");
            alimentos.remove("Iogurte");
        }

        if (restricoes.contains("alérgico a glúten")) {
            alimentos.remove("Pão");
            alimentos.remove("Massa");
            alimentos.remove("Cerveja");
        }
    }

    public void exibirDieta() {
        System.out.println("Tipo de dieta: " + tipoBase);
        System.out.println("Restrições: " + restricoes);
        System.out.println("Alimentos permitidos:");
        for (String alimento : alimentos) {
            System.out.println("- " + alimento);
        }
    }
}

// ============================================
// Exemplos de Dietas 
// ============================================

// Dieta Mediterrânea
// Proteínas: Peixe grelhado, Frango grelhado, Ovos
// Vegetais: Espinafre, Rúcula, Tomate, Berinjela, Abobrinha
// Frutas: Morango, Maçã, Laranja, Uva
// Gorduras saudáveis: Azeite de oliva, Abacate, Nozes, Amêndoas
// Carboidratos: Pão integral, Arroz integral, Quinoa, Batata doce
// Laticínios (com moderação): Queijo feta, Iogurte natural

// ---------------------------------------------

// Dieta Low Carb
// Proteínas: Carne bovina magra, Peito de frango, Peixe, Ovos
// Vegetais: Couve-flor, Brócolis, Abobrinha, Alface, Pepino
// Gorduras boas: Azeite de oliva, Abacate, Castanhas, Manteiga ghee
// Laticínios: Queijo amarelo (baixo carbo), Creme de leite

// ---------------------------------------------

// Dieta Vegana
// Proteínas vegetais: Tofu, Tempeh, Grão-de-bico, Lentilha, Feijão
// Vegetais: Espinafre, Brócolis, Couve, Beterraba, Cenoura
// Frutas: Banana, Manga, Maçã, Morango, Abacaxi
// Grãos e cereais: Arroz integral, Quinoa, Aveia
// Oleaginosas e sementes: Nozes, Amêndoas, Semente de chia, Semente de linhaça

// ---------------------------------------------

// Dieta para intolerantes à lactose
// Proteínas: Carnes magras, Peixe, Frango, Ovos
// Vegetais: Couve, Espinafre, Abobrinha, Cenoura
// Frutas: Maçã, Banana, Pera, Laranja
// Carboidratos: Arroz, Quinoa, Batata doce
// Laticínios vegetais (alternativa): Leite de amêndoas, Leite de soja, Iogurte de coco

// ---------------------------------------------

// Dieta para alérgicos a glúten (sem glúten)
// Proteínas: Frango, Peixe, Ovos, Carne magra
// Vegetais: Tomate, Couve-flor, Rúcula, Alface, Brócolis
// Frutas: Maçã, Manga, Kiwi, Morango
// Carboidratos sem glúten: Arroz integral, Quinoa, Batata doce, Milho, Polenta
// Snacks sem glúten: Castanhas, Sementes

// ============================================
