package com.example.controllers;

import com.example.connection.MaquinaDAO;
import com.example.models.Maquina;

import java.util.List;

public class MaquinaController {
    private MaquinaDAO maquinaDAO;

    public MaquinaController() {
        this.maquinaDAO = new MaquinaDAO();
    }

    // Adiciona uma nova máquina
    public void adicionarMaquina(int codigo, String nome, String modelo, String fabricante, String dataAquisicao, int vidaUtil, String localizacao, String status) {
        Maquina maquina = new Maquina(codigo, nome, modelo, fabricante, dataAquisicao, vidaUtil, localizacao, status);
        maquinaDAO.adicionarMaquina(maquina);
    }

    // Lista todas as máquinas
    public List<Maquina> listarMaquinas() {
        return maquinaDAO.listarMaquinas();
    }

    // Busca uma máquina pelo código
    public Maquina buscarMaquina(int codigo) {
        return maquinaDAO.buscarMaquina(codigo);
    }

    // Atualiza uma máquina
    public boolean atualizarMaquina(int codigo, String nome, String modelo, String fabricante, String dataAquisicao, int vidaUtil, String localizacao, String status) {
        Maquina maquina = new Maquina(codigo, nome, modelo, fabricante, dataAquisicao, vidaUtil, localizacao, status);
        return maquinaDAO.atualizarMaquina(maquina);
    }

    // Remove uma máquina pelo código
    public boolean removerMaquina(int codigo) {
        return maquinaDAO.removerMaquina(codigo);
    }
}
