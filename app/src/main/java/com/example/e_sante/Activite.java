package com.example.e_sante;

public class Activite {

    private String titre,description;
    private int duree,Image;

    public Activite(String titre, int duree, String description) {
        this.titre = titre;
        this.duree = duree;
        this.description=description;
    }
    public Activite(String titre, int duree) {
        this.titre = titre;
        this.duree = duree;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public int getDuree() {
        return duree;
    }


    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
}
