package vendaingressos;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Avaliacao {

    public List<Integer> avaliacoes;
    public List<String> comentarios;
    private String id;
    protected String idEvento;

    public Avaliacao(List<Integer> avaliacoes, List<String> comentarios, String id, String idEvento){
        this.avaliacoes = avaliacoes;
        this.comentarios = comentarios;
        this.id = id;
        this.idEvento = idEvento;
    }

    public List<Integer> getAvaliacao(){
        return avaliacoes;
    }

    public List<String> getComentarios(){
        return comentarios;
    }

    public void escreverComentario(String comentario){
        comentarios.add(comentario);
    }

    public void darAvaliacao(Integer avaliacao){
        avaliacoes.add(avaliacao);
    }


    public void salvar(String path, Avaliacao avaliacao) throws IOException {
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter(path + "\\comentario.json")) {
            gson.toJson(avaliacao, writer);
        }
    }

    public Avaliacao carregar(String path) throws IOException {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(path + "\\comentario.json")) {
            return gson.fromJson(reader, Avaliacao.class);
        }
    }



}
