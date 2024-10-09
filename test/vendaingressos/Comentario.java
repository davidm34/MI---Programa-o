package vendaingressos;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Comentario {

    List<Integer> avaliacoes;
    public List<String> comentarios;

    public Comentario(List<Integer> avaliacoes, List<String> comentarios){
        this.avaliacoes = avaliacoes;
        this.comentarios = comentarios;
    }

    public void escreverComentario(String comentario){
        comentarios.add(comentario);
    }

    public void darAvaliacao(Integer avaliacao){
        avaliacoes.add(avaliacao);
    }


    public void salvar(String path, Comentario comentario) throws IOException {
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter(path + "\\comentario.json")) {
            gson.toJson(comentario, writer);
        }
    }

    public Comentario carregar(String path) throws IOException {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(path + "\\comentario.json")) {
            return gson.fromJson(reader, Comentario.class);
        }
    }



}
