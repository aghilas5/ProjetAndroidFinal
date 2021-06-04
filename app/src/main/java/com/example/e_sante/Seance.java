package com.example.e_sante;

import java.time.LocalDateTime;

public class Seance {
    int duree;
    String date;

    public Seance(int duree, String date) {
        this.duree = duree;
        this.date = date;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
