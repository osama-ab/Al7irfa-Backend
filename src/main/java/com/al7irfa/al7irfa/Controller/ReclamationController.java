package com.al7irfa.al7irfa.Controller;


import com.al7irfa.al7irfa.Entities.Reclamation;
import com.al7irfa.al7irfa.Service.ReclamationServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/reclamation")
public class ReclamationController {

    private ReclamationServiceImplementation reclamationServiceImplementation;


    @Autowired
    public ReclamationController(ReclamationServiceImplementation reclamationServiceImplementation){
        this.reclamationServiceImplementation=reclamationServiceImplementation;
    }


    @GetMapping("/{id}")
    public Reclamation GetReclamationById(@PathVariable Integer id){
        return reclamationServiceImplementation.findReclamationById(id);
    }

    @PostMapping("/AddReclamation")
    public void AddReclamation(@RequestBody Reclamation reclamation){
        reclamationServiceImplementation.save(reclamation);
    }
    @DeleteMapping("/DeleteReclamation")
    public void DeleteReclamation(@RequestBody Reclamation reclamation){
        reclamationServiceImplementation.delete(reclamation);
    }

    @GetMapping("/findAllReclamations")
    public List<Reclamation>findAll(){
        return reclamationServiceImplementation.findAll();
    }

}
