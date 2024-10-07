package com.example.controllers;

import com.example.connection.EquipamentoDAO;
import com.example.models.Equipamento;

import java.util.List;

public class EquipamentoController {
    private EquipamentoDAO equipamentoDAO;

    public EquipamentoController() {
        this.equipamentoDAO = new EquipamentoDAO();
    }

    // Adiciona um novo equipamento
    public void adicionarEquipamento(int codigo, String nome, String modelo, String fabricante, String dataAquisicao, int vidaUtil, String localizacao, String status) {
        Equipamento equipamento = new Equipamento(codigo, nome, modelo, fabricante, dataAquisicao, vidaUtil, localizacao, status);
        equipamentoDAO.adicionarEquipamento(equipamento);
    }

    // Lista todos os equipamentos
    public List<Equipamento> listarEquipamentos() {
        return equipamentoDAO.listarEquipamentos();
    }

    // Busca um equipamento pelo código
    public Equipamento buscarEquipamento(int codigo) {
        return equipamentoDAO.buscarEquipamento(codigo);
    }

    // Atualiza um equipamento
    public boolean atualizarEquipamento(int codigo, String nome, String modelo, String fabricante, String dataAquisicao, int vidaUtil, String localizacao, String status) {
        Equipamento equipamento = new Equipamento(codigo, nome, modelo, fabricante, dataAquisicao, vidaUtil, localizacao, status);
        return equipamentoDAO.atualizarEquipamento(equipamento);
    }

    // Remove um equipamento pelo código
    public boolean removerEquipamento(int codigo) {
        return equipamentoDAO.removerEquipamento(codigo);
    }
}
