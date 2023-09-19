package com.al7irfa.al7irfa.Repository;
import com.al7irfa.al7irfa.Entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ConsultationRepository extends JpaRepository<Consultation,Integer> {

    List<Consultation> findConsultationsByOuvrierId(int idOuvrier);

    List<Consultation> findAll();

    List<Consultation> findConsultationByOuvrierId(int id);

}
