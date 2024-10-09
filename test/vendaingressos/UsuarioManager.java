package vendaingressos;

import com.google.gson.Gson;
import vendaingressos.Usuario;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioManager {
    private List<Usuario> listausuario = new ArrayList<>();
    private String jsonUsuarios; // Variável para armazenar o JSON

    // Função para adicionar o usuário e gerar o JSON como String
    public String adicionarUsuario(Usuario usuario) {
        listausuario.add(usuario);
        // Converte a lista de usuários para JSON
        jsonUsuarios = new Gson().toJson(listausuario);
        return jsonUsuarios; // Retorna o JSON gerado
    }

    // Função para salvar o JSON gerado em uma variável (jsonUsuarios)
    public void salvarJsonEmVariavel() {
        // Aqui assumimos que o JSON já foi gerado pela função anterior
        if (jsonUsuarios != null) {
            // Se o JSON já foi gerado, imprime ou faz outra manipulação
            System.out.println("JSON salvo na variável: " + jsonUsuarios);
        } else {
            System.out.println("Nenhum JSON foi gerado ainda.");
        }
    }

    public static void main(String[] args) {
        UsuarioManager usuarioManager = new UsuarioManager();
        Usuario usuario = new Usuario("johndoe", "senha123", "John Doe", "12345678901", "john.doe@example.com", false);

        // Chama a função que gera o JSON
        String jsonGerado = usuarioManager.adicionarUsuario(usuario);
        System.out.println("JSON Gerado: " + jsonGerado);

        // Chama a função que salva o JSON na variável
        usuarioManager.salvarJsonEmVariavel();
    }
}