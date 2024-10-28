import vendaingressos.*;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class PurchaseTestFacade {

    public PurchaseTestFacade() {

    }

    public String create(String email, String eventId, String cardId, String seat) throws IOException {
        // Gera um ID para a compra
        UUID uuid = UUID.randomUUID();
        String id = String.valueOf(uuid);
        // Cria e adiciona a compra ao arquivo
        Compra compra = new Compra(email, id, eventId, cardId, seat);
        CompraManager compraManager = new CompraManager();
        compraManager.adicionarCompraNoArquivo(compra);

        return id;
    }


    public Compra getById(String id) throws IOException {
        CompraManager compraManager = new CompraManager();
        List<Compra> compras = compraManager.lerConteudoArquivo();
        for (Compra compra : compras) {
            if (compra.getIdCompra().equals(id)) {
                return compra;
            }
        }
        return null;
    }

    public String getEventByPurchaseId(String id) throws IOException {
        CompraManager compraManager = new CompraManager();
        List<Compra> compras = compraManager.lerConteudoArquivo();
        for (Compra compra : compras) {
            if (compra.getIdCompra().equals(id)) {
                return compra.getIdEvento();
            }
        }
        return null;
    }

    public String getUserLoginByPurchaseId(String id) throws IOException {
        CompraManager compraManager = new CompraManager();
        List<Compra> compras = compraManager.lerConteudoArquivo();
        for (Compra compra : compras) {
            if (compra.getIdCompra().equals(id)) {
                return compra.getEmail();
            }
        }
        return null;
    }

    public String getTicketByPurchaseId(String id) throws IOException {
        CompraManager compraManager = new CompraManager();
        List<Compra> compras = compraManager.lerConteudoArquivo();
        for (Compra compra : compras) {
            if (compra.getIdCompra().equals(id)) {
                return compra.getIdCompra();
            }
        }
        return null;
    }

    public int getUserMailBoxByPurchaseId(String id) throws IOException {
        CompraManager compraManager = new CompraManager();
        List<Compra> compras = compraManager.lerConteudoArquivo();
        int size = 0;
        for (Compra compra : compras) {
            if (compra.getIdCompra().equals(id)) {
                size++;
            }
        }
        return size;
    }

    public Card getCardByPurchaseID(String id) throws IOException {
        CompraManager compraManager = new CompraManager();
        List<Compra> compras = compraManager.lerConteudoArquivo();
        for (Compra compra : compras) {
            if (compra.getIdCompra().equals(id)) {
                CardTestFacade cardTestFacade = new CardTestFacade();
                return cardTestFacade.getById(compra.getIdCard());
            }
        }
        return null;
    }

    public void deleteAllPurchases() throws IOException {
        CompraManager compraManager = new CompraManager();
        compraManager.limparArquivoJson();
    }
}