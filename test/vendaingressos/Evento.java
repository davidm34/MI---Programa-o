package vendaingressos;

import java.util.*;
import java.io.FileReader;

public class Evento {
    String nome;
    String descricao;
    Date data;

    Comentario comentarios;

    List<String> assentos = new ArrayList<>();

    public Evento(String nome, String descricao, Date data, Comentario comentarios){
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.comentarios = comentarios;
    }

    public Evento(String nome, String descricao, Date data){
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
    }

    public String getNome(){
        return nome;
    }

    public String getDescricao(){
        return descricao;
    }

    public Date getData(){
        return data;
    }

    public void adicionarAssento(String assento){
        assentos.add(assento);
    }

    public List<String> getAssentosDisponiveis(){
        return assentos;
    }

    public void removerAssento(String assento){
        assentos.removeIf(c -> c.equals(assento));
    }

    Date data_atual = new Date();

    public boolean isAtivo(){
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
