package org.nutrifacil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileDB {
    private static final String CAMINHO = "src/main/resources/usuarios.json";

    public static void salvarUsuario(Usuario novoUsuario) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Usuario> usuarios = lerUsuarios();
        usuarios.add(novoUsuario);
        try {
            Files.createDirectories(Paths.get("src/main/resources"));
            FileWriter writer = new FileWriter(CAMINHO);
            gson.toJson(usuarios, writer);
            writer.close();
        } catch (IOException e) {
            System.err.println("Erro ao salvar: " + e.getMessage());
        }
    }

    public static List<Usuario> lerUsuarios() {
        Gson gson = new Gson();
        try {
            if (!Files.exists(Paths.get(CAMINHO))) {
                return new ArrayList<>();
            }
            FileReader reader = new FileReader(CAMINHO);
            Type listType = new TypeToken<List<Usuario>>() {}.getType();
            List<Usuario> usuarios = gson.fromJson(reader, listType);
            reader.close();
            return usuarios != null ? usuarios : new ArrayList<>();
        } catch (IOException e) {
            System.err.println("Erro ao ler: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static List<Dieta> lerDietas() {
        Gson gson = new Gson();
        try {
            if (!Files.exists(Paths.get(CAMINHO))) {
                return new ArrayList<>();
            }
            FileReader reader = new FileReader(CAMINHO);
            Type listType = new TypeToken<List<Usuario>>() {}.getType();
            List<Dieta> dietas = gson.fromJson(reader, listType);
            reader.close();
            return dietas != null ? dietas : new ArrayList<>();
        } catch (IOException e) {
            System.err.println("Erro ao ler: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
