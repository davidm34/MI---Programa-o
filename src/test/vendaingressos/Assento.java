package vendaingressos;

public class Assento {

    private String idEvento;

    private String seat;

    public Assento(String idEvento, String seat){
        this.idEvento = idEvento;
        this.seat = seat;
    }

    public String getIdEvento() {
        return idEvento;
    }

    public String getSeat() {
        return seat;
    }
}
