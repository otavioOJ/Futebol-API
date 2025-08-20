package br.inatel.cdg;

public class Jogador {
    private String nome;
    private String dataNascimento;
    private String posicao;
    private String peDominante;
    private double altura;
    private double peso;

    public Jogador(String nome, String dataNascimento, String posicao, String peDominante, double altura, double peso) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.posicao = posicao;
        this.peDominante = peDominante;
        this.altura = altura;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Jogador: " + nome + " | Nascimento: " + dataNascimento +
                " | Posição: " + posicao + " | Pé: " + peDominante +
                " | Altura: " + altura + "m | Peso: " + peso + "kg";
    }
}
