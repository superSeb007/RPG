package com.example.evoliris.supersebrpg.metier;

public class Personnage {
    private int id;
    private String nom;
    private int pointVie, attaque;
    private String photo;

    public Personnage(int id, String nom, int pointVie, int attaque, String photo) {
        this.id = id;
        this.nom = nom;
        this.pointVie = pointVie;
        this.attaque = attaque;
        this.photo = photo;
    }


    public Personnage(int id, String nom, int pointVie, int attaque) {
        this.id = id;
        this.nom = nom;
        this.pointVie = pointVie;
        this.attaque = attaque;
    }

    public boolean attaquer(int pointsAttaque){
        boolean estMort;
        this.pointVie -= pointsAttaque;
        estMort = this.pointVie<=0;

        return estMort;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPointVie() {
        return pointVie;
    }

    public void setPointVie(int pointVie) {
        this.pointVie = pointVie;
    }

    public int getAttaque() {
        return attaque;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", pointVie=" + pointVie +
                ", attaque=" + attaque +
                ", photo='" + photo + '\'' +
                '}';
    }
}
