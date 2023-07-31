package com.al7irfa.al7irfa.Entities;

public class Metier {
    private int id_metier;
    private String nom;
    private String description;

    public Metier(int id_metier, String nom, String description) {
        this.id_metier = id_metier;
        this.nom = nom;
        this.description = description;
    }

    public Metier() {
    }

    public int getId_metier() {
        return id_metier;
    }

    public void setId_metier(int id_metier) {
        this.id_metier = id_metier;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
