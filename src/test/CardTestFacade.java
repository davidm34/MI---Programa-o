import vendaingressos.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CardTestFacade {


    public CardTestFacade() {

    }

    public String create(String userEmail, String cardNumber, Date expiryDate, int cvv) throws IOException {
        CardManager cardManager = new CardManager();
        List<Card> cards = cardManager.lerConteudoArquivo();

        // Verifica se já existe um cartão com o mesmo número
        for (Card card : cards) {
            if (card.getNumerodoCartao().equals(cardNumber)) {
                throw new SecurityException("Cartão com este número já existe.");
            }
        }

        // Verifica se o usuário existe
        UsuarioManager usuarioManager = new UsuarioManager();
        List<Usuario> usuarios = usuarioManager.lerConteudoArquivo();
        Usuario usuario = usuarios.stream()
                .filter(u -> u.getEmail().equals(userEmail))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));

        // Cria um novo cartão com um ID único
        String cardId = UUID.randomUUID().toString();
        Card card = new Card(cardId, usuario.getId(), usuario.getNome(), cardNumber, expiryDate, cvv);
        cards.add(card);

        // Salva a lista atualizada de cartões no arquivo
        cardManager.salvarCardsNoArquivo(cards);

        return cardId;
    }



    public String getUserNameByCardId(String cardId) throws IOException {
        CardManager cardManager = new CardManager();
        List<Card> cards = cardManager.lerConteudoArquivo();
        for (Card card : cards) {
            if (card.getIdCartao().equals(cardId)) {
                return card.getNomedoCartao();
            }
        }
        return null;
    }

    public String getCardNumberByCardId(String cardId) throws IOException {
        CardManager cardManager = new CardManager();
        List<Card> cards = cardManager.lerConteudoArquivo();
        for (Card card : cards) {
            if (card.getIdCartao().equals(cardId)) {
                return card.getNumerodoCartao();
            }
        }
        return null;
    }

    public int getYearByCardId(String cardId) throws IOException {
        CardManager cardManager = new CardManager();
        List<Card> cards = cardManager.lerConteudoArquivo();
        for (Card card : cards) {
            if (card.getIdCartao().equals(cardId)) {
                return card.getValidade().getYear();
            }
        }
        return 0;
    }

    public int getMonthByCardId(String cardId) throws IOException {
        CardManager cardManager = new CardManager();
        List<Card> cards = cardManager.lerConteudoArquivo();
        for (Card card : cards) {
            if (card.getIdCartao().equals(cardId)) {
                return card.getValidade().getMonth();
            }
        }
        return 0;
    }

    public int getDayByCardId(String cardId) throws IOException {
        CardManager cardManager = new CardManager();
        List<Card> cards = cardManager.lerConteudoArquivo();
        for (Card card : cards) {
            if (card.getIdCartao().equals(cardId)) {
                return card.getValidade().getDay();
            }
        }
        return 0;
    }

    public void disable(String cardId) throws IOException {
        delete(cardId);
    }

    public boolean getStatusByCardId(String cardId) throws IOException {
        CardManager cardManager = new CardManager();
        List<Card> cards = cardManager.lerConteudoArquivo();
        for (Card card : cards) {
            if (card.getIdCartao().equals(cardId)) {
                return true;
            }
        }
        return false;
    }

    public void delete(String c1Id) throws IOException {
        CardManager cardManager = new CardManager();
        List<Card> cards = cardManager.lerConteudoArquivo();

        // Remover a avaliação da lista com base no ID fornecido
        cards.removeIf(card -> card.getIdCartao().equals(c1Id));

        // Salvar a lista atualizada no arquivo JSON
        cardManager.salvarCardsNoArquivo(cards);
    }

    public Card getById(String id) throws IOException {
        CardManager cardManager = new CardManager();
        List<Card> cards = cardManager.lerConteudoArquivo();
        for (Card card : cards) {
            if (card.getIdCartao().equals(id)) {
                return card;
            }
        }
        return null;
    }

    public void deleteAllCards() throws IOException {
        CardManager cardManager = new CardManager();
        cardManager.limparArquivoJson();
    }
}