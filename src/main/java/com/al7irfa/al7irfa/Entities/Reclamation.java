package com.al7irfa.al7irfa.Entities;





public class Reclamation {


    private int idReclamation;
    private Client client; // Using Integer to allow null values
    private Ouvrier ouvrier; // Using Integer to allow null values
    private String commentaire; // Using String to represent varchar(45) in the database
    private Consultation consultation ;


    public Reclamation() {
    }

    public Reclamation(int idReclamation, Client client, Ouvrier ouvrier, String commentaire, Consultation consultation) {
        this.idReclamation = idReclamation;
        this.client = client;
        this.ouvrier = ouvrier;
        this.commentaire = commentaire;
        this.consultation = consultation;
    }

    public int getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(int idReclamation) {
        this.idReclamation = idReclamation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Ouvrier getOuvrier() {
        return ouvrier;
    }

    public void setOuvrier(Ouvrier ouvrier) {
        this.ouvrier = ouvrier;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }
}
