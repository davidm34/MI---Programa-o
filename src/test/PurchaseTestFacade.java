/*
import vendaingressos.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class PurchaseTestFacade {

    public PurchaseTestFacade() {

    }

    public String create(String login, String eventId, String cardId, String seat) throws IOException {
        UUID uuid = UUID.randomUUID();
        String id = String.valueOf(uuid);
        Compra compra = new Compra(id, eventId, cardId, seat);
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
                return compra.get;
            }
        }
        return null;
    }

    public String getTicketByPurchaseId(String id){

    }

    public int getUserMailBoxByPurchaseId(String id){
        
    }

    public Card getCardByPurchaseID(String id){
        
    }

    public void deleteAllPurchases(){
        
    }
}
*/