import vendaingressos.*;
import vendaingressos.EventoManager;

import java.io.IOException;
import java.util.UUID;
import java.util.List;
import java.util.Date;

public class EventTestFacade {

    public EventTestFacade() {
        
    }

    public void removeSeatByEventId(String seat, String id) throws IOException {
        EventoManager eventoManager = new EventoManager();
        List<Evento> eventos = eventoManager.lerConteudoArquivo();
        for (Evento evento : eventos) {
            if (evento.getId().equals(id)) {
                Assento assento = new Assento(id, seat);
                evento.deletarAssento(assento);
            }
        }
    }

    public void addSeatByEventId(String seat, String id) throws IOException {
        EventoManager eventoManager = new EventoManager();
        List<Evento> eventos = eventoManager.lerConteudoArquivo();
        for (Evento evento : eventos) {
            if (evento.getId().equals(id)) {
                Assento assento = new Assento(id, seat);
                evento.adicionarAssentoNoArquivo(assento);
            }
        }
    }

    public String create(String loginAdmin, String name, String description, Date date) throws IOException {
        UUID uuid = UUID.randomUUID();
        String id = String.valueOf(uuid);
        Evento evento = new Evento(loginAdmin, name, description, date, id);
        EventoManager eventoManager = new EventoManager();
        eventoManager.adicionarEventoNoArquivo(evento);
        return id;
    }

    public Evento getById(String id) throws IOException {
        EventoManager eventoManager = new EventoManager();
        List<Evento> eventos = eventoManager.lerConteudoArquivo();
        for (Evento evento : eventos) {
            if (evento.getId().equals(id)) {
                return evento;
            }
        }
        return null;
    }

    public String getNameByEventId(String id) throws IOException {
        EventoManager eventoManager = new EventoManager();
        List<Evento> eventos = eventoManager.lerConteudoArquivo();
        for (Evento evento : eventos) {
            if (evento.getId().equals(id)) {
                return evento.getNome();
            }
        }
        return null;
    }

    public String getSeatsByEventId(String id) throws IOException {
        EventoManager eventoManager = new EventoManager();
        List<Evento> eventos = eventoManager.lerConteudoArquivo();
        for (Evento evento : eventos) {
            if (evento.getId().equals(id)) {
                List<Assento> assentos = evento.lerConteudoArquivoAssento();
                for(Assento assento : assentos){
                    if(assento.getIdEvento().equals(id)){
                        return assento.getSeat();
                    }
                }
            }
        }
        return null;
    }

    public String getDescriptionByEventId(String id) throws IOException {
        EventoManager eventoManager = new EventoManager();
        List<Evento> eventos = eventoManager.lerConteudoArquivo();
        for (Evento evento : eventos) {
            if (evento.getId().equals(id)) {
                return evento.getDescricao();
            }
        }
        return null;
    }

    public int getYearByEventId(String id) throws IOException {
        EventoManager eventoManager = new EventoManager();
        List<Evento> eventos = eventoManager.lerConteudoArquivo();
        for (Evento evento : eventos) {
            if (evento.getId().equals(id)) {
                return evento.getData().getYear();
            }
        }
        return 0;
    }

    public int getMonthByEventId(String id) throws IOException {
        EventoManager eventoManager = new EventoManager();
        List<Evento> eventos = eventoManager.lerConteudoArquivo();
        for (Evento evento : eventos) {
            if (evento.getId().equals(id)) {
                return evento.getData().getMonth();
            }
        }
        return 0;
    }

    public int getDayByEventId(String id) throws IOException {
        EventoManager eventoManager = new EventoManager();
        List<Evento> eventos = eventoManager.lerConteudoArquivo();
        for (Evento evento : eventos) {
            if (evento.getId().equals(id)) {
                return evento.getData().getDay();
            }
        }
        return 0;
    }

    public Date getDateByEventId(String id) throws IOException {
        EventoManager eventoManager = new EventoManager();
        List<Evento> eventos = eventoManager.lerConteudoArquivo();
        for (Evento evento : eventos) {
            if (evento.getId().equals(id)) {
                return evento.getData();
            }
        }
        return null;
    }

    public boolean getIsActiveByEventId(String id) throws IOException {
        EventoManager eventoManager = new EventoManager();
        List<Evento> eventos = eventoManager.lerConteudoArquivo();
        for (Evento evento : eventos) {
            if (evento.getId().equals(id)) {
                return evento.isAtivo();
            }
        }
        return false;
    }

    public String addEventInDataBaseWithPastDate(String name, String description, Date date) throws IOException {
        UUID uuid = UUID.randomUUID();
        String id = String.valueOf(uuid);
        Evento evento = new Evento(name, description, date, id);
        EventoManager eventoManager = new EventoManager();
        eventoManager.save(evento);
        return id;
    }

    public int getCommentQuantityByEventId(String id) throws IOException {
        AvaliacaoManager avaliacaoManager = new AvaliacaoManager();
        List<Avaliacao> avaliacoes = avaliacaoManager.lerConteudoArquivo();
        int size = 0;
        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao.getIdEvento().equals(id)) {
                size++;
            }
        }
        return size;
    }

    public void deleteAllEvents() throws IOException {
        EventoManager eventoManager = new EventoManager();
        eventoManager.limparArquivoJson();
    }
}
