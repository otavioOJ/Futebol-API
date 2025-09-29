package br.inatel.cdg;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TimeDAO {
    public int salvar(Time time) {
        String sql = "INSERT INTO times (nome, ano_fundacao) VALUES (?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, time.getNome());
            ps.setInt(2, time.getAnoFundacao());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    time.setId(id);
                    return id;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    public Time findById(int id) {
        String sql = "SELECT id, nome, ano_fundacao FROM times WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Time time = new Time(rs.getString("nome"), rs.getInt("ano_fundacao"));
                    time.setId(rs.getInt("id"));

                    JogadorDAO jdao = new JogadorDAO();
                    List<Jogador> jogadores = jdao.findByTimeId(id);
                    for (Jogador j : jogadores) time.adicionarJogador(j);

                    TituloDAO tdao = new TituloDAO();
                    List<Titulo> titulos = tdao.findByTimeId(id);
                    for (Titulo t : titulos) time.adicionarTitulo(t);

                    return time;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Time> findAll() {
        String sql = "SELECT id, nome, ano_fundacao FROM times";
        List<Time> lista = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Time time = new Time(rs.getString("nome"), rs.getInt("ano_fundacao"));
                time.setId(rs.getInt("id"));
                lista.add(time);
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
