package com.example.kingofestudos;

public class MeusAfazeres {

    String titledoes;
    String datedoes;
    String descdoes;

    public MeusAfazeres() {
    }

    public MeusAfazeres(String titledoes, String datedoes, String descdoes) {
        this.titledoes = titledoes;
        this.datedoes = datedoes;
        this.descdoes = descdoes;
    }

    public String getTitledoes() {
        return titledoes;
    }

    public void setTitledoes(String titleDoes) {
        this.titledoes = titledoes;
    }

    public String getDatedoes() {
        return datedoes;
    }

    public void setDatedoes(String datedoes) {
        this.datedoes = datedoes;
    }

    public String getDescdoes() {
        return descdoes;
    }

    public void setDescdoes(String descdoes) {
        this.descdoes = descdoes;
    }
}
