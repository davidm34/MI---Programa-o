package vendaingressos;

import java.util.*;

public class Controller {
    private List<Usuario> usuarios;
    private List<Evento> eventos;

    public Controller() {
        usuarios = new ArrayList<>();
        eventos = new ArrayList<>();
    }

    public Usuario cadastrarUsuario(String username, String password, String nome, String cpf, String email, boolean isAdmin) {
        Usuario usuario = new Usuario(username, password, nome, cpf, email, isAdmin);
        usuarios.add(usuario);
        return usuario;
    }

    public Evento cadastrarEvento(Usuario admin, String nome, String descricao, Date data) {
        if (!admin.isAdmin()) {
            throw new SecurityException("Somente administradores podem cadastrar eventos.");
        }

        Evento evento = new Evento(nome, descricao, data);
        eventos.add(evento);
        return evento;
    }

    public void adicionarAssentoEvento(String nomeEvento, String assento) {
        Evento evento = buscarEventoPorNome(nomeEvento);
        if (evento != null) {
            evento.adicionarAssento(assento);
        }
    }


    public Ingresso comprarIngresso(Usuario usuario, String nomeEvento, String assento) {
        Evento evento = buscarEventoPorNome(nomeEvento);
        if (evento != null && evento.getAssentosDisponiveis().contains(assento)) {
            evento.removerAssento(assento);
            Ingresso ingresso = new Ingresso(evento, 100.0, assento);
            usuario.addIngresso(ingresso);
            return ingresso;
        }
        return null;
    }

    public boolean cancelarCompra(Usuario usuario, Ingresso ingresso) {
        if (usuario.getIngressos().contains(ingresso)) {
            ingresso.cancelar();
            usuario.removeIngresso(ingresso);
            return true;
        }
        return false;
    }

    public List<Evento> listarEventosDisponiveis() {
        return eventos;
    }

    public List<Ingresso> listarIngressosComprados(Usuario usuario) {
        return usuario.getIngressos();
    }

    private Evento buscarEventoPorNome(String nome) {
        for (Evento evento : eventos) {
            if (evento.getNome().equals(nome)) {
                return evento;
            }
        }
        return null;
    }
}
