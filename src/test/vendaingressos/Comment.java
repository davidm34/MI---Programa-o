package vendaingressos;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Comment {

    public List<Integer> avaliacoes;
    public List<String> comentarios;

    public Comment(List<Integer> avaliacoes, List<String> comentarios){
        this.avaliacoes = avaliacoes;
        this.comentarios = comentarios;
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


    public void salvar(String path, Comment comment) throws IOException {
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter(path + "\\comentario.json")) {
            gson.toJson(comment, writer);
        }
    }

    public Comment carregar(String path) throws IOException {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(path + "\\comentario.json")) {
            return gson.fromJson(reader, Comment.class);
        }
    }



}
