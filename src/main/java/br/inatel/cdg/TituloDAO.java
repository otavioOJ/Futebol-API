package br.inatel.cdg;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TituloDAO {
    public int salvar(Titulo t, int timeId) {
        String sql = "INSERT INTO titulos (nome, ano, time_id) VALUES (?,?,?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, t.getNome());
            ps.setInt(2, t.getAno());
            ps.setInt(3, timeId);
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    t.setId(id);
                    return id;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    public List<Titulo> findByTimeId(int timeId) {
        String sql = "SELECT id, nome, ano FROM titulos WHERE time_id = ?";
        List<Titulo> lista = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, timeId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Titulo t = new Titulo(rs.getString("nome"), rs.getInt("ano"));
                    t.setId(rs.getInt("id"));
                    lista.add(t);
                }
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
