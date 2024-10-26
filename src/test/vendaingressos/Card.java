package vendaingressos;
import java.util.Date;

public class Card {
    private String idUsuario;
    private String nomedoCartao;
    private String numerodoCartao;
    private Date validade;
    private int codigoDeSeguranca;

    public Card(String idUsuario, String nomedoCartao, String numerodoCartao, Date validade, int codigoDeSeguranca){
        this.idUsuario = idUsuario;
        this.nomedoCartao = nomedoCartao;
        this.numerodoCartao = numerodoCartao;
        this.validade = validade;
        this.codigoDeSeguranca = codigoDeSeguranca;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public Date getValidade() {
        return validade;
    }

    public int getCodigoDeSeguranca() {
        return codigoDeSeguranca;
    }

    public String getNomedoCartao() {
        return nomedoCartao;
    }

    public String getNumerodoCartao() {
        return numerodoCartao;
    }

}
