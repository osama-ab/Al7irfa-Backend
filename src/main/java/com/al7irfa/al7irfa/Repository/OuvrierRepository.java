package com.al7irfa.al7irfa.Repository;

import com.al7irfa.al7irfa.Entities.Ouvrier;
import com.al7irfa.al7irfa.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OuvrierRepository extends JpaRepository<Ouvrier,Integer> {

    Ouvrier findOuvrierByEmail(String email);
}
