public class Usuario {
    private String login;
    private String senha;
    private String nome;
    private String cpf;
    private String email;
    private boolean admin;
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

    public boolean login(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }

    public String setSenha(String senha){
        this.senha = senha;
    }

    public String setNome(String nome){
        this.nome = nome;
    }

    public String setCpf(String cpf){
        this.cpf = cpf;
    }

    public String setEmail(String email){
        this.email = email;
    }



}
