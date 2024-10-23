package com.example.a1098sem4dam;

public class Registru {
    public String nume;
    public String prenume;
    public boolean esteActiv;
    public int evaluare;
    public String gen;
    public String categorie;

    public Registru(String nume, String prenume, boolean esteActiv, int evaluare, String gen, String categorie) {
        this.nume = nume;
        this.prenume = prenume;
        this.esteActiv = esteActiv;
        this.evaluare = evaluare;
        this.gen = gen;
        this.categorie = categorie;
    }



    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public boolean isEsteActiv() {
        return esteActiv;
    }

    public void setEsteActiv(boolean esteActiv) {
        this.esteActiv = esteActiv;
    }

    public int getEvaluare() {
        return evaluare;
    }

    public void setEvaluare(int evaluare) {
        this.evaluare = evaluare;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Registru{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", esteActiv=" + esteActiv +
                ", evaluare=" + evaluare +
                ", gen='" + gen + '\'' +
                ", categorie='" + categorie + '\'' +
                '}';
    }



}
