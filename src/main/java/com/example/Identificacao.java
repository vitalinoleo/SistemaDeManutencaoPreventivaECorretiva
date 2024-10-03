package com.example;

public class Identificacao {
    //atributos
    private int codigo;
    private String nome;
    private String modelo;
    private String fabricante;

    //ctor vazio
    public Identificacao() {
        super();
    }
    //ctor cheio

    public Identificacao(int codigo, String nome, String modelo, String fabricante) {
        this.codigo = codigo;
        this.nome = nome;
        this.modelo = modelo;
        this.fabricante = fabricante;
    }

    //geters and setters 

    //get

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getModelo() {
        return modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    
    //setters

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    

    
    
}
