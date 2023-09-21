package com.al7irfa.al7irfa.Controller;


import com.al7irfa.al7irfa.Entities.Ouvrier;
import com.al7irfa.al7irfa.Repository.OuvrierRepository;
import com.al7irfa.al7irfa.Service.OuvrierServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ouvrier")
@CrossOrigin("*")
public class OuvrierController {

    private final OuvrierRepository ouvrierRepository ;

    private final OuvrierServiceImplementation ouvrierServiceImplementation ;


    @Autowired
    public OuvrierController(OuvrierRepository ouvrierRepository,
                             OuvrierServiceImplementation ouvrierServiceImplementation) {
        this.ouvrierRepository = ouvrierRepository;
        this.ouvrierServiceImplementation =ouvrierServiceImplementation;
    }


    @GetMapping("/getOuvrier")
    public Ouvrier getOuvrier(@RequestParam String email){

        return ouvrierRepository.findOuvrierByEmail(email);

    }

    @GetMapping("/getOuvrierbyid")
    public Ouvrier getOuvrierByConsultation(@RequestParam int id){
        return ouvrierServiceImplementation.findOuvrierByConsultation(id);
    }

}
