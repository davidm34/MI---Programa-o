package vendaingressos;

public class Controller{


    public Usuario cadastrarUsuario(String login, String senha, String nome, String cpf, String email, Boolean admin){
        return Usuario(String login, String senha, String nome, String cpf, String email, Boolean admin);
    }

    public vendaingressos.Evento cadastrarEvento(Usuario usuario, String nome, String descricao, Date data){
        if (usuario.isAdmin()){
            return vendaingressos.Evento(String nome, String descricao, Date data);
        }
        return throw new SecurityException("Somente administradores podem cadastrar eventos.");
    }



}


