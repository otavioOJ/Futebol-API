package br.inatel.cdg;

public class Jogador {
    private String nome;
    private String dataNascimento;  // ✅ o Main pede data (dd/mm/aaaa)
    private String posicao;
    private String peDominante;
    private double altura;          // ✅ numérico
    private double peso;            // ✅ numérico

    // ✅ bater com o construtor usado no Main
    public Jogador(String nome, String dataNascimento, String posicao,
                   String peDominante, double altura, double peso) {

        if (altura < 0) throw new IllegalArgumentException("Altura não pode ser negativa");
        if (peso < 0) throw new IllegalArgumentException("Peso não pode ser negativo");

        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.posicao = posicao;
        this.peDominante = peDominante;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNome() { return nome; }
    public String getDataNascimento() { return dataNascimento; }
    public String getPosicao() { return posicao; }
    public String getPeDominante() { return peDominante; }
    public double getAltura() { return altura; }
    public double getPeso() { return peso; }

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", posicao='" + posicao + '\'' +
                ", peDominante='" + peDominante + '\'' +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }
}
