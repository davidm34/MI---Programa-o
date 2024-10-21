import org.junit.Test;
import vendaingressos.Avaliacao;
import vendaingressos.Evento;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class EventoTest {

    @Test
    public void testCriarEvento() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.SEPTEMBER, 10);
        Date data = calendar.getTime();

        Evento evento = new Evento("Show de Rock", "Banda XYZ", data);

        assertNotNull(evento);
        assertEquals("Show de Rock", evento.getNome());
        assertEquals("Banda XYZ", evento.getDescricao());
        assertEquals(data, evento.getData());
    }

    @Test
    public void testAdicionarAssento() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.SEPTEMBER, 10);
        Date data = calendar.getTime();

        Evento evento = new Evento("Show de Rock", "Banda XYZ", data);
        evento.adicionarAssento("A1");

        List<String> assentos = evento.getAssentosDisponiveis();
        assertTrue(assentos.contains("A1"));
    }

    @Test
    public void testRemoverAssento() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.SEPTEMBER, 10);
        Date data = calendar.getTime();

        Evento evento = new Evento("Show de Rock", "Banda XYZ", data);
        evento.adicionarAssento("A1");
        evento.removerAssento("A1");

        List<String> assentos = evento.getAssentosDisponiveis();
        assertFalse(assentos.contains("A1"));
    }

    @Test
    public void testEventoAtivo() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.SEPTEMBER, 10);
        Date data = calendar.getTime();

        Evento evento = new Evento("Show de Rock", "Banda XYZ", data);

        assertTrue(evento.isAtivo());
    }

    @Test
    public void testEventoInativo() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.JANUARY, 10);
        Date data = calendar.getTime();

        Evento evento = new Evento("Show de Rock", "Banda XYZ", data);

        assertFalse(evento.isAtivo());
    }


}
