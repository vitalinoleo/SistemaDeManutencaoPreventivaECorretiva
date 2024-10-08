package com.example.models;

import java.time.LocalDate;

public class Manutencao {
    private int id_maquina;
    private LocalDate dataManutencao; // Data da manutenção
    private String tipoIntervencao; // Tipo de intervenção (preventiva ou corretiva)
    private String pecasTrocadas; // Peças trocadas ou reparadas
    private int tempoParada; // Tempo de parada em horas
    private String tecnicoResponsavel; // Técnico responsável pela intervenção
    private String observacoes; // Observações sobre o estado do equipamento

    public Manutencao(LocalDate dataManutencao, String tipoIntervencao, String pecasTrocadas, 
                      int tempoParada, String tecnicoResponsavel, String observacoes, int id_maquina) {
        this.dataManutencao = dataManutencao;
        this.tipoIntervencao = tipoIntervencao;
        this.pecasTrocadas = pecasTrocadas;
        this.tempoParada = tempoParada;
        this.tecnicoResponsavel = tecnicoResponsavel;
        this.observacoes = observacoes;
        this.id_maquina = id_maquina;
    }

    // Getters e Setters
    public int getId_maquina(){
        return id_maquina;
    }

    public void setId_maquina(int id_maquina){
        this.id_maquina = id_maquina;
    }
    public LocalDate getDataManutencao() {
        return dataManutencao;
    }

    public void setDataManutencao(LocalDate dataManutencao) {
        this.dataManutencao = dataManutencao;
    }

    public String getTipoIntervencao() {
        return tipoIntervencao;
    }

    public void setTipoIntervencao(String tipoIntervencao) {
        this.tipoIntervencao = tipoIntervencao;
    }

    public String getPecasTrocadas() {
        return pecasTrocadas;
    }

    public void setPecasTrocadas(String pecasTrocadas) {
        this.pecasTrocadas = pecasTrocadas;
    }

    public int getTempoParada() {
        return tempoParada;
    }

    public void setTempoParada(int tempoParada) {
        this.tempoParada = tempoParada;
    }

    public String getTecnicoResponsavel() {
        return tecnicoResponsavel;
    }

    public void setTecnicoResponsavel(String tecnicoResponsavel) {
        this.tecnicoResponsavel = tecnicoResponsavel;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Data da Manutenção: " + dataManutencao +
                ", Tipo de Intervenção: " + tipoIntervencao +
                ", Peças Trocadas: " + pecasTrocadas +
                ", Tempo de Parada: " + tempoParada + " horas" +
                ", Técnico Responsável: " + tecnicoResponsavel +
                ", Observações: " + observacoes +
                ", id maquina:" + id_maquina;
    }
}
