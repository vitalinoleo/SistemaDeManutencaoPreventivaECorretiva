package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.Identificacao;

public class EquipamentoController {
    private List<Identificacao> equipamentos = new ArrayList<>();

    // Cadastrando equipamentos
    public void cadastrarEquipamento(Identificacao equipamento) {
        equipamentos.add(equipamento);
        System.out.println("Equipamento cadastrado com sucesso!");
    }

    // Listando equipamentos
    public void listarEquipamento() {
        System.out.println("Lista de Equipamentos:");
        for (Identificacao equipamento : equipamentos) {
            System.out.println(equipamento);
        }
    }
}
