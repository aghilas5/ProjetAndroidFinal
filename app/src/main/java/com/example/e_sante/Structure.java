package com.example.e_sante;

import java.util.List;

public class Structure {
    private String Nom,Discipline,adresse;
    private List<String> Pathologie;



    public Structure(String nom, String discipline, String adresse/*, List<String> pathologie*/) {
        this.Nom = nom;
        this.Discipline = discipline;
        this.adresse = adresse;
       // this.Pathologie = pathologie;
    }

    public String getNom() {
        return Nom;
    }

    public String getDiscipline() {
        return Discipline;
    }

    public String getAdresse() {
        return adresse;
    }

    public List<String> getPathologie() {
        return Pathologie;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setDiscipline(String discipline) {
        Discipline = discipline;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setPathologie(List<String> pathologie) {
        Pathologie = pathologie;
    }
}
