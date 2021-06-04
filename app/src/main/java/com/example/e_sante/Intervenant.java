package com.example.e_sante;

public class Intervenant {
    public String nom,email,mdp,adresse;
    public int age;
    public int tel;
    public String specialite;
    public String prenom;
    public int image;




    public Intervenant(String nom, String prenom, int age, int tel, String specilaite,String email, String mdp,String adresse) {
        this.nom = nom;
        this.age = age;
        this.tel = tel;
        this.specialite = specilaite;
        this.prenom=prenom;
        this.adresse=adresse;
        this.email=email;
        this.mdp=mdp;

    }

    public Intervenant(String nom, String prenom, int age, int tel, String specilaite,String email,String adresse) {
        this.nom = nom;
        this.age = age;
        this.tel = tel;
        this.specialite = specilaite;
        this.prenom=prenom;
        this.adresse=adresse;
        this.email=email;
        this.mdp=mdp;

    }


    public Intervenant(String nom, String prenom, int age, String specilaite, int image) {
        this.nom = nom;
        this.age = age;
        this.specialite = specilaite;
        this.prenom=prenom;
        this.image=image;


    }


    public int getImage() {
        return image;
    }

    public void setSpecialite(String specialite) {
        specialite = specialite;
    }

    public void setNom(String nom) {
        nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }



    public void setAge(int age) {
        age = age;
    }

    public void setTel(int tel) {
        tel = tel;
    }

    public void setNumAssurance(String specialite) {
        specialite = specialite;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public int getTel() {
        return tel;
    }

    public String getSpecialite() {
        return specialite;
    }
    public void setPrenom(String prenom) {
        prenom = prenom;
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
}
