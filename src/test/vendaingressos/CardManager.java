package vendaingressos;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CardManager {
    private List<Card> listacard;

    public List<Card> lerConteudoArquivo() throws IOException {
        try {
            FileReader fileReader = new FileReader("cards.json");
            Type listType = new TypeToken<ArrayList<Card>>() {}.getType();
            listacard = new Gson().fromJson(fileReader, listType);
            fileReader.close();
            if (listacard == null) {
                listacard = new ArrayList<>();
            }
        } catch (IOException e) {
            listacard = new ArrayList<>();
            throw e;
        }
        return listacard;
    }

    public boolean adicionarCardNoArquivo(Card card) throws IOException {
        lerConteudoArquivo();
        listacard.add(card);
        String jsonCard = new Gson().toJson(listacard);
        FileWriter fileWriter = new FileWriter("cards.json");
        fileWriter.write(jsonCard);
        fileWriter.flush();
        fileWriter.close();
        return true;
    }

    public void limparArquivoJson() throws IOException {
        try (FileWriter fileWriter = new FileWriter("cards.json")) {
            fileWriter.write("[]"); // Escreve uma lista vazia no arquivo
        }

        if (listacard == null) {
            listacard = new ArrayList<>(); // Inicializa a lista se estiver nula
        }
        listacard.clear(); // Limpa a lista
    }

    public void salvarCardsNoArquivo(List<Card> cards) throws IOException {
        try (FileWriter fileWriter = new FileWriter("cards.json")) {
            new Gson().toJson(cards, fileWriter);
        }
    }

}
