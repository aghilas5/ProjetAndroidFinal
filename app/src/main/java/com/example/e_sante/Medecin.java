package com.example.e_sante;

public class Medecin {

    public String nom,email,mdp,adresse;
    public int tel,age;
    public int image;
    public String prenom,specialite;
    public Medecin(){}
    public Medecin(String nom,String email,String adresse, int tel, int image,String prenom, String specialite) {
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.adresse = adresse;
        this.tel = tel;
        this.image = image;
        this.prenom = prenom;
        this.specialite = specialite;
    }
    public Medecin(String nom, String prenom,int age,int tel,String email,String adresse,String specialite) {
        this.nom = nom;
        this.email = email;
        this.age=age;
        this.adresse = adresse;
        this.tel = tel;
        this.prenom = prenom;
        this.specialite = specialite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
