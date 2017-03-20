package com.bst.data;

public class Manufacturer {
    //ID	Logo	Nume	Adrese	Produse	Activ


    private String ID;
    private String Logo;
    private String Nume;
    private String Adrese;
    private String Produse;
    private String Activ;

    @Override
    public String toString() {
        return "Manufacturer{" +
                "ID='" + ID + '\'' +
                ", Logo='" + Logo + '\'' +
                ", Nume='" + Nume + '\'' +
                ", Adrese='" + Adrese + '\'' +
                ", Produse='" + Produse + '\'' +
                ", Activ='" + Activ + '\'' +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        Logo = logo;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public String getAdrese() {
        return Adrese;
    }

    public void setAdrese(String adrese) {
        Adrese = adrese;
    }

    public String getProduse() {
        return Produse;
    }

    public void setProduse(String produse) {
        Produse = produse;
    }

    public String getActiv() {
        return Activ;
    }

    public void setActiv(String activ) {
        Activ = activ;
    }
}
