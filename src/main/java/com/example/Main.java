package com.example;

import java.util.Scanner;

import com.example.controllers.EquipamentoController;
import com.example.controllers.MaquinaController;
import com.example.view.EquipamentoView;
import com.example.view.MaquinaView;

public class Main {
    public static void main(String[] args) {
        EquipamentoController equipamentoController = new EquipamentoController();
        MaquinaController maquinaController = new MaquinaController();
        EquipamentoView equipamentoView = new EquipamentoView();
        MaquinaView maquinaView = new MaquinaView();
        Scanner scanner = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar Equipamento");
            System.out.println("2. Listar Equipamentos");
            System.out.println("3. Cadastrar Máquina");
            System.out.println("4. Listar Máquinas");
            System.out.println("5. Adicionar Histórico de Manutenção");
            System.out.println("6. Listar Histórico de Manutenção");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    Identificacao equipamento = equipamentoView.criarIdentificacao();
                    equipamentoController.cadastrarEquipamento(equipamento);
                    break;
                case "2":
                    equipamentoController.listarEquipamento();
                    break;
                case "3":
                    Identificacao maquina = maquinaView.criarIdentificacao();
                    maquinaController.cadastrarMaquina(maquina);
                    break;
                case "4":
                    maquinaController.listarMaquina();
                    break;
                case "5":
                    HistoricoManutencao historico = maquinaView.criarHistoricoManutencao();
                    maquinaController.adicionarHistoricoManutencao(historico);
                    break;
                case "6":
                    maquinaController.listarHistoricoManutencao();
                    break;
                case "7":
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (!opcao.equals("7"));

        scanner.close();
    }
}
