package vendaingressos;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class Evento {

    private String id;
    private String login;
    private String nome;
    private String descricao;
    protected Date data;

    Avaliacao comentarios;

    List<String> assentos = new ArrayList<>();
    public Evento(String nome, String descricao, Date data){
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
    }

    public Evento(String nome, String descricao, Date data, String id){
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.id = id;
    }

    public Evento(String login, String nome, String descricao, Date data, String id, List<String> assentos){
        this.login = login;
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.id = id;
        this.assentos = assentos;
    }

    public Evento(String login, String nome, String descricao, Date data, String id){
        this(login, nome, descricao, data, id, List.of("Nenhum assento"));
    }

    public String getId(){ return id; }
    public String getNome(){
        return nome;
    }

    public String getLogin(){ return login; }

    public String getDescricao(){
        return descricao;
    }

    public Date getData(){
        return data;
    }

    public List<String> getAssentos(){ return assentos; }

    public void adicionarAssento(String assento){
        assentos.add(assento);
    }

    public List<String> getAssentosDisponiveis(){
        return assentos;
    }

    public void removerAssento(String assento){
        assentos.removeIf(c -> c.equals(assento));
    }

    public boolean isAtivo(){
        Date data_atual = new Date();
        return data.after(data_atual);
    }

    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }
        if (objeto == null || getClass() != objeto.getClass()) {
            return false;
        }
        Evento evento = (Evento) objeto;
        return Objects.equals(nome, evento.nome) && Objects.equals(descricao, evento.descricao) && Objects.equals(data, evento.data);
    }

    public int hashCode() {
        return Objects.hash(nome, descricao, data);
    }
}
