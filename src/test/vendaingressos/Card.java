package vendaingressos;
import java.util.Date;

public class Card {

    private String idCartao;
    private String idUsuario;
    private String nomedoCartao;
    private String numerodoCartao;
    private Date validade;
    private int codigoDeSeguranca;

    public Card(String idCartao, String idUsuario, String nomedoCartao, String numerodoCartao, Date validade, int codigoDeSeguranca){
        this.idCartao = idCartao;
        this.idUsuario = idUsuario;
        this.nomedoCartao = nomedoCartao;
        this.numerodoCartao = numerodoCartao;
        this.validade = validade;
        this.codigoDeSeguranca = codigoDeSeguranca;
    }


    public String getIdCartao() {
        return idCartao;
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
