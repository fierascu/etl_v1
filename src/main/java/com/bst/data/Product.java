package com.bst.data;

public class Product {
    //id	imagine	nume	referinta	categorie	Preț de bază	Preț final	cantitate	Stare

    private String id;
    private String imagine;
    private String nume;
    private String referinta;
    private String categorie;
    private String pretDeBaza;
    private String pretFinal;
    private String cantitate;
    private String Stare;

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", imagine='" + imagine + '\'' +
                ", nume='" + nume + '\'' +
                ", referinta='" + referinta + '\'' +
                ", categorie='" + categorie + '\'' +
                ", pretDeBaza='" + pretDeBaza + '\'' +
                ", pretFinal='" + pretFinal + '\'' +
                ", cantitate='" + cantitate + '\'' +
                ", Stare='" + Stare + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImagine() {
        return imagine;
    }

    public void setImagine(String imagine) {
        this.imagine = imagine;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getReferinta() {
        return referinta;
    }

    public void setReferinta(String Referinta) {
        referinta = Referinta;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getPretDeBaza() {
        return pretDeBaza;
    }

    public void setPretDeBaza(String pretDeBaza) {
        this.pretDeBaza = pretDeBaza;
    }

    public String getPretFinal() {
        return pretFinal;
    }

    public void setPretFinal(String pretFinal) {
        this.pretFinal = pretFinal;
    }

    public String getCantitate() {
        return cantitate;
    }

    public void setCantitate(String cantitate) {
        this.cantitate = cantitate;
    }

    public String getStare() {
        return Stare;
    }

    public void setStare(String stare) {
        Stare = stare;
    }
}
