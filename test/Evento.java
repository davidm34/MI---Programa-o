import java.util.Date;
import java.util.List;

public class Evento {
    String nome;
    String descricao;
    Date data;

    List<String> assentos;

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
        for(String iterator : assentos){
            if(iterator == assento){
                assentos.remove(iterator);
            }
        }
    }

    Date data_atual = new Date();

    public boolean isAtivo(){
        return data.after(data_atual);
    }
}
