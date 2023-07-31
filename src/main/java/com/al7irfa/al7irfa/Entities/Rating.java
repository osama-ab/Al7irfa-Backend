package com.al7irfa.al7irfa.Entities;

public class Rating {
    private String id_rating;
    private int id_ouvrier;
    private int classement;
    private int id_consultation;


    public Rating() {
    }

    public Rating(String id_rating, int id_ouvrier, int classement, int id_consultation) {
        this.id_rating = id_rating;
        this.id_ouvrier = id_ouvrier;
        this.classement = classement;
        this.id_consultation = id_consultation;
    }

    public String getId_rating() {
        return id_rating;
    }

    public void setId_rating(String id_rating) {
        this.id_rating = id_rating;
    }

    public int getId_ouvrier() {
        return id_ouvrier;
    }

    public void setId_ouvrier(int id_ouvrier) {
        this.id_ouvrier = id_ouvrier;
    }

    public int getClassement() {
        return classement;
    }

    public void setClassement(int classement) {
        this.classement = classement;
    }

    public int getId_consultation() {
        return id_consultation;
    }

    public void setId_consultation(int id_consultation) {
        this.id_consultation = id_consultation;
    }
}
