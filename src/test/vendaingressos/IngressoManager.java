package vendaingressos;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class IngressoManager {
    private List<Ingresso> listaingresso;

    public List<Ingresso> lerConteudoArquivo() throws IOException {
        try {
            FileReader fileReader = new FileReader("ingressos.json");
            Type listType = new TypeToken<ArrayList<Ingresso>>() {}.getType();
            listaingresso = new Gson().fromJson(fileReader, listType);
            fileReader.close();
            if (listaingresso == null) {
                listaingresso = new ArrayList<>();
            }
        } catch (IOException e) {
            listaingresso = new ArrayList<>();
            throw e;
        }
        return listaingresso;
    }

    public boolean adicionarIngressoNoArquivo(Ingresso ingressos) throws IOException {
        lerConteudoArquivo();
        listaingresso.add(ingressos);
        String jsonIngresso = new Gson().toJson(listaingresso);
        FileWriter fileWriter = new FileWriter("ingressos.json");
        fileWriter.write(jsonIngresso);
        fileWriter.flush();
        fileWriter.close();
        return true;
    }

    public void limparArquivoJson() throws IOException {
        FileWriter fileWriter = new FileWriter("ingressos.json");
        fileWriter.write("[]");
        fileWriter.flush();
        fileWriter.close();
        listaingresso.clear();
    }
}

