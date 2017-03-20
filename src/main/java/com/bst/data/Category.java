package com.bst.data;

public class Category {
    //ID	Nume	Descriere	Pozitie	Afisat

    private String ID;
    private String Nume;
    private String Descriere;
    private String Pozitie;
    private String Afisat;


    public String vtoString() {
        return "Category{" +
                "ID='" + ID + '\'' +
                ", Nume='" + Nume + '\'' +
                ", Descriere='" + Descriere + '\'' +
                ", Pozitie='" + Pozitie + '\'' +
                ", Afisat='" + Afisat + '\'' +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public String getDescriere() {
        return Descriere;
    }

    public void setDescriere(String descriere) {
        Descriere = descriere;
    }

    public String getPozitie() {
        return Pozitie;
    }

    public void setPozitie(String pozitie) {
        Pozitie = pozitie;
    }

    public String getAfisat() {
        return Afisat;
    }

    public void setAfisat(String afisat) {
        Afisat = afisat;
    }

    @Override
    public String toString() {
        return "Category{" +
                "ID='" + ID + '\'' +
                ", Nume='" + Nume + '\'' +
                ", Descriere='" + Descriere + '\'' +
                ", Pozitie='" + Pozitie + '\'' +
                ", Afisat='" + Afisat + '\'' +
                '}';
    }
}
