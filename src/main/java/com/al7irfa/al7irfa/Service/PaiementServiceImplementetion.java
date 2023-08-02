package com.al7irfa.al7irfa.Service;

import com.al7irfa.al7irfa.Entities.Client;
import com.al7irfa.al7irfa.Entities.Paiement;
import com.al7irfa.al7irfa.Repository.ClientRepository;
import com.al7irfa.al7irfa.Repository.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementServiceImplementetion {
    private PaiementRepository paiementRepository;

    @Autowired
    public PaiementServiceImplementetion (PaiementRepository paiementRepository) {
        this.paiementRepository = paiementRepository;
    }

    public Paiement findPaiementById(Integer id){

        return paiementRepository.findById(id).orElse(null);

    }

    public void save(Paiement paiement){

        paiementRepository.save(paiement);

    }

    public void delete(Paiement paiement){
        paiementRepository.delete(paiement);
    }

    public List<Paiement> findAll(){

        return paiementRepository.findAll();
    }

}
