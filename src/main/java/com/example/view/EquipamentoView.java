package com.example.view;

import com.example.controllers.EquipamentoController;
import com.example.models.Equipamento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EquipamentoView extends JFrame {
    private EquipamentoController equipamentoController;
    private JTextArea textArea;
    private JTextField codigoField, nomeField, modeloField, fabricanteField, dataAquisicaoField, vidaUtilField, localizacaoField, statusField;

    public EquipamentoView() {
        equipamentoController = new EquipamentoController();
        criarInterface();
    }

    private void criarInterface() {
        setTitle("Gerenciador de Equipamentos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel para os campos de entrada
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(9, 2));

        inputPanel.add(new JLabel("Código:"));
        codigoField = new JTextField();
        inputPanel.add(codigoField);

        inputPanel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        inputPanel.add(nomeField);

        inputPanel.add(new JLabel("Modelo:"));
        modeloField = new JTextField();
        inputPanel.add(modeloField);

        inputPanel.add(new JLabel("Fabricante:"));
        fabricanteField = new JTextField();
        inputPanel.add(fabricanteField);

        inputPanel.add(new JLabel("Data de Aquisição (YYYY-MM-DD):"));
        dataAquisicaoField = new JTextField();
        inputPanel.add(dataAquisicaoField);

        inputPanel.add(new JLabel("Vida Útil (anos):"));
        vidaUtilField = new JTextField();
        inputPanel.add(vidaUtilField);

        inputPanel.add(new JLabel("Localização:"));
        localizacaoField = new JTextField();
        inputPanel.add(localizacaoField);

        inputPanel.add(new JLabel("Status:"));
        statusField = new JTextField();
        inputPanel.add(statusField);

        add(inputPanel, BorderLayout.NORTH);

        // Área de texto para saída
        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Painel de botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton adicionarButton = new JButton("Adicionar Equipamento");
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarEquipamento();
            }
        });
        buttonPanel.add(adicionarButton);

        JButton listarButton = new JButton("Listar Equipamentos");
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarEquipamentos();
            }
        });
        buttonPanel.add(listarButton);

        JButton buscarButton = new JButton("Buscar Equipamento");
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarEquipamento();
            }
        });
        buttonPanel.add(buscarButton);

        JButton atualizarButton = new JButton("Atualizar Equipamento");
        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarEquipamento();
            }
        });
        buttonPanel.add(atualizarButton);

        JButton removerButton = new JButton("Remover Equipamento");
        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerEquipamento();
            }
        });
        buttonPanel.add(removerButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void adicionarEquipamento() {
        try {
            int codigo = Integer.parseInt(codigoField.getText());
            String nome = nomeField.getText();
            String modelo = modeloField.getText();
            String fabricante = fabricanteField.getText();
            String dataAquisicao = dataAquisicaoField.getText();
            int vidaUtil = Integer.parseInt(vidaUtilField.getText());
            String localizacao = localizacaoField.getText();
            String status = statusField.getText();

            equipamentoController.adicionarEquipamento(codigo, nome, modelo, fabricante, dataAquisicao, vidaUtil, localizacao, status);
            textArea.append("Equipamento adicionado com sucesso!\n");
        } catch (NumberFormatException e) {
            textArea.append("Erro: Verifique os campos numéricos!\n");
        }
    }

    private void listarEquipamentos() {
        List<Equipamento> equipamentos = equipamentoController.listarEquipamentos();
        textArea.setText(""); // Limpa a área de texto
        if (equipamentos.isEmpty()) {
            textArea.append("Nenhum equipamento encontrado.\n");
        } else {
            for (Equipamento equipamento : equipamentos) {
                textArea.append(equipamento + "\n");
            }
        }
    }

    private void buscarEquipamento() {
        try {
            int codigo = Integer.parseInt(codigoField.getText());
            Equipamento equipamento = equipamentoController.buscarEquipamento(codigo);
            textArea.setText(""); // Limpa a área de texto
            if (equipamento != null) {
                textArea.append(equipamento + "\n");
            } else {
                textArea.append("Equipamento não encontrado.\n");
            }
        } catch (NumberFormatException e) {
            textArea.append("Erro: Código deve ser um número!\n");
        }
    }

    private void atualizarEquipamento() {
        try {
            int codigo = Integer.parseInt(codigoField.getText());
            String nome = nomeField.getText();
            String modelo = modeloField.getText();
            String fabricante = fabricanteField.getText();
            String dataAquisicao = dataAquisicaoField.getText();
            int vidaUtil = Integer.parseInt(vidaUtilField.getText());
            String localizacao = localizacaoField.getText();
            String status = statusField.getText();

            boolean sucesso = equipamentoController.atualizarEquipamento(codigo, nome, modelo, fabricante, dataAquisicao, vidaUtil, localizacao, status);
            if (sucesso) {
                textArea.append("Equipamento atualizado com sucesso!\n");
            } else {
                textArea.append("Falha ao atualizar o equipamento.\n");
            }
        } catch (NumberFormatException e) {
            textArea.append("Erro: Verifique os campos numéricos!\n");
        }
    }

    private void removerEquipamento() {
        try {
            int codigo = Integer.parseInt(codigoField.getText());
            boolean sucesso = equipamentoController.removerEquipamento(codigo);
            if (sucesso) {
                textArea.append("Equipamento removido com sucesso!\n");
            } else {
                textArea.append("Falha ao remover o equipamento.\n");
            }
        } catch (NumberFormatException e) {
            textArea.append("Erro: Código deve ser um número!\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EquipamentoView view = new EquipamentoView();
            view.setVisible(true);
        });
    }
}
