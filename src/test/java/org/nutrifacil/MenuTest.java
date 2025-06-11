package org.nutrifacil;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenuTest {

    private final PrintStream originalOut = System.out;
    private final java.io.InputStream originalIn = System.in;

    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    public void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void testExibirDietas() {
        Menu menu = new Menu();
        menu.exibirDietas();
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Dieta: Mediterrânea"));
        assertTrue(output.contains("Dieta: Low Carb"));
    }

    @Test
    public void testExibirUsuarios() {
        Menu menu = new Menu();
        menu.exibirUsuarios();
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Teste da Silva"));
        assertTrue(output.contains("Testa de Oliveira"));
    }

    @Test
public void testCadastroUsuarioSimples() {
    String input = String.join(System.lineSeparator(),
            "Carlos Silva",
            "80",
            "180",
            "28",
            "Masculino",
            "Emagrecimento",
            "Vegetariana",
            "LACTOSE,OVO"
    );
    System.setIn(new ByteArrayInputStream(input.getBytes()));

    Menu menu = new Menu();
    menu.cadastrarUsuario();

    List<Usuario> usuarios = FileDB.lerUsuarios();
    System.out.println("Usuários cadastrados após cadastro:");
    for (Usuario u : usuarios) {
        System.out.println(u.nome);
    }
    boolean encontrou = usuarios.stream().anyMatch(u -> u.nome.equals("Carlos Silva"));
    assertTrue(encontrou, "Usuário Carlos Silva não foi encontrado no armazenamento!");
}

    @Test
    public void testCalculoRecomendacoes() {
        Menu menu = new Menu();
        menu.exibirCalculos();

        String output = outputStreamCaptor.toString();
        // Deve conter TMB e cálculos
        assertTrue(output.contains("Taxa de Metabolismo Basal (TMB):")
                || output.contains("Índice de Massa Corporal (IMC):"));
    }

    @Test
    public void testExibirRecs() {
        Menu menu = new Menu();
        menu.exibirRecs();

        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("=== Recomendações por Usuário ===="));
    }
}