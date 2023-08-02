package com.al7irfa.al7irfa.Service;

import com.al7irfa.al7irfa.Entities.Client;
import com.al7irfa.al7irfa.Entities.TypeConsultation;
import com.al7irfa.al7irfa.Repository.ClientRepository;
import com.al7irfa.al7irfa.Repository.TypeConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeConsultationServiceImplementation {
    private TypeConsultationRepository typeConsultationRepository;

    @Autowired
    public TypeConsultationServiceImplementation(TypeConsultationRepository typeConsultationRepository) {
        this.typeConsultationRepository = typeConsultationRepository;
    }

    public TypeConsultation findTypeConsultationById(Integer id){

        return typeConsultationRepository.findById(id).orElse(null);

    }

    public void save(TypeConsultation typeConsultation){

        typeConsultationRepository.save(typeConsultation);

    }

    public void delete(TypeConsultation typeConsultation){
        typeConsultationRepository.delete(typeConsultation);
    }

    public List<TypeConsultation> findAll(){

        return typeConsultationRepository.findAll();
    }

}
