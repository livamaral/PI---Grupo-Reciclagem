package br.com.ecosenac.model;

public class User {

    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String id;

    public User() {
    }

    public User(String nome, String email, String senha, String telefone, String id) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.id = id;
    }

    public User(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getName() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getSenha() {
        return senha;
    }

    public String getUserId() {
        return id;
    }

}
