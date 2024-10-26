package vendaingressos;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EventoManager {
    private List<Evento> listaevento;

    public List<Evento> lerConteudoArquivo() throws IOException {
        try {
            FileReader fileReader = new FileReader("eventos.json");
            Type listType = new TypeToken<ArrayList<Evento>>() {}.getType();
            listaevento = new Gson().fromJson(fileReader, listType);
            fileReader.close();
            if (listaevento == null) {
                listaevento = new ArrayList<>();
            }
        } catch (IOException e) {
            listaevento = new ArrayList<>();
            throw e;
        }
        return listaevento;
    }

    public boolean adicionarEventoNoArquivo(Evento evento) throws IOException {
        lerConteudoArquivo();
        listaevento.add(evento);
        String jsonEvento = new Gson().toJson(listaevento);
        FileWriter fileWriter = new FileWriter("eventos.json");
        fileWriter.write(jsonEvento);
        fileWriter.flush();
        fileWriter.close();
        return true;
    }

    public void limparArquivoJson() throws IOException {
        FileWriter fileWriter = new FileWriter("eventos.json");
        fileWriter.write("[]");
        fileWriter.flush();
        fileWriter.close();
        listaevento.clear();
    }
}
