import vendaingressos.Evento;
import vendaingressos.EventoManager;
import vendaingressos.Ingresso;
import vendaingressos.IngressoManager;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class TicketTestFacade {

    public TicketTestFacade(){
       
    }

    public String create(String eventId, Double price, String seat) throws IOException {
        UUID uuid = UUID.randomUUID();
        String id = String.valueOf(uuid);
        Ingresso ingresso = new Ingresso(eventId, price, seat, id);
        IngressoManager ingressoManager = new IngressoManager();
        if(ingressoManager.adicionarIngressoNoArquivo(ingresso)){
            return id;
        }
        return null;
    }

    public String getEventByTicketId(String id) throws IOException {
        IngressoManager ingressoManager = new IngressoManager();
        List<Ingresso> ingressos = ingressoManager.lerConteudoArquivo();
        for (Ingresso ingresso : ingressos) {
            if (ingresso.getId().equals(id)) {
                return ingresso.getIdEvento();
            }
        }
        return null;
    }

    public Double getPriceByTicketId(String id) throws IOException {
        IngressoManager ingressoManager = new IngressoManager();
        List<Ingresso> ingressos = ingressoManager.lerConteudoArquivo();
        for (Ingresso ingresso : ingressos) {
            if (ingresso.getId().equals(id)) {
                return ingresso.getPreco();
            }
        }
        return null;
    }

    public void cancelByTicketId(String id) throws IOException {
        IngressoManager ingressoManager = new IngressoManager();
        List<Ingresso> ingressos = ingressoManager.lerConteudoArquivo();
        for (Ingresso ingresso : ingressos) {
            if (ingresso.getId().equals(id)) {
                ingresso.cancelarIngresso();
            }
        }
    }

    public String getSeatByTicketId(String id) throws IOException {
        IngressoManager ingressoManager = new IngressoManager();
        List<Ingresso> ingressos = ingressoManager.lerConteudoArquivo();
        for (Ingresso ingresso : ingressos) {
            if (ingresso.getId().equals(id)) {
                return ingresso.getAssento();
            }
        }
        return null;
    }

    public void reactiveById(String id) throws IOException {
        IngressoManager ingressoManager = new IngressoManager();
        List<Ingresso> ingressos = ingressoManager.lerConteudoArquivo();
        for (Ingresso ingresso : ingressos) {
            if (ingresso.getId().equals(id)) {
                ingresso.reativar();
            }
        }
    }

    public boolean getIsAdminTicketId(String id){

    }

    public Ingresso getById(String id) throws IOException {
        IngressoManager ingressoManager = new IngressoManager();
        List<Ingresso> ingressos = ingressoManager.lerConteudoArquivo();
        for (Ingresso ingresso : ingressos) {
            if (ingresso.getId().equals(id)) {
                return ingresso;
            }
        }
        return null;
    }

    public boolean getIsActive(String id) throws IOException {
        IngressoManager ingressoManager = new IngressoManager();
        List<Ingresso> ingressos = ingressoManager.lerConteudoArquivo();
        for (Ingresso ingresso : ingressos) {
            if (ingresso.getId().equals(id)) {
                return ingresso.isAtivo();
            }
        }
        return false;
    }

    public void deleteAllTickets(){
     
    }
}
