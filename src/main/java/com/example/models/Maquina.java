package com.example.models;

public class Maquina {
    private int codigo;
    private String nome;
    private String modelo;
    private String fabricante;
    private String dataAquisicao;
    private int vidaUtil;
    private String localizacao;
    private String status;

    public Maquina(int codigo, String nome, String modelo, String fabricante, String dataAquisicao, int vidaUtil, String localizacao, String status) {
        this.codigo = codigo;
        this.nome = nome;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.dataAquisicao = dataAquisicao;
        this.localizacao = localizacao;
        this.vidaUtil = vidaUtil;
        this.status = status;

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

    public String getDataAquisicao(){
        return dataAquisicao;
    }

    public void setDataAquisicao(String dataAquisicao){
        this.dataAquisicao = dataAquisicao;
    }

    public int getVidaUtil(){
        return vidaUtil;
    }

    public void setVidaUtil(int vidaUtil){
        this.vidaUtil = vidaUtil;
    }

    public String getLocalizacao(){
        return localizacao;
    }

    public void setLocalizacao(String localizacao){
        this.localizacao = localizacao;
    }

    public String getStatus(){
        return localizacao;
    }

    public void setStatus(String status){
        this.status = status;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nome: " + nome + ", Modelo: " + modelo + ", Fabricante: " + fabricante+ ", Data de Aquisição: "+ dataAquisicao+ ", Vida Util: "+ vidaUtil+ ", Localizacao: "+ localizacao+ ", Status: "+status ;
    }
}
