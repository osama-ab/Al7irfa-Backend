package com.al7irfa.al7irfa.Controller;


import com.al7irfa.al7irfa.Entities.Consultation;
import com.al7irfa.al7irfa.Repository.ConsultationRepository;
import com.al7irfa.al7irfa.Service.ConsultationServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultation")
public class ConsultationController {

    private ConsultationServiceImplementation consultationServiceImplementation;


    @Autowired
    public ConsultationController(ConsultationServiceImplementation consultationServiceImplementation){
        this.consultationServiceImplementation=consultationServiceImplementation;
    }


    @GetMapping("/{id}")
    public Consultation GetConsultationById(@PathVariable Integer id){
        return consultationServiceImplementation.findConsultationById(id);
    }

    @PostMapping("/AddConsultation")
    public void AddConsultation(@RequestBody Consultation consultation){
         consultationServiceImplementation.save(consultation);
    }

    @DeleteMapping("/DeleteConsultation")
    public void DeleteConsultation(@RequestBody Consultation consultation){
        consultationServiceImplementation.delete(consultation);
    }

    @GetMapping("/ShowConsultations")
    public List<Consultation> DisplayAllConsultations(){
        return consultationServiceImplementation.findAll();
    }
}
