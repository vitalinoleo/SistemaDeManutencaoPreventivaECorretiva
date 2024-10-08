package com.example.models;

public class Registra {
    private String nomeCompleto;
    private String matricula;

    public Registra(String nomeCompleto, String matricula) {
        this.nomeCompleto = nomeCompleto;
        this.matricula = matricula;
    }

    // Getters e Setters
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
