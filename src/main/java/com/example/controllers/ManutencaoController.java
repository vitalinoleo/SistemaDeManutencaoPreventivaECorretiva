package com.example.controllers;

import com.example.connection.ManutencaoDAO;
import com.example.models.Manutencao;

import java.util.List;

public class ManutencaoController {
    private ManutencaoDAO manutencaoDAO;

    public ManutencaoController() {
        this.manutencaoDAO = new ManutencaoDAO();
    }

    // Adiciona uma nova manutenção
    public void adicionarManutencao(Manutencao manutencao) {
        manutencaoDAO.adicionarManutencao(manutencao);
    }

    // Lista todas as manutenções
    public List<Manutencao> listarManutencoes() {
        return manutencaoDAO.listarManutencoes();
    }

    // Busca uma manutenção pelo ID da máquina
    public Manutencao buscarManutencao(int idMaquina) {
        return manutencaoDAO.buscarManutencao(idMaquina);
    }

    // Atualiza uma manutenção existente
    public boolean atualizarManutencao(Manutencao manutencao) {
        return manutencaoDAO.atualizarManutencao(manutencao);
    }

    // Remove uma manutenção pelo ID da máquina
    public boolean removerManutencao(int idMaquina) {
        return manutencaoDAO.removerManutencao(idMaquina);
    }
}
