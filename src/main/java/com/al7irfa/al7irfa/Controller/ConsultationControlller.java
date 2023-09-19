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

        return consultationServiceImplementation.getConsultationByIdOuvrier(id);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createConsultation(
            @RequestParam("client_id") String clientEmail,
            @RequestParam("ouvrier_id") String ouvrierEmail) {

        consultationServiceImplementation.createConsultation(clientEmail, ouvrierEmail);
        return ResponseEntity.ok("Consultation created successfully.");
    }


















}
