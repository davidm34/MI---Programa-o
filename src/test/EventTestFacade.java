import vendaingressos.*;
import vendaingressos.EventoManager;

import java.io.IOException;
import java.util.UUID;
import java.util.List;
import java.util.Date;
import java.util.stream.Collectors;

public class EventTestFacade {

    public EventTestFacade() {
        
    }

    public void removeSeatByEventId(String seat, String eventId) throws IOException {
        AssentoManager assentoManager = new AssentoManager();
        List<Assento> assentos = assentoManager.lerConteudoArquivoAssento();

        // Filtrar os assentos que não correspondem ao assento e ao evento fornecido
        List<Assento> assentosFiltrados = assentos.stream()
                .filter(assento -> !(assento.getSeat().equals(seat) && assento.getIdEvento().equals(eventId)))
                .collect(Collectors.toList());

        // Salvar a lista atualizada de assentos
        assentoManager.salvarAssentosNoArquivo(assentosFiltrados);
    }


    public void addSeatByEventId(String seat, String eventId) throws IOException {
        EventoManager eventoManager = new EventoManager();
        List<Evento> eventos = eventoManager.lerConteudoArquivo();
        for (Evento evento : eventos) {
            if (evento.getId().equals(eventId)) {
                Assento assento = new Assento(eventId, seat);
                AssentoManager assentoManager = new AssentoManager();
                assentoManager.save(assento);  // Adiciona o assento diretamente na lista do evento
                break;
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

    public String getSeatsByEventId(String eventId) throws IOException {
        AssentoManager assentoManager = new AssentoManager();
        List<Assento> assentos = assentoManager.lerConteudoArquivoAssento();

        // Filtrar assentos do evento específico
        List<String> seats = assentos.stream()
                .filter(assento -> assento.getIdEvento().equals(eventId))
                .map(Assento::getSeat)
                .collect(Collectors.toList());

        // Retornar a lista de assentos como uma string separada por vírgulas ou uma string vazia
        return seats.isEmpty() ? "" : String.join(", ", seats);
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
