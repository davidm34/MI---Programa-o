package vendaingressos;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UsuarioManager {
    private List<Usuario> listausuario;

    public List<Usuario> lerConteudoArquivo() throws IOException {
        try {
            FileReader fileReader = new FileReader("usuarios.json");
            Type listType = new TypeToken<ArrayList<Usuario>>() {}.getType();
            listausuario = new Gson().fromJson(fileReader, listType);

            // Fecha o arquivo após a leitura
            fileReader.close();

            // Verifica se a lista está vazia ou nula
            if (listausuario == null) {
                listausuario = new ArrayList<>();
            }

        } catch (IOException e) {
            // Se houver uma exceção, inicializa uma lista vazia
            listausuario = new ArrayList<>();
            throw e;  // Propaga a exceção para que o chamador saiba do erro
        }

        // Retorna a lista de usuários
        return listausuario;
    }
    public boolean adicionarUsuarioNoArquivo(String login, String password, String name, String cpf, String email, Boolean isAdmin, String id) throws IOException {
        Usuario usuario = new Usuario(login, password, name, cpf, email, isAdmin, id);
        lerConteudoArquivo();
        listausuario.add(usuario);
        String jsonUsuarios = new Gson().toJson(listausuario);
        FileWriter fileWriter = new FileWriter("usuarios.json");
        fileWriter.write(jsonUsuarios);
        fileWriter.flush();
        fileWriter.close();
        return true;
    }

    public void deletarUsuarioPorEmail(String email, List<Usuario> usuarios) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            if (usuario.getEmail().equals(email)) {
                usuarios.remove(i);
                return;
            }
        }
    }
    public void limparArquivoJson() throws IOException {
        try (FileWriter fileWriter = new FileWriter("usuarios.json")) {
            fileWriter.write("[]"); // Escreve uma lista vazia no arquivo
        }

        if (listausuario == null) {
            listausuario = new ArrayList<>(); // Inicializa a lista se estiver nula
        }
        listausuario.clear(); // Limpa a lista
    }

    public void salvarUsuarios(List<Usuario> usuarios) throws IOException {
        try (FileWriter fileWriter = new FileWriter("usuarios.json")) {
            String jsonUsuarios = new Gson().toJson(usuarios);
            fileWriter.write(jsonUsuarios);
        }
    }


}