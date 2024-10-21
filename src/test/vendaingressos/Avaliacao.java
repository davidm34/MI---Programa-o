package vendaingressos;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Avaliacao {

    private String idUsuario;
    private String idEvento;

    private String idAvaliacao;
    public int avaliacoes;
    public String comentarios;

    public Avaliacao(String idUsuario, String idEvento, String idAvaliacao, int avaliacoes, String comentarios){
        this.idUsuario = idUsuario;
        this.idEvento = idEvento;
        this.idAvaliacao = idAvaliacao;
        this.avaliacoes = avaliacoes;
        this.comentarios = comentarios;
    }

    public int getAvaliacao(){
        return avaliacoes;
    }

    public String getComentarios(){
        return comentarios;
    }

    public String getId(){ return idAvaliacao; }

    public String getIdUsuario(){ return idUsuario; }

    public String getIdEvento(){ return idEvento; }

}
