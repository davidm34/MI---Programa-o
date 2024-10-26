package vendaingressos;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CompraManager {
    private List<Compra> listacompra;

    public List<Compra> lerConteudoArquivo() throws IOException {
        try {
            FileReader fileReader = new FileReader("compras.json");
            Type listType = new TypeToken<ArrayList<Compra>>() {}.getType();
            listacompra = new Gson().fromJson(fileReader, listType);
            fileReader.close();
            if (listacompra == null) {
                listacompra = new ArrayList<>();
            }
        } catch (IOException e) {
            listacompra = new ArrayList<>();
            throw e;
        }
        return listacompra;
    }

    public boolean adicionarCompraNoArquivo(Compra compra) throws IOException {
        lerConteudoArquivo();
        listacompra.add(compra);
        String jsonCompra = new Gson().toJson(listacompra);
        FileWriter fileWriter = new FileWriter("compras.json");
        fileWriter.write(jsonCompra);
        fileWriter.flush();
        fileWriter.close();
        return true;
    }

    public void limparArquivoJson() throws IOException {
        FileWriter fileWriter = new FileWriter("compras.json");
        fileWriter.write("[]");
        fileWriter.flush();
        fileWriter.close();
        listacompra.clear();
    }
}
