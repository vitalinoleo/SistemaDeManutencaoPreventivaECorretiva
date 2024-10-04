package com.example.models;

public class Equipamento {
    private int codigo;
    private String nome;
    private String modelo;
    private String fabricante;

    public Equipamento(int codigo, String nome, String modelo, String fabricante) {
        this.codigo = codigo;
        this.nome = nome;
        this.modelo = modelo;
        this.fabricante = fabricante;
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nome: " + nome + ", Modelo: " + modelo + ", Fabricante: " + fabricante;
    }
}
