package com.example.desafio_3.Models;

import java.util.List;

public class Question {
    private String enunciado;
    private List<String> alternativas;
    private int respostaCerta;

    public Question(String enunciado, List<String> alternativas, int respostaCerta){
        this.enunciado = enunciado;
        this.alternativas = alternativas;
        this.respostaCerta = respostaCerta;
    }

    // === GETTERS ================================================
    public String getEnunciado() {
        return enunciado;
    }
    public List<String> getAlternativas() {
        return alternativas;
    }
    public int getRespostaCerta() {
        return respostaCerta;
    }
}
