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
    private JTextArea textArea;
    private JTextField codigoField, nomeField, modeloField, fabricanteField, dataAquisicaoField, vidaUtilField, localizacaoField, statusField;

    public MaquinaView() {
        maquinaController = new MaquinaController();
        criarInterface();
    }

    private void criarInterface() {
        setTitle("Gerenciador de Máquinas");
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

        JButton adicionarButton = new JButton("Adicionar Máquina");
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarMaquina();
            }
        });
        buttonPanel.add(adicionarButton);

        JButton listarButton = new JButton("Listar Máquinas");
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarMaquinas();
            }
        });
        buttonPanel.add(listarButton);

        JButton buscarButton = new JButton("Buscar Máquina");
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarMaquina();
            }
        });
        buttonPanel.add(buscarButton);

        JButton atualizarButton = new JButton("Atualizar Máquina");
        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarMaquina();
            }
        });
        buttonPanel.add(atualizarButton);

        JButton removerButton = new JButton("Remover Máquina");
        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerMaquina();
            }
        });
        buttonPanel.add(removerButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void adicionarMaquina() {
        try {
            int codigo = Integer.parseInt(codigoField.getText());
            String nome = nomeField.getText();
            String modelo = modeloField.getText();
            String fabricante = fabricanteField.getText();
            String dataAquisicao = dataAquisicaoField.getText();
            int vidaUtil = Integer.parseInt(vidaUtilField.getText());
            String localizacao = localizacaoField.getText();
            String status = statusField.getText();

            maquinaController.adicionarMaquina(codigo, nome, modelo, fabricante, dataAquisicao, vidaUtil, localizacao, status);
            textArea.append("Máquina adicionada com sucesso!\n");
        } catch (NumberFormatException e) {
            textArea.append("Erro: Verifique os campos numéricos!\n");
        }
    }

    private void listarMaquinas() {
        List<Maquina> maquinas = maquinaController.listarMaquinas();
        textArea.setText(""); // Limpa a área de texto
        if (maquinas.isEmpty()) {
            textArea.append("Nenhuma máquina encontrada.\n");
        } else {
            for (Maquina maquina : maquinas) {
                textArea.append(maquina + "\n");
            }
        }
    }

    private void buscarMaquina() {
        try {
            int codigo = Integer.parseInt(codigoField.getText());
            Maquina maquina = maquinaController.buscarMaquina(codigo);
            textArea.setText(""); // Limpa a área de texto
            if (maquina != null) {
                textArea.append(maquina + "\n");
            } else {
                textArea.append("Máquina não encontrada.\n");
            }
        } catch (NumberFormatException e) {
            textArea.append("Erro: Código deve ser um número!\n");
        }
    }

    private void atualizarMaquina() {
        try {
            int codigo = Integer.parseInt(codigoField.getText());
            String nome = nomeField.getText();
            String modelo = modeloField.getText();
            String fabricante = fabricanteField.getText();
            String dataAquisicao = dataAquisicaoField.getText();
            int vidaUtil = Integer.parseInt(vidaUtilField.getText());
            String localizacao = localizacaoField.getText();
            String status = statusField.getText();

            boolean sucesso = maquinaController.atualizarMaquina(codigo, nome, modelo, fabricante, dataAquisicao, vidaUtil, localizacao, status);
            if (sucesso) {
                textArea.append("Máquina atualizada com sucesso!\n");
            } else {
                textArea.append("Falha ao atualizar a máquina.\n");
            }
        } catch (NumberFormatException e) {
            textArea.append("Erro: Verifique os campos numéricos!\n");
        }
    }

    private void removerMaquina() {
        try {
            int codigo = Integer.parseInt(codigoField.getText());
            boolean sucesso = maquinaController.removerMaquina(codigo);
            if (sucesso) {
                textArea.append("Máquina removida com sucesso!\n");
            } else {
                textArea.append("Falha ao remover a máquina.\n");
            }
        } catch (NumberFormatException e) {
            textArea.append("Erro: Código deve ser um número!\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MaquinaView view = new MaquinaView();
            view.setVisible(true);
        });
    }
}
