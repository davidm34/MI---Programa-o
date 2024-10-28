package vendaingressos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AssentoManager {

    public List<Assento> listaassentos = new ArrayList<>();

    public List<Assento> lerConteudoArquivoAssento() throws IOException {
        try {
            FileReader fileReader = new FileReader("assentos.json");
            Type listType = new TypeToken<ArrayList<Assento>>() {}.getType();
            listaassentos = new Gson().fromJson(fileReader, listType);
            fileReader.close();
            if (listaassentos == null) {
                listaassentos = new ArrayList<>();
            }
        } catch (IOException e) {
            listaassentos = new ArrayList<>();
            throw e;
        }
        return listaassentos;
    }

    public void save(Assento assento) throws IOException {
        // Verifica e inicializa `listaevento` caso esteja nulo
        if (listaassentos == null) {
            listaassentos = lerConteudoArquivoAssento();
        }

        // Atualiza lista, removendo eventos duplicados antes de adicionar o novo
        listaassentos.removeIf(t -> t.getSeat().equals(assento.getSeat()));
        listaassentos.add(assento);

        // Serializa e salva a lista de eventos no arquivo JSON
        try (FileWriter fileWriter = new FileWriter("assentos.json")) {
            new Gson().toJson(listaassentos, fileWriter);
        }
    }

    public void deletarAssento(Assento assento) {
        for (int i = 0; i < listaassentos.size(); i++) {
            if(Objects.equals(listaassentos.get(i), assento)){
                listaassentos.remove(assento);
                return;
            }
        }
    }

    public void salvarAssentosNoArquivo(List<Assento> assentos) throws IOException {
        String jsonAssentos = new Gson().toJson(assentos);
        try (FileWriter fileWriter = new FileWriter("assentos.json")) {
            fileWriter.write(jsonAssentos);
            fileWriter.flush();
        }
    }

}
