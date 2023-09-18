package com.al7irfa.al7irfa.Controller;


import com.al7irfa.al7irfa.Entities.Ouvrier;
import com.al7irfa.al7irfa.Repository.OuvrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ouvrier")
@CrossOrigin("*")
public class OuvrierController {

    private final OuvrierRepository ouvrierRepository ;


    @Autowired
    public OuvrierController(OuvrierRepository ouvrierRepository) {
        this.ouvrierRepository = ouvrierRepository;
    }


    @GetMapping("/getOuvrier")
    public Ouvrier getOuvrier(@RequestParam String email){

        return ouvrierRepository.findOuvrierByEmail(email);

    }
}
