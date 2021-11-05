package com.example.kingofestudos;

public class MeusAfazeres {

    String tituloafazer;
    String datafazer;
    String descafazer;
    String keydoes;

    public MeusAfazeres() {
    }

    public MeusAfazeres(String tituloafazer, String datafazer, String descafazer, String keydoes) {
        this.tituloafazer = tituloafazer;
        this.datafazer = datafazer;
        this.descafazer = descafazer;
        this.keydoes = keydoes;
    }

    public String getKeydoes() {
        return keydoes;
    }

    public void setKeydoes(String keydoes) {
        this.keydoes = keydoes;
    }

    public String getTituloafazer() {
        return tituloafazer;
    }

    public void setTituloafazer(String tituloafazer) {
        this.tituloafazer = tituloafazer;
    }

    public String getDatafazer() {
        return datafazer;
    }

    public void setDatafazer(String datafazer) {
        this.datafazer = datafazer;
    }

    public String getDescafazer() {
        return descafazer;
    }

    public void Descafazer(String descafazer) {
        this.descafazer = descafazer;
    }
}
