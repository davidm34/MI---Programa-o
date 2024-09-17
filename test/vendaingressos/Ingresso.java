package vendaingressos;

import java.util.Date;
import java.util.Objects;

public class Ingresso {
    Evento evento;
    Double preco;
    String assento;

    Boolean ativo = true;

    public Ingresso(Evento evento, Double preco, String assento) {
        this.evento = evento;
        this.preco = preco;
        this.assento = assento;
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

    public Boolean isAtivo() {
        return ativo;
    }

    Date data_atual = new Date();

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

