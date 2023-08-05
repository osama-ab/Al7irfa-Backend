package com.al7irfa.al7irfa.Service;

import com.al7irfa.al7irfa.Entities.Client;
import com.al7irfa.al7irfa.Entities.Consultation;
import com.al7irfa.al7irfa.Repository.ClientRepository;
import com.al7irfa.al7irfa.Repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ConsultationServiceImplementation {
    private ConsultationRepository consultationRepository ;

    @Autowired
    public ConsultationServiceImplementation(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    public Consultation findConsultationById(Integer id){

        return consultationRepository.findById(id).orElse(null);

    }

    public void save(Consultation consultation){

        consultationRepository.save(consultation);

    }

    public void delete(Consultation consultation){
        consultationRepository.delete(consultation);
    }

    public List<Consultation> findAll(){

        return consultationRepository.findAll();
    }
}
