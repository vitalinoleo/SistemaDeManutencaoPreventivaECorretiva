package com.example.view;

import java.util.Scanner;

import com.example.Identificacao;

public class EquipamentoView {
    private Scanner scanner = new Scanner(System.in);

    public Identificacao criarIdentificacao() {
        System.out.print("Digite o código do equipamento: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.print("Digite o nome do equipamento: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o modelo do equipamento: ");
        String modelo = scanner.nextLine();

        System.out.print("Digite o fabricante do equipamento: ");
        String fabricante = scanner.nextLine();

        return new Identificacao(codigo, nome, modelo, fabricante);
    }
}
