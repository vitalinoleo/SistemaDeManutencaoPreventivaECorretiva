package com.example.view;

import com.example.controllers.RegistraController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistraView extends JFrame {
    private JTextField nomeField;
    private JTextField matriculaField;
    private JButton registrarButton;
    private RegistraController registraController;

    public RegistraView() {
        registraController = new RegistraController();

        setTitle("Registro de Usuário");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel nomeLabel = new JLabel("Nome Completo:");
        nomeField = new JTextField(20);
        JLabel matriculaLabel = new JLabel("Matrícula:");
        matriculaField = new JTextField(20);

        registrarButton = new JButton("Registrar");
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });

        add(nomeLabel);
        add(nomeField);
        add(matriculaLabel);
        add(matriculaField);
        add(registrarButton);
    }

    private void registrarUsuario() {
        String nomeCompleto = nomeField.getText();
        String matricula = matriculaField.getText();

        if (!nomeCompleto.isEmpty() && !matricula.isEmpty()) {
            registraController.registrarUsuario(nomeCompleto, matricula);
            JOptionPane.showMessageDialog(this, "Usuário registrado com sucesso!");

            // Navegar para a PrimeiraTela
            PrimeiraTela primeiraTela = new PrimeiraTela();
            primeiraTela.setVisible(true); // Mostra a PrimeiraTela
            dispose(); // Fecha a tela de registro
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RegistraView view = new RegistraView();
            view.setVisible(true);
        });
    }
}
