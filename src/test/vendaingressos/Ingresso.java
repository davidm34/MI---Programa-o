package vendaingressos;

import java.util.Date;
import java.util.Objects;

public class Ingresso {

    String idEvento;

    String id;
    Evento evento;
    Double preco;
    String assento;

    Boolean ingressoAtivo;

    Boolean ativo = true;

    public Ingresso(Evento evento, Double preco, String assento) {
        this.evento = evento;
        this.preco = preco;
        this.assento = assento;
    }

    public Ingresso(String idEvento, Double preco, String assento, String id, Boolean ingressoAtivo){
        this.idEvento = idEvento;
        this.preco = preco;
        this.assento = assento;
        this.id = id;
        this.ingressoAtivo = true;
    }

    public Evento getEvento() {
        return evento;
    }

    public Double getPreco() {
        return preco;
    }

    public String getAssento() {
        return assento;
    }

    public String getId(){ return id; }

    public String getIdEvento(){ return idEvento;}

    public Boolean isAtivo() {
        return ativo;
    }

    public Boolean getIngressoAtivo() {
        return ingressoAtivo;
    }

    Date data_atual = new Date();

    public void setIngressoAtivo(Boolean ingressoAtivo) {
        this.ingressoAtivo = ingressoAtivo;
    }

    public Boolean cancelar() {
        if (evento.data.after(data_atual)) {
            ativo = false;
            return true;
        } else {
            return false;
        }
    }

    public Boolean reativar() {
        ativo = true;
        return true;
    }

    public void cancelarIngresso(){
        ativo = false;
    }

    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }
        if (objeto == null || getClass() != objeto.getClass()) {
            return false;
        }
        Ingresso ingresso = (Ingresso) objeto;
        return Double.compare(ingresso.preco, preco) == 0 && Objects.equals(evento, ingresso.evento) && Objects.equals(assento, ingresso.assento);
    }

    public int hashCode() {
        return Objects.hash(evento, preco, assento);
    }

}

