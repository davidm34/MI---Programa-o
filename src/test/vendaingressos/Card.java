package vendaingressos;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Card {

    private String agencia;
    private String numerodoCartao;
    private String nomedoCartao;

    private Date validade;

    private String codigoDeSeguranca;

    public Card(String agencia, String numerodoCartao, String nomedoCartao, Date validade, String codigoDeSeguranca){
        this.agencia = agencia;
        this.numerodoCartao = numerodoCartao;
        this.nomedoCartao = nomedoCartao;
        this.validade = validade;
        this.codigoDeSeguranca = codigoDeSeguranca;
    }

    public void salvar(String path, Card card) throws IOException {
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter(path + "\\cartao.json")) {
            gson.toJson(card, writer);
        }
    }

    public Card carregar(String path) throws IOException {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(path + "\\comentario.json")) {
            return gson.fromJson(reader, Card.class);
        }
    }




}
