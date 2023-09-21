package com.al7irfa.al7irfa.Service;

import com.al7irfa.al7irfa.Entities.Client;
import com.al7irfa.al7irfa.Entities.Consultation;
import com.al7irfa.al7irfa.Entities.Ouvrier;
import com.al7irfa.al7irfa.Repository.ClientRepository;
import com.al7irfa.al7irfa.Repository.ConsultationRepository;
import com.al7irfa.al7irfa.Repository.OuvrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OuvrierServiceImplementation {
    private OuvrierRepository ouvrierRepository;
    private ConsultationRepository consultationRepository;

    @Autowired
    public OuvrierServiceImplementation(OuvrierRepository ouvrierRepository,ConsultationRepository consultationRepository) {
        this.ouvrierRepository= ouvrierRepository;
        this.consultationRepository=consultationRepository;

    }

    public Ouvrier findOuvrierById(Integer id){

        return ouvrierRepository.findById(id).orElse(null);

    }

    public void save(Ouvrier ouvrier){

        ouvrierRepository.save(ouvrier);

    }



    public void delete(Ouvrier ouvrier){
        ouvrierRepository.delete(ouvrier);
    }

    public List<Ouvrier> findAll(){

        return ouvrierRepository.findAll();
    }

    public Ouvrier findOuvrierByConsultation(int id){

       Consultation consultation = consultationRepository.findConsultationByIdConsultation(id);

       return ouvrierRepository.findOuvrierByConsultations(consultation);


    }




}
