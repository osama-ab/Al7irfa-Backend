package com.al7irfa.al7irfa.Service;

import com.al7irfa.al7irfa.Entities.Client;
import com.al7irfa.al7irfa.Entities.Consultation;
import com.al7irfa.al7irfa.Entities.Ouvrier;
import com.al7irfa.al7irfa.Repository.ClientRepository;
import com.al7irfa.al7irfa.Repository.ConsultationRepository;
import com.al7irfa.al7irfa.Repository.OuvrierRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ConsultationServiceImplementation {



    private final ConsultationRepository consultationRepository ;

    private final  OuvrierRepository ouvrierRepository ;

    private final ClientRepository clientRepository ;

    @Autowired
    public ConsultationServiceImplementation(ConsultationRepository consultationRepository,
                                             OuvrierRepository ouvrierRepository,
                                             ClientRepository clientRepository) {
        this.consultationRepository = consultationRepository;
        this.ouvrierRepository = ouvrierRepository;
        this.clientRepository = clientRepository;
    }

    //    public ConsultationServiceImplementation(ConsultationRepository consultationRepository,
//                                             OuvrierRepository ouvrierRepository ,
//                                             ClientRepository clientRepository) {
//        this.consultationRepository = consultationRepository;
//        this.ouvrierRepository = ouvrierRepository ;
//        this.clientRepository = clientRepository ;
//    }

    public Consultation findConsultationById(Integer id){

        return consultationRepository.findById(id).orElse(null);

    }



    public void save(Consultation consultation){

        consultationRepository.save(consultation);

    }

    public List<Consultation> findConsultationByOuvrierId(int id ){

        return findConsultationByOuvrierId(id);
    }

    public void delete(Consultation consultation){
        consultationRepository.delete(consultation);
    }

    public List<Consultation> findAll(){

        return consultationRepository.findAll();
    }

    public List<Consultation>getConsultationByIdOuvrier(int id){

        return consultationRepository.findConsultationsByOuvrierId(id);
    }


    public void createConsultation(String clientEmail , String ouvrierEmail , String description  ) {

        Client client = clientRepository.findClientByEmail(clientEmail) ;
        Ouvrier ouvrier = ouvrierRepository.findOuvrierByEmail(ouvrierEmail);


        Consultation consultation = new Consultation();
        consultation.setConsultationDate(new Date());
        System.out.println(client.getCin());
        consultation.setClient(client);
        consultation.setVille(client.getVille());
        consultation.setOuvrier(ouvrier);
        consultation.setIsConfirmed(false);
        consultation.setDescription(description);
        consultationRepository.save(consultation);


    }


    public void setConsultaitonConfirmation(int id ){
       Consultation consultation = consultationRepository.findConsultationByIdConsultation(id)  ;
       consultation.setIsConfirmed(true);
        consultationRepository.save(consultation);


    }


    public List<Consultation> findConsultationsByOuvrierIdAndIsConfirmed(int id, boolean b) {
       return consultationRepository.findConsultationsByOuvrierIdAndIsConfirmed(id,false);
    }

    public List<Consultation> findConsultationsByClientIdAndIsConfirmed(int id , boolean c){

        return consultationRepository.findConsultationsByClientIdAndIsConfirmed(id,true);

    }
}
