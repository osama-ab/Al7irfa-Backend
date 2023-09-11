package com.al7irfa.al7irfa.Repository;
import com.al7irfa.al7irfa.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {


    Client findClientByEmail(String email);


}
