package com.example.connection;

import com.example.models.Maquina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaquinaDAO {
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String usuario = "postgres"; // Nome do ADM do banco
    private String senha = "postgres"; // Senha do ADM do banco

    public MaquinaDAO() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Adiciona uma nova máquina ao banco de dados
    public void adicionarMaquina(Maquina maquina) {
        String sql = "INSERT INTO maquinas (codigo, nome, modelo, fabricante, data_aquisicao, vida_util, localizacao, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, maquina.getCodigo());
            pstmt.setString(2, maquina.getNome());
            pstmt.setString(3, maquina.getModelo());
            pstmt.setString(4, maquina.getFabricante());
            pstmt.setString(5, maquina.getDataAquisicao());
            pstmt.setInt(6, maquina.getVidaUtil());
            pstmt.setString(7, maquina.getLocalizacao());
            pstmt.setString(8, maquina.getStatus());
            pstmt.executeUpdate();
            System.out.println("Máquina adicionada com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lista todas as máquinas do banco de dados
    public List<Maquina> listarMaquinas() {
        List<Maquina> maquinas = new ArrayList<>();
        String sql = "SELECT * FROM maquinas";

        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Maquina maquina = new Maquina(
                        rs.getInt("codigo"),
                        rs.getString("nome"),
                        rs.getString("modelo"),
                        rs.getString("fabricante"),
                        rs.getString("data_aquisicao"),
                        rs.getInt("vida_util"),
                        rs.getString("localizacao"),
                        rs.getString("status")
                );
                maquinas.add(maquina);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maquinas;
    }

    // Busca uma máquina pelo código
    public Maquina buscarMaquina(int codigo) {
        String sql = "SELECT * FROM maquinas WHERE codigo = ?";
        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, codigo);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Maquina(
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

    // Atualiza uma máquina no banco de dados
    public boolean atualizarMaquina(Maquina maquina) {
        String sql = "UPDATE maquinas SET nome = ?, modelo = ?, fabricante = ?, data_aquisicao = ?, vida_util = ?, localizacao = ?, status = ? WHERE codigo = ?";
        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, maquina.getNome());
            pstmt.setString(2, maquina.getModelo());
            pstmt.setString(3, maquina.getFabricante());
            pstmt.setString(4, maquina.getDataAquisicao());
            pstmt.setInt(5, maquina.getVidaUtil());
            pstmt.setString(6, maquina.getLocalizacao());
            pstmt.setString(7, maquina.getStatus());
            pstmt.setInt(8, maquina.getCodigo());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Máquina atualizada com sucesso!");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Máquina não encontrada para atualização!");
        return false;
    }

    // Remove uma máquina pelo código
    public boolean removerMaquina(int codigo) {
        String sql = "DELETE FROM maquinas WHERE codigo = ?";
        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, codigo);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Máquina removida com sucesso!");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Máquina não encontrada!");
        return false;
    }
}
