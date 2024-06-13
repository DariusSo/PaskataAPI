package com.example.PaskataAPI;

public class Klientas {
    private int id;
    private String vardas;
    private String slaptazodis;

    public Klientas(String vardas, String slaptazodis) {
        this.vardas = vardas;
        this.slaptazodis = slaptazodis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getSlaptazodis() {
        return slaptazodis;
    }

    public void setSlaptazodis(String slaptazodis) {
        this.slaptazodis = slaptazodis;
    }
    public String toString(){
        return "Vardas: " + vardas;
    }
}
