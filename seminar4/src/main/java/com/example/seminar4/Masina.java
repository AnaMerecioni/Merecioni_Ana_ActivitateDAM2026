package com.example.seminar4;

import java.io.Serializable;
public class Masina implements Serializable {
    private String numeModel;
    private String marca;
    private boolean esteNoua;
    private String tipCombustibil;
    private float notaDeLaUtilizator;
    private boolean areAerConditionat;

    public Masina(String numeModel, String marca, boolean esteNoua,
                  String tipCombustibil, float notaDeLaUtilizator,
                  boolean areAerConditionat) {
        this.numeModel = numeModel;
        this.marca = marca;
        this.esteNoua = esteNoua;
        this.tipCombustibil = tipCombustibil;
        this.notaDeLaUtilizator = notaDeLaUtilizator;
        this.areAerConditionat = areAerConditionat;
    }

    public String getNumeModel() {
        return numeModel;
    }

    public void setNumeModel(String numeModel) {
        this.numeModel = numeModel;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isEsteNoua() {
        return esteNoua;
    }

    public void setEsteNoua(boolean esteNoua) {
        this.esteNoua = esteNoua;
    }

    public String getTipCombustibil() {
        return tipCombustibil;
    }

    public void setTipCombustibil(String tipCombustibil) {
        this.tipCombustibil = tipCombustibil;
    }

    public float getNotaDeLaUtilizator() {
        return notaDeLaUtilizator;
    }

    public void setNotaDeLaUtilizator(float notaDeLaUtilizator) {
        this.notaDeLaUtilizator = notaDeLaUtilizator;
    }

    public boolean isAreAerConditionat() {
        return areAerConditionat;
    }

    public void setAreAerConditionat(boolean areAerConditionat) {
        this.areAerConditionat = areAerConditionat;
    }

    @Override
    public String toString() {
        String stare = "second-hand";
        if (esteNoua) {
            stare = "noua";
        }
        String aer = "fara aer conditionat";
        if (areAerConditionat) {
            aer = "cu aer conditionat";
        }
        return marca + " " + numeModel + " (" + stare + ", " + tipCombustibil
                + ", " + aer + ", nota " + notaDeLaUtilizator + ")";
    }
}
