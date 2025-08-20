package br.inatel.cdg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Time> times = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Cadastrar time");
            System.out.println("2. Cadastrar jogador em um time");
            System.out.println("3. Cadastrar título em um time");
            System.out.println("4. Listar times");
            System.out.println("5. Listar jogadores de um time");
            System.out.println("6. Listar títulos de um time");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // consumir a quebra de linha

            switch(opcao) {
                case 1:
                    cadastrarTime();
                    break;
                case 2:
                    cadastrarJogador();
                    break;
                case 3:
                    cadastrarTitulo();
                    break;
                case 4:
                    listarTimes();
                    break;
                case 5:
                    listarJogadoresTime();
                    break;
                case 6:
                    listarTitulosTime();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while(opcao != 0);
    }

    private static void cadastrarTime() {
        System.out.print("Nome do time: ");
        String nome = sc.nextLine();
        System.out.print("Ano de fundação: ");
        int ano = sc.nextInt();
        sc.nextLine();
        times.add(new Time(nome, ano));
        System.out.println("Time cadastrado com sucesso!");
    }

    private static Time escolherTime() {
        if (times.isEmpty()) {
            System.out.println("Nenhum time cadastrado.");
            return null;
        }

        System.out.println("Escolha o time:");
        for (int i = 0; i < times.size(); i++) {
            System.out.println((i+1) + ". " + times.get(i).getNome());
        }
        int escolha = sc.nextInt();
        sc.nextLine();
        if (escolha < 1 || escolha > times.size()) {
            System.out.println("Opção inválida!");
            return null;
        }
        return times.get(escolha - 1);
    }

    private static void cadastrarJogador() {
        Time time = escolherTime();
        if (time == null) return;

        System.out.print("Nome do jogador: ");
        String nome = sc.nextLine();
        System.out.print("Data de nascimento (dd/mm/aaaa): ");
        String data = sc.nextLine();
        System.out.print("Posição: ");
        String posicao = sc.nextLine();
        System.out.print("Pé dominante: ");
        String pe = sc.nextLine();
        System.out.print("Altura (cm): ");
        double altura = sc.nextDouble();
        System.out.print("Peso (kg): ");
        double peso = sc.nextDouble();
        sc.nextLine();

        Jogador jogador = new Jogador(nome, data, posicao, pe, altura, peso);
        time.adicionarJogador(jogador);
        System.out.println("Jogador cadastrado com sucesso!");
    }

    private static void cadastrarTitulo() {
        Time time = escolherTime();
        if (time == null) return;

        System.out.print("Nome do título: ");
        String nome = sc.nextLine();
        System.out.print("Ano do título: ");
        int ano = sc.nextInt();
        sc.nextLine();

        Titulo titulo = new Titulo(nome, ano);
        time.adicionarTitulo(titulo);
        System.out.println("Título cadastrado com sucesso!");
    }

    private static void listarTimes() {
        if (times.isEmpty()) {
            System.out.println("Nenhum time cadastrado.");
        } else {
            for (Time t : times) {
                System.out.println(t);
            }
        }
    }

    private static void listarJogadoresTime() {
        Time time = escolherTime();
        if (time == null) return;
        time.listarJogadores();
    }

    private static void listarTitulosTime() {
        Time time = escolherTime();
        if (time == null) return;
        time.listarTitulos();
    }
}