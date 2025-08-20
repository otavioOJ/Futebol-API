package br.inatel.cdg;

public class Titulo {
    private String nome;
    private int ano;

    public Titulo(String nome, int ano) {
        this.nome = nome;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return nome + " (" + ano + ")";
    }
}
