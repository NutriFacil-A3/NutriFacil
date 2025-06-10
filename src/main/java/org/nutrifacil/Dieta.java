package org.nutrifacil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Dieta {

    public String tipo;
    public RestricaoAlimentar restricao;
    public Map<String, List<String>> alimentos;

    public static String setDieta(String restricoes, String dieta){
        String dietaUser = "";
        String[] restricoesArray = restricoes.split(",");
        List<RestricaoAlimentar> restricoesList = new ArrayList<>();
        for (String restricao : restricoesArray) {
            try {
                restricoesList.add(RestricaoAlimentar.valueOf(restricao.trim().toUpperCase()));
            } catch (IllegalArgumentException e) {
                System.out.println("Restrição inválida ignorada: " + restricao);
            }
        }

        switch (dieta.toLowerCase()){
            case "mediterrânea":
                if (restricoesList.contains(RestricaoAlimentar.OVO)){
                    dietaUser = "Mediterrânea - Restricao: OVO";
                } else if (restricoesList.contains(RestricaoAlimentar.FRUTOS_DO_MAR)) {
                    dietaUser = "Mediterrânea - Restricao: FRUTOS_DO_MAR";
                } else {
                    dietaUser = "Mediterrânea - Restricao: NENHUMA";
                }
                break;
            case "low carb":
                if (restricoesList.contains(RestricaoAlimentar.OVO)){
                    dietaUser = "Low Carb - Restricao: OVO";
                } else if (restricoesList.contains(RestricaoAlimentar.FRUTOS_DO_MAR)) {
                    dietaUser = "Low Carb - Restricao: FRUTOS_DO_MAR";
                } else {
                    dietaUser = "Low Carb - Restricao: NENHUMA";
                }
                break;
            case "cetogênica":
                if (restricoesList.contains(RestricaoAlimentar.OVO)){
                    dietaUser = "Cetogênica - Restricao: OVO";
                } else if (restricoesList.contains(RestricaoAlimentar.FRUTOS_DO_MAR)) {
                    dietaUser = "Cetogênica - Restricao: FRUTOS_DO_MAR";
                } else {
                    dietaUser = "Cetogênica - Restricao: NENHUMA";
                }
                break;
            case "vegetariana":
                if (restricoesList.contains(RestricaoAlimentar.LACTOSE)){
                    dietaUser = "Vegetariana - Restricao: LACTOSE";
                } else if (restricoesList.contains(RestricaoAlimentar.OVO)) {
                    dietaUser = "Vegetariana - Restricao: OVO";
                } else {
                    dietaUser = "Vegetariana - Restricao: NENHUMA";
                }
                break;
        }
        return dietaUser;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dieta: ").append(tipo).append("\n");
        sb.append("Restrição: ").append(restricao).append("\n");
        sb.append("Alimentos:\n");

        for (Map.Entry<String, List<String>> entry : alimentos.entrySet()) {
            sb.append("  ").append(entry.getKey()).append(": ");
            sb.append(String.join(", ", entry.getValue()));
            sb.append("\n");
        }
        return sb.toString();
    }
}
