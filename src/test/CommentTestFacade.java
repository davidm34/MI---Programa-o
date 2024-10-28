import vendaingressos.Avaliacao;
import vendaingressos.AvaliacaoManager;
import vendaingressos.Usuario;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CommentTestFacade {


    public CommentTestFacade() {
        
    }

    public String create(String userID, String eventID, int rating, String content) throws IOException {
        EventTestFacade eventTestFacade = new EventTestFacade();
        Date data_atual = new Date();
        if(eventTestFacade.getDateByEventId(eventID).after(data_atual)) {
            throw new SecurityException("Comentário só pode ser adicionando após a realização do evento.");
        }
        UUID uuid = UUID.randomUUID();
        String id = String.valueOf(uuid);
        Avaliacao avaliacao = new Avaliacao(userID, eventID, id, rating, content);
        AvaliacaoManager avaliacaoManager = new AvaliacaoManager();
        avaliacaoManager.adicionarAvaliacaoNoArquivo(avaliacao);
        return id;
    }

    public Avaliacao getById(String id) throws IOException {
        AvaliacaoManager avaliacaoManager = new AvaliacaoManager();
        List<Avaliacao> avaliacoes = avaliacaoManager.lerConteudoArquivo();
        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao.getId().equals(id)) {
                return avaliacao;
            }
        }
        return null;
    }

    public String getContentById(String id) throws IOException {
        AvaliacaoManager avaliacaoManager = new AvaliacaoManager();
        List<Avaliacao> avaliacoes = avaliacaoManager.lerConteudoArquivo();
        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao.getId().equals(id)) {
                return avaliacao.getComentarios();
            }
        }
        return null;
    }

    public int getRatingCommentById(String id) throws IOException {
        AvaliacaoManager avaliacaoManager = new AvaliacaoManager();
        List<Avaliacao> avaliacoes = avaliacaoManager.lerConteudoArquivo();
        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao.getId().equals(id)) {
                return avaliacao.getAvaliacao();
            }
        }
        return -1;
    }

    public String getUserIdById(String id) throws IOException {
        AvaliacaoManager avaliacaoManager = new AvaliacaoManager();
        List<Avaliacao> avaliacoes = avaliacaoManager.lerConteudoArquivo();
        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao.getId().equals(id)) {
                return avaliacao.getIdUsuario();
            }
        }
        return null;
    }

    public String getEventIdById(String id) throws IOException {
        AvaliacaoManager avaliacaoManager = new AvaliacaoManager();
        List<Avaliacao> avaliacoes = avaliacaoManager.lerConteudoArquivo();
        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao.getId().equals(id)) {
                return avaliacao.getIdEvento();
            }
        }
        return null;
    }

    public void deleteAllComments() throws IOException {
        AvaliacaoManager avaliacaoManager = new AvaliacaoManager();
        avaliacaoManager.limparArquivoJson();
    }

    public double getEventRatingByEventId(String eventId) throws IOException {
        int rating = 0;
        int tam = 0;
        AvaliacaoManager avaliacaoManager = new AvaliacaoManager();
        List<Avaliacao> avaliacoes = avaliacaoManager.lerConteudoArquivo();
        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao.getIdEvento().equals(eventId)) {
                rating += avaliacao.getAvaliacao();
                tam++;
            }
        }
        return (double) rating / tam;
    }

    public void delete(String c1Id) throws IOException {
        AvaliacaoManager avaliacaoManager = new AvaliacaoManager();
        List<Avaliacao> avaliacoes = avaliacaoManager.lerConteudoArquivo();

        // Remover a avaliação da lista com base no ID fornecido
        avaliacoes.removeIf(avaliacao -> avaliacao.getId().equals(c1Id));

        // Salvar a lista atualizada no arquivo JSON
        avaliacaoManager.salvarAvaliacoesNoArquivo(avaliacoes);
    }

}
