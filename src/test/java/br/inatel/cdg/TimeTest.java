package br.inatel.cdg;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class TimeTest {

    private Jogador j(String nome) {
        return new Jogador(nome, "01/01/2000", "Atacante", "Direito", 1920.0, 87.0);
    }

    private Titulo t(String nome, int ano) {
        return new Titulo(nome, ano);
    }

    @Test
    void deveCriarTimeComNomeEAno() {
        Time time = new Time("Corinthians", 1910);
        assertEquals("Corinthians", time.getNome());
        assertEquals(1910, time.getAnoFundacao());
    }

    @Test
    void deveAdicionarJogador() {
        Time time = new Time("Corinthians", 1910);
        time.adicionarJogador(j("Otávio"));
        assertEquals(1, time.getJogadores().size());
        assertEquals("Otávio", time.getJogadores().get(0).getNome());
    }

    @Test
    void deveAdicionarTitulo() {
        Time time = new Time("Inatel", 1992);
        time.adicionarTitulo(t("Copa X", 2020));
        assertEquals(1, time.getTitulos().size());
        assertEquals("Copa X", time.getTitulos().get(0).getNome());
    }

    @Test
    void ordemJogadoresPreservada() {
        Time time = new Time("Corinthians", 1910);
        time.adicionarJogador(j("A"));
        time.adicionarJogador(j("B"));
        time.adicionarJogador(j("C"));
        List<Jogador> js = time.getJogadores();
        assertEquals("A", js.get(0).getNome());
        assertEquals("B", js.get(1).getNome());
        assertEquals("C", js.get(2).getNome());
    }

    @Test
    void ordemTitulosPreservada() {
        Time time = new Time("Corinthians", 1910);
        time.adicionarTitulo(t("Titulo1", 2019));
        time.adicionarTitulo(t("Titulo2", 2020));
        assertEquals("Titulo1", time.getTitulos().get(0).getNome());
        assertEquals("Titulo2", time.getTitulos().get(1).getNome());
    }

    @Test
    void toStringContemNomeEAno() {
        Time time = new Time("Corinthians", 1910);
        String s = time.toString();
        assertTrue(s.contains("Corinthians"));
        assertTrue(s.contains("1910"));
    }

    @Test
    void getJogadoresEhImutavel() {
        Time time = new Time("Corinthians", 1910);
        List<Jogador> view = time.getJogadores();
        assertThrows(UnsupportedOperationException.class, () -> view.add(j("X")));
    }

    @Test
    void getTitulosEhImutavel() {
        Time time = new Time("Corinthians", 1910);
        List<Titulo> view = time.getTitulos();
        assertThrows(UnsupportedOperationException.class, () -> view.add(t("Y", 2020)));
    }

    @Test
    void adicionarJogadorNullNaoLancaExcecao() {
        Time time = new Time("Corinthians", 1910);
        assertDoesNotThrow(() -> time.adicionarJogador(null));
        assertEquals(1, time.getJogadores().size());
        assertNull(time.getJogadores().get(0));
    }

    @Test
    void adicionarTituloNullNaoLancaExcecao() {
        Time time = new Time("Corinthians", 1910);
        assertDoesNotThrow(() -> time.adicionarTitulo(null));
        assertEquals(1, time.getTitulos().size());
        assertNull(time.getTitulos().get(0));
    }

    @Test
    void nomeVazioAceitoSemValidacao() {
        Time time = new Time("", 1910);
        assertEquals("", time.getNome());
    }

    @Test
    void naoDeveAceitarAnoFundacaoNegativo() {
        int[] anosInvalidos = {-1, -10, -1992};

        for (int ano : anosInvalidos) {
            assertThrows(IllegalArgumentException.class,
                    () -> new Time("Corinthians", ano),
                    "Deveria lançar exceção para ano " + ano);
        }
    }

    @Test
    void tituloToStringBasico() {
        Titulo t = new Titulo("Copa do Brasil", 2025);
        assertTrue(t.toString().contains("Copa do Brasil"));
    }

    @Test
    void naoDeveAceitarAlturaNegativa() {
        double[] alturasInvalidas = {-168, -190, -180};

        for (double altura : alturasInvalidas) {
            IllegalArgumentException ex = assertThrows(
                    IllegalArgumentException.class,
                    () -> new Jogador("Otávio", "04/10/2004", "Atacante", "Direito", altura, 87)
            );
            assertTrue(ex.getMessage().contains("Altura não pode ser negativa"));
        }
    }

    @Test
    void naoDeveAceitarPesoNegativo() {
        double[] pesosInvalidos = {-66, -70, -87};

        for (double peso : pesosInvalidos) {
            IllegalArgumentException ex = assertThrows(
                    IllegalArgumentException.class,
                    () -> new Jogador("Y", "01/01/2000", "Atacante", "Direito", 180, peso)
            );
            assertTrue(ex.getMessage().contains("Peso não pode ser negativo"));
        }
    }


    @Test
    void naoDeveAceitarNomeNull() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> new Titulo(null, 1999)
        );
        assertTrue(ex.getMessage().contains("não pode ser nulo"));
    }

    @Test
    void naoDeveAceitarNomeVazio() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> new Titulo("", 1999)
        );
        assertTrue(ex.getMessage().contains("não pode ser nulo"));
    }





}
