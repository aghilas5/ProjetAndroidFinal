package com.example.e_sante;




public class Patient {

    public int id;

    public String nom;

    public String prenom;

    public String email;

    public String motDePasse;

    public String adresse;

    public int age;

    public int tel;

    public int image;

    public int numAssurance;





    public Patient(String nom, String prenom, int age, int tel, int numAssurance,String email, String mdp,String adresse) {
        this.nom = nom;
        this.age = age;
        this.tel = tel;
        this.numAssurance = numAssurance;
        this.prenom=prenom;
        this.adresse=adresse;
        this.email=email;
        this.motDePasse=mdp;

    }

    public Patient(String nom, String prenom, int age, int tel, int numAssurance,String email,String adresse) {
        this.nom = nom;
        this.age = age;
        this.tel = tel;
        this.numAssurance = numAssurance;
        this.prenom=prenom;
        this.adresse=adresse;
        this.email=email;


    }



    public Patient(String nom, String prenom, int age, int tel, int numAssurance, String email, String mdp, String adresse, int image) {
        this.nom = nom;
        this.age = age;
        this.tel = tel;
        this.numAssurance = numAssurance;
        this.prenom=prenom;
        this.adresse=adresse;
        this.email=email;
        this.motDePasse=mdp;
        this.image=image;
    }



    public void setNom(String nom) {
        nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }

    public void setImage(int image) {
        image = image;
    }

    public int getImage() {
        return image;
    }

    public void setAge(int age) {
        age = age;
    }

    public void setTel(int tel) {
        tel = tel;
    }

    public void setNumAssurance(int numAssurance) {
        numAssurance = numAssurance;
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

    public int getNumAssurance() {
        return numAssurance;
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
        return motDePasse;
    }

    public void setMdp(String mdp) {
        this.motDePasse = mdp;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
