package br.inatel.cdg;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JogadorDAO {
    public int salvar(Jogador j, int timeId) {
        String sql = "INSERT INTO jogadores (nome, data_nascimento, posicao, pe_dominante, altura, peso, time_id) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, j.getNome());
            ps.setString(2, j.getDataNascimento());
            ps.setString(3, j.getPosicao());
            ps.setString(4, j.getPeDominante());
            ps.setDouble(5, j.getAltura());
            ps.setDouble(6, j.getPeso());
            ps.setInt(7, timeId);
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    j.setId(id);
                    return id;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    public List<Jogador> findByTimeId(int timeId) {
        String sql = "SELECT id, nome, data_nascimento, posicao, pe_dominante, altura, peso FROM jogadores WHERE time_id = ?";
        List<Jogador> lista = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, timeId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Jogador j = new Jogador(
                            rs.getString("nome"),
                            rs.getString("data_nascimento"),
                            rs.getString("posicao"),
                            rs.getString("pe_dominante"),
                            rs.getDouble("altura"),
                            rs.getDouble("peso")
                    );
                    j.setId(rs.getInt("id"));
                    lista.add(j);
                }
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
