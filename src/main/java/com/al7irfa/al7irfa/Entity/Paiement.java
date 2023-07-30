package com.al7irfa.al7irfa.Entity;

import ch.qos.logback.core.net.server.Client;

public class Paiement {


    private int idPayment;
    private Client client; // Using Integer to allow null values
    private Ouvrier ouvrier; // Using Integer to allow null values
    private Double montant;
}
