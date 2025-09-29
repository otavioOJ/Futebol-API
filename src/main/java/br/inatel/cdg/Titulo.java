package br.inatel.cdg;

public class Titulo {
    private Integer id;
    private String nome;
    private int ano;

    public Titulo(String nome, int ano) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do título não pode ser nulo ou vazio");
        }
        if (ano < 0) {
            throw new IllegalArgumentException("Ano do título não pode ser negativo");
        }


        this.nome = nome;
        this.ano = ano;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() {
        return nome;
    }
    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return "Titulo{" +
                "nome='" + nome + '\'' +
                ", ano=" + ano +
                '}';
    }
}
