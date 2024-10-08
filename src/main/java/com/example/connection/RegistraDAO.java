package com.example.connection;

import com.example.models.Registra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistraDAO {
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String usuario = "postgres"; // Nome do ADM do banco
    private String senha = "postgres"; // Senha do ADM do banco

    public RegistraDAO() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Adiciona um novo registro ao banco de dados
    public void adicionarRegistro(Registra registra) {
        String sql = "INSERT INTO usuarios (nome_completo, matricula) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, registra.getNomeCompleto());
            pstmt.setString(2, registra.getMatricula());
            pstmt.executeUpdate();
            System.out.println("Usuário registrado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Busca um registro pelo nome completo
    public Registra buscarRegistro(String nomeCompleto) {
        String sql = "SELECT * FROM usuarios WHERE nome_completo = ?";
        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nomeCompleto);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Registra(
                        rs.getString("nome_completo"),
                        rs.getString("matricula")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Retorna null se não encontrar
    }
}
