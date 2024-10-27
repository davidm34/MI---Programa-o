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

    public List<Assento> listaassentos;
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

    public List<Assento> lerConteudoArquivoAssento() throws IOException {
        try {
            FileReader fileReader = new FileReader("assentos.json");
            Type listType = new TypeToken<ArrayList<Assento>>() {}.getType();
            listaassentos = new Gson().fromJson(fileReader, listType);
            fileReader.close();
            if (listaassentos == null) {
                listaassentos = new ArrayList<>();
            }
        } catch (IOException e) {
            listaassentos = new ArrayList<>();
            throw e;
        }
        return listaassentos;
    }

    public void adicionarAssentoNoArquivo(Assento assento) throws IOException {
        lerConteudoArquivoAssento();
        listaassentos.add(assento);
        String jsonEvento = new Gson().toJson(listaassentos);
        FileWriter fileWriter = new FileWriter("assentos.json");
        fileWriter.write(jsonEvento);
        fileWriter.flush();
        fileWriter.close();
    }

    public void deletarAssento(Assento assento) {
        for (int i = 0; i < listaassentos.size(); i++) {
            if(Objects.equals(listaassentos.get(i), assento)){
                listaassentos.remove(assento);
                return;
            }
        }
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
