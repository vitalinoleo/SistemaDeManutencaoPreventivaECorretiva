package com.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimeiraTela extends JFrame {

    public PrimeiraTela() {
        criarInterface();
    }

    private void criarInterface() {
        setTitle("Tela Inicial");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        // Botão para Equipamentos
        JButton btnEquipamentos = new JButton("Equipamentos");
        btnEquipamentos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EquipamentoView(); // Supondo que você tenha uma classe chamada EquipamentoView
                dispose(); // Fecha a tela inicial
            }
        });

        // Botão para Máquinas
        JButton btnMaquinas = new JButton("Máquinas");
        btnMaquinas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MaquinaView(); // Supondo que você tenha uma classe chamada MaquinaView
                dispose(); // Fecha a tela inicial
            }
        });

        // Botão para Manutenções
        JButton btnManutencoes = new JButton("Manutenções");
        btnManutencoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManutencaoView(); // Abre a tela de Manutenção
                dispose(); // Fecha a tela inicial
            }
        });

        // Adicionando os botões à janela
        add(btnEquipamentos);
        add(btnMaquinas);
        add(btnManutencoes);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PrimeiraTela());
    }
}
