package com.al7irfa.al7irfa.Controller;


import com.al7irfa.al7irfa.Entities.Consultation;
import com.al7irfa.al7irfa.Repository.ConsultationRepository;
import com.al7irfa.al7irfa.Repository.OuvrierRepository;
import com.al7irfa.al7irfa.Repository.UserRepository;
import com.al7irfa.al7irfa.Service.ConsultationServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Consultation")
@CrossOrigin("*")

public class ConsultationControlller {


    private final  ConsultationServiceImplementation consultationServiceImplementation ;

    @Autowired
    public ConsultationControlller(ConsultationServiceImplementation consultationServiceImplementation) {
        this.consultationServiceImplementation = consultationServiceImplementation;
    }

    @GetMapping("/getAll")
    public List<Consultation> getAllConsultations(){

        return consultationServiceImplementation.findAll();
    }

    @GetMapping("/ConsultationById")

    public List<Consultation> getConsultationsByOuvrier(@RequestParam("ouvrier5_id") int id){

        return consultationServiceImplementation.findConsultationsByOuvrierIdAndIsConfirmed(id,false);
    }



    @GetMapping("/ConsultationByClient")

    public List<Consultation> getConsultationsByClient(@RequestParam int id){

        return consultationServiceImplementation.findConsultationsByClientIdAndIsConfirmed(id,true);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createConsultation(
            @RequestParam("client_id") String clientEmail,
            @RequestParam("ouvrier_id") String ouvrierEmail,
            @RequestParam String description)
            {

        consultationServiceImplementation.createConsultation(clientEmail, ouvrierEmail , description);
        return ResponseEntity.ok("Consultation created successfully.");
    }


            @PostMapping("/confirm")
          public ResponseEntity<String> confirmConsultation(@RequestParam int id ){

                consultationServiceImplementation.setConsultaitonConfirmation(id);
                return ResponseEntity.ok("CONFIRMED") ;
            }
















}
