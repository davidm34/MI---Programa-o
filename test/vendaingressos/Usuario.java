package vendaingressos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
    private String login;
    private String senha;
    private String nome;
    private String cpf;
    private String email;
    private Boolean admin;

    List<Ingresso> ingressos = new ArrayList<>();
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
        return this.senha = senha;
    }

    public String setNome(String nome){
        return this.nome = nome;
    }

    public String setCpf(String cpf){
        return this.cpf = cpf;
    }

    public String setEmail(String email){
        return this.email = email;
    }

    public void addIngresso(Ingresso ingresso){
        ingressos.add(ingresso);
    }

    public void removeIngresso(Ingresso ingresso){
        ingressos.remove(ingresso);
    }

    public List<Ingresso> getIngressos(){
        return ingressos;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(login, usuario.login) &&
                Objects.equals(cpf, usuario.cpf) &&
                Objects.equals(email, usuario.email);
    }

    public int hashCode() {
        return Objects.hash(login, cpf, email);
    }

}
