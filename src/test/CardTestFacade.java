import vendaingressos.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class CardTestFacade {


    public CardTestFacade() {

    }

    public String create(String userEmail, String cardNumber, Date expiryDate, int cvv) throws IOException {
        CardManager cardManager = new CardManager();
        List<Card> cards = cardManager.lerConteudoArquivo();
        for(Card card1 : cards){
           if(card1.getNumerodoCartao().equals(cardNumber)){
               throw new SecurityException("Cartão com este número já existe.");
           }
           else {
               UsuarioManager usuarioManager = new UsuarioManager();
               List<Usuario> usuarios = usuarioManager.lerConteudoArquivo();
               for (Usuario usuario : usuarios) {
                   if (usuario.getEmail().equals(userEmail)) {
                       Card card = new Card(usuario.getId(), usuario.getNome(),cardNumber, expiryDate, cvv);
                       cardManager.adicionarCardNoArquivo(card);
                       return usuario.getId();
                   }
               }
               return null;
           }
        }
        return null;
    }

    public String getUserNameByCardId(String cardId) throws IOException {
        CardManager cardManager = new CardManager();
        List<Card> cards = cardManager.lerConteudoArquivo();
        for (Card card : cards) {
            if (card.getIdUsuario().equals(cardId)) {
                return card.getNomedoCartao();
            }
        }
        return null;
    }

    public String getCardNumberByCardId(String cardId) throws IOException {
        CardManager cardManager = new CardManager();
        List<Card> cards = cardManager.lerConteudoArquivo();
        for (Card card : cards) {
            if (card.getIdUsuario().equals(cardId)) {
                return card.getNumerodoCartao();
            }
        }
        return null;
    }

    public int getYearByCardId(String cardId) throws IOException {
        CardManager cardManager = new CardManager();
        List<Card> cards = cardManager.lerConteudoArquivo();
        for (Card card : cards) {
            if (card.getIdUsuario().equals(cardId)) {
                return card.getValidade().getYear();
            }
        }
        return 0;
    }

    public int getMonthByCardId(String cardId) throws IOException {
        CardManager cardManager = new CardManager();
        List<Card> cards = cardManager.lerConteudoArquivo();
        for (Card card : cards) {
            if (card.getIdUsuario().equals(cardId)) {
                return card.getValidade().getMonth();
            }
        }
        return 0;
    }

    public int getDayByCardId(String cardId) throws IOException {
        CardManager cardManager = new CardManager();
        List<Card> cards = cardManager.lerConteudoArquivo();
        for (Card card : cards) {
            if (card.getIdUsuario().equals(cardId)) {
                return card.getValidade().getDay();
            }
        }
        return 0;
    }

    public void disable(String cardId) throws IOException {
        CardManager cardManager = new CardManager();
        List<Card> cards = cardManager.lerConteudoArquivo();
        cards.removeIf(card -> card.getIdUsuario().equals(cardId));
    }

    public boolean getStatusByCardId(String cardId) throws IOException {
        CardManager cardManager = new CardManager();
        List<Card> cards = cardManager.lerConteudoArquivo();
        for (Card card : cards) {
            if (card.getIdUsuario().equals(cardId)) {
                return true;
            }
        }
        return false;
    }

    public void delete(String cardId) throws IOException {
        CardManager cardManager = new CardManager();
        List<Card> cards = cardManager.lerConteudoArquivo();
        cards.removeIf(card -> card.getIdUsuario().equals(cardId));
    }

    public Card getById(String id) throws IOException {
        CardManager cardManager = new CardManager();
        List<Card> cards = cardManager.lerConteudoArquivo();
        for (Card card : cards) {
            if (card.getIdUsuario().equals(id)) {
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