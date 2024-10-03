package com.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EquipamentoController controller = new EquipamentoController();
        Scanner scanner = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar Equipamento");
            System.out.println("2. Listar Equipamentos");
            System.out.println("3. Cadastrar Máquina");
            System.out.println("4. Listar Máquinas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    controller.cadastrarEquipamento();
                    break;
                case "2":
                    controller.listarEquipamento();
                    break;
                case "3":
                    controller.cadastrarMaquina();
                    break;
                case "4":
                    controller.listarMaquina();
                    break;
                case "5":
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (!opcao.equals("5"));

        scanner.close();
    }
}
