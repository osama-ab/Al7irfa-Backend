package com.al7irfa.al7irfa.Entity;

import ch.qos.logback.core.net.server.Client;

public class Reclamation {


    private int idReclamation;
    private Client client; // Using Integer to allow null values
    private Ouvrier ouvrier; // Using Integer to allow null values
    private String commentaire; // Using String to represent varchar(45) in the database
    private Consultation consultation ;
}
