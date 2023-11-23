package br.com.ecosenac.model;

public class Ponto {

    private String nome;
    private String endereco;
    private String cep;


    public Ponto() {
    }

    public Ponto(String nome, String endereco, String cep) {
        this.nome = nome;
        this.endereco = endereco;
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCep() {
        return cep;
    }

}
