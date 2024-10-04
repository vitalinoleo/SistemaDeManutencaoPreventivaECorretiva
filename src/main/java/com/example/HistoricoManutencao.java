package com.example;

import java.time.LocalDate;

public class HistoricoManutencao {
    private LocalDate data;
    private String tipoIntervencao; // Preventiva ou corretiva
    private String pecasTrocadas; // Peças trocadas ou reparadas
    private String tempoParada; // Tempo de parada
    private String tecnico; // Técnico responsável
    private String observacoes; // Observações sobre o estado do equipamento

    public HistoricoManutencao(LocalDate data, String tipoIntervencao, String pecasTrocadas, 
                                String tempoParada, String tecnico, String observacoes) {
        this.data = data;
        this.tipoIntervencao = tipoIntervencao;
        this.pecasTrocadas = pecasTrocadas;
        this.tempoParada = tempoParada;
        this.tecnico = tecnico;
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Data: " + data +
               ", Tipo de Intervenção: " + tipoIntervencao +
               ", Peças Trocadas: " + pecasTrocadas +
               ", Tempo de Parada: " + tempoParada +
               ", Técnico: " + tecnico +
               ", Observações: " + observacoes;
    }

    
}
