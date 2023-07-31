package com.al7irfa.al7irfa.Entities;

import java.util.Date;

public class Consultation {


    private int idConsultation;
    private Date consultationDate;
    private int idClient;
    private int idWorker;
    private Integer note;
    private int idReview;
    private int idJob;
    private Integer idConsultationType;

    public Consultation() {
    }

    public Consultation(int idConsultation, Date consultationDate, int idClient,
                        int idWorker, Integer note, int idReview, int idJob,
                        Integer idConsultationType) {

        this.idConsultation = idConsultation;
        this.consultationDate = consultationDate;
        this.idClient = idClient;
        this.idWorker = idWorker;
        this.note = note;
        this.idReview = idReview;
        this.idJob = idJob;
        this.idConsultationType = idConsultationType;
    }

    public int getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(int idConsultation) {
        this.idConsultation = idConsultation;
    }

    public Date getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(Date consultationDate) {
        this.consultationDate = consultationDate;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(int idWorker) {
        this.idWorker = idWorker;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    public int getIdJob() {
        return idJob;
    }

    public void setIdJob(int idJob) {
        this.idJob = idJob;
    }

    public Integer getIdConsultationType() {
        return idConsultationType;
    }

    public void setIdConsultationType(Integer idConsultationType) {
        this.idConsultationType = idConsultationType;
    }
}
