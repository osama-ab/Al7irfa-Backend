package com.al7irfa.al7irfa.Repository;

import com.al7irfa.al7irfa.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OuvrierRepository extends JpaRepository<Ouvrier,Integer> {

     Ouvrier findOuvrierByEmail(String email);

     Ouvrier findOuvrierById(int id );

     List<Ouvrier> findAllByVilleAndCategorie(String ville , Categorie categorie);

     List<Ouvrier> findAllByVille(String ville);

     List<Ouvrier> findAllByCategorie(Categorie category);

     Ouvrier findOuvrierByConsultations(Consultation consultation);

     Ouvrier findOuvrierByRating(Rating rating);


}
