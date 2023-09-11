package com.al7irfa.al7irfa.Controller;


import com.al7irfa.al7irfa.Entities.Consultation;
import com.al7irfa.al7irfa.Repository.ConsultationRepository;
import com.al7irfa.al7irfa.Repository.OuvrierRepository;
import com.al7irfa.al7irfa.Repository.UserRepository;
import com.al7irfa.al7irfa.Service.ConsultationServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Consultation")
@CrossOrigin("*")
public class ConsultationControlller {

    @Autowired
    private ConsultationServiceImplementation consultationServiceImplementation ;




    @PostMapping("/create")
    public ResponseEntity<String> createConsultation(
            @RequestParam("client_id") String clientEmail,
            @RequestParam("ouvrier_id") String ouvrierEmail) {

        consultationServiceImplementation.createConsultation(clientEmail, ouvrierEmail);
        return ResponseEntity.ok("Consultation created successfully.");
    }














}
