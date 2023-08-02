package com.al7irfa.al7irfa.Service;

import com.al7irfa.al7irfa.Entities.Client;
import com.al7irfa.al7irfa.Entities.Reclamation;
import com.al7irfa.al7irfa.Repository.ClientRepository;
import com.al7irfa.al7irfa.Repository.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamationServiceImplementation {
    private ReclamationRepository reclamationRepository;

    @Autowired
    public ReclamationServiceImplementation(ReclamationRepository reclamationRepository) {
        this.reclamationRepository = reclamationRepository;
    }

    public Reclamation findReclamationById(Integer id){

        return reclamationRepository.findById(id).orElse(null);

    }

    public void save(Reclamation reclamation){

        reclamationRepository.save(reclamation);

    }

    public void delete(Reclamation reclamation){
        reclamationRepository.delete(reclamation);
    }

    public List<Reclamation> findAll(){

        return reclamationRepository.findAll();
    }

}
