package com.al7irfa.al7irfa.Entities;

public class Review {
    private int id_review;
    private String commentaire;

    public Review(int id_review, String commentaire) {
        this.id_review = id_review;
        this.commentaire = commentaire;
    }

    public Review() {
    }

    public int getId_review() {
        return id_review;
    }

    public void setId_review(int id_review) {
        this.id_review = id_review;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
