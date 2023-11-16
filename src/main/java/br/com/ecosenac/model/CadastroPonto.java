package br.com.ecosenac.model;

public class CadastroPonto {
    private String nome;
    private String endereco;
    private int numero;
    private String cep;
 

    @Override
    public String toString() {
        return "Nome: " + nome + ", Endereço: " + endereco + ", Número: " + numero + ", CEP: " + cep;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getEndereco() {
        return endereco;
    }


    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public int getNumero() {
        return numero;
    }


    public void setNumero(int numero) {
        this.numero = numero;
    }


    public String getCep() {
        return cep;
    }


    public void setCep(String cep) {
        this.cep = cep;
    }
}


