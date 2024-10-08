package com.example.view;

import com.example.controllers.ManutencaoController;
import com.example.models.Manutencao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

public class ManutencaoView extends JFrame {
    private ManutencaoController manutencaoController;

    private JTextField txtIdMaquina;
    private JTextField txtDataManutencao;
    private JTextField txtTipoIntervencao;
    private JTextField txtPecasTrocadas;
    private JTextField txtTempoParada;
    private JTextField txtTecnicoResponsavel;
    private JTextField txtObservacoes;
    private JTextArea txtAreaResultados;

    public ManutencaoView() {
        manutencaoController = new ManutencaoController();
        criarInterface();
    }

    private void criarInterface() {
        setTitle("Gestão de Manutenções");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Campos de entrada
        txtIdMaquina = new JTextField(15);
        txtDataManutencao = new JTextField(15);
        txtTipoIntervencao = new JTextField(15);
        txtPecasTrocadas = new JTextField(15);
        txtTempoParada = new JTextField(15);
        txtTecnicoResponsavel = new JTextField(15);
        txtObservacoes = new JTextField(15);
        txtAreaResultados = new JTextArea(15, 30);
        txtAreaResultados.setEditable(false);

        // Botões
        JButton btnAdicionar = new JButton("Adicionar Manutenção");
        JButton btnListar = new JButton("Listar Manutenções");
        JButton btnBuscar = new JButton("Buscar Manutenção");
        JButton btnAtualizar = new JButton("Atualizar Manutenção");
        JButton btnRemover = new JButton("Remover Manutenção");
        JButton btnVoltar = new JButton("Voltar");

        // Adicionando os componentes à janela
        add(new JLabel("ID Máquina:"));
        add(txtIdMaquina);
        add(new JLabel("Data Manutenção (dd/mm/aaaa):"));
        add(txtDataManutencao);
        add(new JLabel("Tipo Intervenção:"));
        add(txtTipoIntervencao);
        add(new JLabel("Peças Trocadas:"));
        add(txtPecasTrocadas);
        add(new JLabel("Tempo Parada (horas):"));
        add(txtTempoParada);
        add(new JLabel("Técnico Responsável:"));
        add(txtTecnicoResponsavel);
        add(new JLabel("Observações:"));
        add(txtObservacoes);
        add(btnAdicionar);
        add(btnListar);
        add(btnBuscar);
        add(btnAtualizar);
        add(btnRemover);
        add(btnVoltar);
        add(new JScrollPane(txtAreaResultados));

        // Ações dos botões
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarManutencao();
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarManutencoes();
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarManutencao();
            }
        });

        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarManutencao();
            }
        });

        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerManutencao();
            }
        });

        // Ação do botão Voltar
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltarParaPrimeiraTela();
            }
        });

        setVisible(true);
    }

    private void adicionarManutencao() {
        try {
            Manutencao manutencao = new Manutencao(
                LocalDate.parse(txtDataManutencao.getText()),
                txtTipoIntervencao.getText(),
                txtPecasTrocadas.getText(),
                Integer.parseInt(txtTempoParada.getText()),
                txtTecnicoResponsavel.getText(),
                txtObservacoes.getText(),
                Integer.parseInt(txtIdMaquina.getText())
            );
            manutencaoController.adicionarManutencao(manutencao);
            JOptionPane.showMessageDialog(this, "Manutenção adicionada com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao adicionar manutenção: " + e.getMessage());
        }
    }

    private void listarManutencoes() {
        List<Manutencao> manutencaoList = manutencaoController.listarManutencoes();
        txtAreaResultados.setText("");
        for (Manutencao m : manutencaoList) {
            txtAreaResultados.append(m.toString() + "\n");
        }
    }

    private void buscarManutencao() {
        try {
            int idMaquina = Integer.parseInt(txtIdMaquina.getText());
            Manutencao manutencao = manutencaoController.buscarManutencao(idMaquina);
            if (manutencao != null) {
                txtAreaResultados.setText(manutencao.toString());
            } else {
                JOptionPane.showMessageDialog(this, "Manutenção não encontrada!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar manutenção: " + e.getMessage());
        }
    }

    private void atualizarManutencao() {
        try {
            Manutencao manutencao = new Manutencao(
                LocalDate.parse(txtDataManutencao.getText()),
                txtTipoIntervencao.getText(),
                txtPecasTrocadas.getText(),
                Integer.parseInt(txtTempoParada.getText()),
                txtTecnicoResponsavel.getText(),
                txtObservacoes.getText(),
                Integer.parseInt(txtIdMaquina.getText())
            );
            if (manutencaoController.atualizarManutencao(manutencao)) {
                JOptionPane.showMessageDialog(this, "Manutenção atualizada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Manutenção não encontrada para atualização!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar manutenção: " + e.getMessage());
        }
    }

    private void removerManutencao() {
        try {
            int idMaquina = Integer.parseInt(txtIdMaquina.getText());
            if (manutencaoController.removerManutencao(idMaquina)) {
                JOptionPane.showMessageDialog(this, "Manutenção removida com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Manutenção não encontrada!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao remover manutenção: " + e.getMessage());
        }
    }

    private void voltarParaPrimeiraTela() {
        new PrimeiraTela(); // Abre a PrimeiraTela
        dispose(); // Fecha a tela de ManutencaoView
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ManutencaoView());
    }
}
