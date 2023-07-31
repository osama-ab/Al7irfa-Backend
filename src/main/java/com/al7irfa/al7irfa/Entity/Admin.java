package com.al7irfa.al7irfa.Entity;

public class Admin extends User{

    int idAdmin ;

    public Admin() {

    }

    public Admin(int idUser, String firstName, String lastName, String address, String phone, int idAdmin) {
        super(idUser, firstName, lastName, address, phone);
        this.idAdmin = idAdmin;
    }

}
