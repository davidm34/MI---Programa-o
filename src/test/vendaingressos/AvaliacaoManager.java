package vendaingressos;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AvaliacaoManager {
    private List<Avaliacao> listaavaliacao;

    public List<Avaliacao> lerConteudoArquivo() throws IOException {
        try {
            FileReader fileReader = new FileReader("avaliacoes.json");
            Type listType = new TypeToken<ArrayList<Avaliacao>>() {}.getType();
            listaavaliacao = new Gson().fromJson(fileReader, listType);
            fileReader.close();
            if (listaavaliacao == null) {
                listaavaliacao = new ArrayList<>();
            }
        } catch (IOException e) {
            listaavaliacao = new ArrayList<>();
            throw e;
        }
        return listaavaliacao;
    }

    public boolean adicionarAvaliacaoNoArquivo(Avaliacao avaliacao) throws IOException {
        lerConteudoArquivo();
        listaavaliacao.add(avaliacao);
        String jsonAvaliacao = new Gson().toJson(listaavaliacao);
        FileWriter fileWriter = new FileWriter("avaliacoes.json");
        fileWriter.write(jsonAvaliacao);
        fileWriter.flush();
        fileWriter.close();
        return true;
    }

    public void limparArquivoJson() throws IOException {
        try (FileWriter fileWriter = new FileWriter("avaliacoes.json")) {
            fileWriter.write("[]"); // Escreve uma lista vazia no arquivo
        }

        if (listaavaliacao == null) {
            listaavaliacao = new ArrayList<>(); // Inicializa a lista se estiver nula
        }
        listaavaliacao.clear(); // Limpa a lista
    }
}