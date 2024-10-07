package com.example.connection;

import com.example.models.Equipamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoDAO {
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String usuario = "postgres"; // Nome do ADM do banco
    private String senha = "postgres"; // Senha do ADM do banco

    public EquipamentoDAO() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Adiciona um novo equipamento ao banco de dados
    public void adicionarEquipamento(Equipamento equipamento) {
        String sql = "INSERT INTO equipamentos (codigo, nome, modelo, fabricante, data_aquisicao, vida_util, localizacao, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, equipamento.getCodigo());
            pstmt.setString(2, equipamento.getNome());
            pstmt.setString(3, equipamento.getModelo());
            pstmt.setString(4, equipamento.getFabricante());
            pstmt.setString(5, equipamento.getDataAquisicao());
            pstmt.setInt(6, equipamento.getVidaUtil());
            pstmt.setString(7, equipamento.getLocalizacao());
            pstmt.setString(8, equipamento.getStatus());
            pstmt.executeUpdate();
            System.out.println("Equipamento adicionado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lista todos os equipamentos do banco de dados
    public List<Equipamento> listarEquipamentos() {
        List<Equipamento> equipamentos = new ArrayList<>();
        String sql = "SELECT * FROM equipamentos";

        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Equipamento equipamento = new Equipamento(
                        rs.getInt("codigo"),
                        rs.getString("nome"),
                        rs.getString("modelo"),
                        rs.getString("fabricante"),
                        rs.getString("data_aquisicao"),
                        rs.getInt("vida_util"),
                        rs.getString("localizacao"),
                        rs.getString("status")
                );
                equipamentos.add(equipamento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipamentos;
    }

    // Busca um equipamento pelo código
    public Equipamento buscarEquipamento(int codigo) {
        String sql = "SELECT * FROM equipamentos WHERE codigo = ?";
        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, codigo);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Equipamento(
                        rs.getInt("codigo"),
                        rs.getString("nome"),
                        rs.getString("modelo"),
                        rs.getString("fabricante"),
                        rs.getString("data_aquisicao"),
                        rs.getInt("vida_util"),
                        rs.getString("localizacao"),
                        rs.getString("status")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Retorna null se não encontrar
    }

    // Atualiza um equipamento no banco de dados
    public boolean atualizarEquipamento(Equipamento equipamento) {
        String sql = "UPDATE equipamentos SET nome = ?, modelo = ?, fabricante = ?, data_aquisicao = ?, vida_util = ?, localizacao = ?, status = ? WHERE codigo = ?";
        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, equipamento.getNome());
            pstmt.setString(2, equipamento.getModelo());
            pstmt.setString(3, equipamento.getFabricante());
            pstmt.setString(4, equipamento.getDataAquisicao());
            pstmt.setInt(5, equipamento.getVidaUtil());
            pstmt.setString(6, equipamento.getLocalizacao());
            pstmt.setString(7, equipamento.getStatus());
            pstmt.setInt(8, equipamento.getCodigo());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Equipamento atualizado com sucesso!");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Equipamento não encontrado para atualização!");
        return false;
    }

    // Remove um equipamento pelo código
    public boolean removerEquipamento(int codigo) {
        String sql = "DELETE FROM equipamentos WHERE codigo = ?";
        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, codigo);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Equipamento removido com sucesso!");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Equipamento não encontrado!");
        return false;
    }
}
