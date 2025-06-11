package org.nutrifacil;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testCalculoTMB_Masculino() {
        Usuario usuario = new Usuario("João", 70, 175, 30, "masculino", "emagrecimento", "normal", List.of());
        String tmbStr = usuario.calculoTMB();
        double tmb = Double.parseDouble(tmbStr);
        assertEquals(1668.75, tmb, 0.01);
    }

    @Test
    public void testCalculoTMB_Feminino() {
        Usuario usuario = new Usuario("Maria", 60, 165, 28, "feminino", "emagrecimento", "normal", List.of());
        String tmbStr = usuario.calculoTMB();
        double tmb = Double.parseDouble(tmbStr);
        assertEquals(1349.25, tmb, 0.01);
    }

    @Test
    public void testIMC() {
        Usuario usuario = new Usuario("João", 70, 175, 30, "masculino", "emagrecimento", "normal", List.of());
        String imc = usuario.calculoIMC();
        assertTrue(imc.contains("22.86"));
        assertTrue(imc.contains("Peso normal"));
    }

    @Test
    public void testCalculoAgua() {
        Usuario usuario = new Usuario("João", 70, 175, 30, "masculino", "emagrecimento", "normal", List.of());
        String agua = usuario.calculoAgua();
        assertEquals("2.45", agua); // 70 * 0.035 = 2.45
    }

    @Test
    public void testSetDieta() {
        Usuario usuario = new Usuario("João", 70, 175, 30, "masculino", "emagrecimento", "vegana", List.of());
        usuario.dieta = "vegetariana";
        assertEquals("vegetariana", usuario.dieta);
    }

    @Test
    public void testSetRestricao() {
        String entrada = "gluten,lactose,inválida";
        List<RestricaoAlimentar> restricoes = Usuario.setRestricao(entrada);
        assertTrue(restricoes.contains(RestricaoAlimentar.GLUTEN));
        assertTrue(restricoes.contains(RestricaoAlimentar.LACTOSE));
        assertEquals(2, restricoes.size()); // "inválida" deve ser ignorado
    }
}