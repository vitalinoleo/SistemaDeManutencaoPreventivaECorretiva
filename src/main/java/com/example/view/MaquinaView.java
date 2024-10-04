package com.example.view;

import com.example.controllers.MaquinaController;
import com.example.models.Maquina;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MaquinaView extends JFrame {
    private MaquinaController maquinaController;
    
    private JTextField codigoField;
    private JTextField nomeField;
    private JTextField modeloField;
    private JTextField fabricanteField;
    private JTextArea outputArea;

    public MaquinaView() {
        maquinaController = new MaquinaController();
        setupUI();
    }

    private void setupUI() {
        setTitle("Gerenciamento de Máquinas");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Formulário de entrada
        JPanel formPanel = new JPanel(new GridLayout(10, 5));
        
        formPanel.add(new JLabel("Código:"));
        codigoField = new JTextField();
        formPanel.add(codigoField);
        
        formPanel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        formPanel.add(nomeField);
        
        formPanel.add(new JLabel("Modelo:"));
        modeloField = new JTextField();
        formPanel.add(modeloField);
        
        formPanel.add(new JLabel("Fabricante:"));
        fabricanteField = new JTextField();
        formPanel.add(fabricanteField);

        JButton addButton = new JButton("Adicionar Máquina");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarMaquina();
            }
        });
        
        JButton listButton = new JButton("Listar Máquinas");
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarMaquinas();
            }
        });

        JButton removeButton = new JButton("Remover Máquina");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerMaquina();
            }
        });

        formPanel.add(addButton);
        formPanel.add(listButton);
        formPanel.add(removeButton);

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        add(formPanel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        setVisible(true);
    }

    private void adicionarMaquina() {
        try {
            int codigo = Integer.parseInt(codigoField.getText());
            String nome = nomeField.getText();
            String modelo = modeloField.getText();
            String fabricante = fabricanteField.getText();

            Maquina maquina = new Maquina(codigo, nome, modelo, fabricante);
            maquinaController.cadastrarMaquina(maquina);
            outputArea.append("Máquina adicionada: " + maquina + "\n");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Código deve ser um número válido.");
        }
    }

    private void listarMaquinas() {
        List<Maquina> maquinas = maquinaController.listarMaquinas();
        outputArea.setText(""); // Limpa a área de saída
        for (Maquina maquina : maquinas) {
            outputArea.append(maquina + "\n");
        }
    }

    private void removerMaquina() {
        try {
            int codigo = Integer.parseInt(codigoField.getText());
            if (maquinaController.removerMaquina(codigo)) {
                outputArea.append("Máquina removida com sucesso.\n");
            } else {
                outputArea.append("Máquina não encontrada.\n");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Código deve ser um número válido.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MaquinaView());
    }
}
