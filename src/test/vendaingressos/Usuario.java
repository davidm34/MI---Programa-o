package vendaingressos;

import java.io.IOException;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
    private String login;
    private String senha;
    private String nome;
    private String cpf;
    private String email;
    private Boolean isadmin;

    private String id;

    List<Ingresso> ingressos = new ArrayList<>();

    public Usuario(String login, String senha, String nome, String cpf, String email, Boolean isadmin){
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.isadmin = isadmin;
    }

    public Usuario(String login, String senha, String nome, String cpf, String email, Boolean isadmin, String id){
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.isadmin = isadmin;
        this.id = id;
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

    public String getSenha(){ return senha; }

    public String getId(){ return id; }

    public Boolean isAdmin(){
        return isadmin;
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

    public boolean equals(Object objeto) {
        if (this == objeto){
            return true;
        }
        if (objeto == null || getClass() != objeto.getClass()) {
            return false;
        }
        Usuario usuario = (Usuario) objeto;
        return Objects.equals(login, usuario.login) && Objects.equals(cpf, usuario.cpf) && Objects.equals(email, usuario.email);
    }

    public int hashCode() {
        return Objects.hash(login, cpf, email);
    }

}
