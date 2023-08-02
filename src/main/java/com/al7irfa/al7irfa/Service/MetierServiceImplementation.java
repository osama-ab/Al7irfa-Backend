package com.al7irfa.al7irfa.Service;

import com.al7irfa.al7irfa.Entities.Client;
import com.al7irfa.al7irfa.Entities.Metier;
import com.al7irfa.al7irfa.Repository.ClientRepository;
import com.al7irfa.al7irfa.Repository.MetierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MetierServiceImplementation {
    private MetierRepository metierRepository;

    @Autowired
    public MetierServiceImplementation(MetierRepository metierRepository) {
        this.metierRepository = metierRepository;
    }

    public Metier findMetierById(Integer id){

        return metierRepository.findById(id).orElse(null);

    }

    public void save(Metier metier){

        metierRepository.save(metier);

    }

    public void delete(Metier metier){
        metierRepository.delete(metier);
    }

    public List<Metier> findAll(){

        return metierRepository.findAll();
    }
}
