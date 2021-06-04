package com.example.e_sante;

public class Parcours {
    private String titre;
    private String categorie,description;
    private int Image;
    public Parcours(){}

    public Parcours(String titre, String categorie,String description) {
        this.titre = titre;
        this.description=description;
        this.categorie = categorie;
    }


    public Parcours(String titre, String categorie, String description, int image) {
        this.titre = titre;
        this.description=description;
        this.categorie = categorie;
        this.Image=image;
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

    public String getCategorie() {
        return categorie;
    }
    public void setImage(int image) {
        Image = image;
    }

    public int getImage() {
        return Image;
    }



    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}
