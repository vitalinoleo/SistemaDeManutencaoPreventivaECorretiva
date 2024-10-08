package com.example.connection;

import com.example.models.Manutencao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManutencaoDAO {
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String usuario = "postgres"; // Nome do ADM do banco
    private String senha = "postgres"; // Senha do ADM do banco

    public ManutencaoDAO() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Adiciona uma nova manutenção ao banco de dados
    public void adicionarManutencao(Manutencao manutencao) {
        String sql = "INSERT INTO manutencao (id_maquina, data_manutencao, tipo_intervencao, pecas_trocadas, tempo_parada, tecnico_responsavel, observacoes) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, manutencao.getId_maquina());
            pstmt.setDate(2, Date.valueOf(manutencao.getDataManutencao()));
            pstmt.setString(3, manutencao.getTipoIntervencao());
            pstmt.setString(4, manutencao.getPecasTrocadas());
            pstmt.setInt(5, manutencao.getTempoParada());
            pstmt.setString(6, manutencao.getTecnicoResponsavel());
            pstmt.setString(7, manutencao.getObservacoes());
            pstmt.executeUpdate();
            System.out.println("Manutenção adicionada com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lista todas as manutenções do banco de dados
    public List<Manutencao> listarManutencoes() {
        List<Manutencao> manutencaoList = new ArrayList<>();
        String sql = "SELECT * FROM manutencao";

        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Manutencao manutencao = new Manutencao(
                        rs.getDate("data_manutencao").toLocalDate(),
                        rs.getString("tipo_intervencao"),
                        rs.getString("pecas_trocadas"),
                        rs.getInt("tempo_parada"),
                        rs.getString("tecnico_responsavel"),
                        rs.getString("observacoes"),
                        rs.getInt("id_maquina")
                );
                manutencaoList.add(manutencao);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manutencaoList;
    }

    // Busca uma manutenção pelo ID da máquina
    public Manutencao buscarManutencao(int idMaquina) {
        String sql = "SELECT * FROM manutencao WHERE id_maquina = ?";
        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idMaquina);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Manutencao(
                        rs.getDate("data_manutencao").toLocalDate(),
                        rs.getString("tipo_intervencao"),
                        rs.getString("pecas_trocadas"),
                        rs.getInt("tempo_parada"),
                        rs.getString("tecnico_responsavel"),
                        rs.getString("observacoes"),
                        rs.getInt("id_maquina")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Retorna null se não encontrar
    }

    // Atualiza uma manutenção no banco de dados
    public boolean atualizarManutencao(Manutencao manutencao) {
        String sql = "UPDATE manutencao SET data_manutencao = ?, tipo_intervencao = ?, pecas_trocadas = ?, tempo_parada = ?, tecnico_responsavel = ?, observacoes = ? WHERE id_maquina = ?";
        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDate(1, Date.valueOf(manutencao.getDataManutencao()));
            pstmt.setString(2, manutencao.getTipoIntervencao());
            pstmt.setString(3, manutencao.getPecasTrocadas());
            pstmt.setInt(4, manutencao.getTempoParada());
            pstmt.setString(5, manutencao.getTecnicoResponsavel());
            pstmt.setString(6, manutencao.getObservacoes());
            pstmt.setInt(7, manutencao.getId_maquina());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Manutenção atualizada com sucesso!");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Manutenção não encontrada para atualização!");
        return false;
    }

    // Remove uma manutenção pelo ID da máquina
    public boolean removerManutencao(int idMaquina) {
        String sql = "DELETE FROM manutencao WHERE id_maquina = ?";
        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idMaquina);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Manutenção removida com sucesso!");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Manutenção não encontrada!");
        return false;
    }
}
