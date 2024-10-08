package com.example.controllers;

import com.example.connection.RegistraDAO;
import com.example.models.Registra;

public class RegistraController {
    private RegistraDAO registraDAO;

    public RegistraController() {
        this.registraDAO = new RegistraDAO();
    }

    // Método para registrar um novo usuário
    public void registrarUsuario(String nomeCompleto, String matricula) {
        Registra registra = new Registra(nomeCompleto, matricula);
        registraDAO.adicionarRegistro(registra);
    }

    // Método para buscar um registro pelo nome completo
    public Registra buscarUsuario(String nomeCompleto) {
        return registraDAO.buscarRegistro(nomeCompleto);
    }
}
