import java.util.Date;

public class Ingresso {
    Evento evento;
    Float preco;
    String assento;

    Boolean ativo = true;

    public Ingresso(Evento evento,Float preco, String assento){
        this.evento = evento;
        this.preco = preco;
        this.assento = assento;
    }

    public Evento getEvento(){
        return evento;
    }

    public Float getPreco(){
        return preco;
    }

    public String getAssento(){
        return assento;
    }

    public Boolean isAtivo(){
        return ativo;
    }

    Date data_atual = new Date();
    public Boolean cancelar(){
        ativo = evento.data.after(data_atual);
        return ativo;
    }




}
