package br.inatel.cdg;

import java.util.ArrayList;
import java.util.List;

class Time {
    private String nome;
    private int anoFundacao;
    private List<Jogador> jogadores = new ArrayList<>();
    private List<Titulo> titulos = new ArrayList<>();

    public Time(String nome, int anoFundacao) {
        this.nome = nome;
        this.anoFundacao = anoFundacao;
    }

    public void adicionarJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    public void adicionarTitulo(Titulo titulo) {
        titulos.add(titulo);
    }

    public void listarJogadores() {
        if (jogadores.isEmpty()) {
            System.out.println("Nenhum jogador cadastrado.");
        } else {
            for (Jogador j : jogadores) {
                System.out.println(j);
            }
        }
    }

    public void listarTitulos() {
        if (titulos.isEmpty()) {
            System.out.println("Nenhum título cadastrado.");
        } else {
            for (Titulo t : titulos) {
                System.out.println(t);
            }
        }
    }

    @Override
    public String toString() {
        return "Time: " + nome + " | Fundação: " + anoFundacao +
                " | Jogadores: " + jogadores.size() +
                " | Títulos: " + titulos.size();
    }

    public String getNome() {
        return nome;
    }
}
