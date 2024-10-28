package vendaingressos;

public class Compra {

    private String email;

    private String idCompra;

    private String idEvento;

    private String idCard;

    private String seat;

    public Compra(String email, String idCompra, String idEvento, String idCard, String seat){
        this.email = email;
        this.idCompra = idCompra;
        this.idEvento = idEvento;
        this.idCard = idCard;
        this.seat = seat;
    }

    public String getEmail() {
        return email;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getIdCompra() {
        return idCompra;
    }

    public String getIdEvento() {
        return idEvento;
    }

    public String getSeat() {
        return seat;
    }
}
