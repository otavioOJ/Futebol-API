package br.inatel.cdg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Time {
    private String nome;
    private int anoFundacao;
    private final List<Jogador> jogadores = new ArrayList<>();
    private final List<Titulo> titulos = new ArrayList<>();

    public Time(String nome, int anoFundacao) {
        this.nome = nome;
        this.anoFundacao = anoFundacao;

        if (anoFundacao < 0) {
            throw new IllegalArgumentException("Ano de fundação não pode ser negativo");
        }
        this.nome = nome;
        this.anoFundacao = anoFundacao;
    }

    public void adicionarJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    public void adicionarTitulo(Titulo titulo) {
        titulos.add(titulo);
    }

    public List<Jogador> getJogadores() {
        return Collections.unmodifiableList(jogadores);
    }

    public List<Titulo> getTitulos() {
        return Collections.unmodifiableList(titulos);
    }

    public String getNome() { return nome; }
    public int getAnoFundacao() { return anoFundacao; }

    @Override
    public String toString() {
        return "Time{" +
                "nome='" + nome + '\'' +
                ", anoFundacao=" + anoFundacao +
                ", jogadores=" + jogadores.size() +
                ", titulos=" + titulos.size() +
                '}';
    }
}
