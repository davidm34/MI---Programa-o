public class Usuario (String login, String senha, String nome, String cpf, String email, Boolean admin){
    public Usuario(String login, String senha, String nome, String cpf, String email, Boolean admin){
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.admin = admin;
    }

    public String getLogin(){
        return login;
    }

    public String getNome(){
        return nome;
    }

    public String getCpf(){
        return cpf;
    }

    public String getEmail(){
        return email;
    }

    public Boolean isAdmin(){
        return admin;
    }



}
