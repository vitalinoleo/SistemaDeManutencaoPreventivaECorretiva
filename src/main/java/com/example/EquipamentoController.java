package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EquipamentoController {
    private List<Identificacao> equipamentos = new ArrayList<>();
    private List<Identificacao> maquinas = new ArrayList<>();
    private List<Identificacao> historicos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Cadastrando equipamentos
    public void cadastrarEquipamento() {
        Identificacao equipamento = criarIdentificacao("equipamento");
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

    // Cadastrando máquinas
    public void cadastrarMaquina() {
        Identificacao maquina = criarIdentificacao("máquina");
        maquinas.add(maquina);
        System.out.println("Máquina cadastrada com sucesso!");
    }

    // Listando máquinas
    public void listarMaquina() {
        System.out.println("Lista de Máquinas:");
        for (Identificacao maquina : maquinas) {
            System.out.println(maquina);
        }
    }

    // Método auxiliar para criar um Identificacao
    private Identificacao criarIdentificacao(String tipo) {
        System.out.print("Digite o código do " + tipo + ": ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.print("Digite o nome do " + tipo + ": ");
        String nome = scanner.nextLine();

        System.out.print("Digite o modelo do " + tipo + ": ");
        String modelo = scanner.nextLine();

        System.out.print("Digite o fabricante do " + tipo + ": ");
        String fabricante = scanner.nextLine();

        return new Identificacao(codigo, nome, modelo, fabricante);
    }

    //historico de manutencao
    public void hitoricoManutencao(String codigoIdentificacaoMaquina){
            //pegar o valor do scaner do usuario
            //fazer a consulta no banco de dados a partir da chave primaria de identificacao
            //retornar isso
            
    }
}
