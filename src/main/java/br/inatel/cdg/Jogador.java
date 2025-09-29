package br.inatel.cdg;

public class Jogador {
    private Integer id;
    private String nome;
    private String dataNascimento;
    private String posicao;
    private String peDominante;
    private double altura;
    private double peso;

    public Jogador(String nome, String dataNascimento, String posicao,
                   String peDominante, double altura, double peso) {

        if (altura < 0) {
            throw new IllegalArgumentException("Altura não pode ser negativa");
        }
        if (peso < 0) {
            throw new IllegalArgumentException("Peso não pode ser negativo");
        }

        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.posicao = posicao;
        this.peDominante = peDominante;
        this.altura = altura;
        this.peso = peso;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

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
