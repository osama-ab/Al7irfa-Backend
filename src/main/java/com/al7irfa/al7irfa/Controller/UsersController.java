package com.al7irfa.al7irfa.Controller;

import com.al7irfa.al7irfa.Entities.Categorie;
import com.al7irfa.al7irfa.Entities.Ouvrier;
import com.al7irfa.al7irfa.Entities.User;
import com.al7irfa.al7irfa.Repository.OuvrierRepository;
import com.al7irfa.al7irfa.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
@CrossOrigin("*")


public class UsersController {

    private final UserRepository userRepository;

    private final OuvrierRepository ouvrierRepository ;


@Autowired
    public UsersController(UserRepository userRepository , OuvrierRepository ouvrierRepository) {
        this.userRepository = userRepository;
        this.ouvrierRepository = ouvrierRepository ;
    }




    @GetMapping ("/u")
    public List<User> getUsers() {

        return userRepository.findAll();
    }


    @GetMapping("/ListOuvrierParams")
    public List<Ouvrier> filterOuvByVilleAndCategorie(@RequestParam(name = "ville", required = false) String ville,
                                                      @RequestParam(name = "category", required = false) Categorie category) {


        if (ville != null && category != null) {
            return ouvrierRepository.findAllByVilleAndCategorie(ville, category);
        } else if (ville != null) {
            return ouvrierRepository.findAllByVille(ville);
        } else if (category != null) {
            return ouvrierRepository.findAllByCategorie(category);
        }
        return ouvrierRepository.findAll();
    }

        @GetMapping ("/ListOuvrier")

    public List<Ouvrier> getOuvriers() {


        return ouvrierRepository.findAll();
    }


    


//    @GetMapping ("/getUser")
//    public ResponseEntity<> getUserByEmail(String email ){
//
//      return userRepository.findByEmail(email) ;
//    }






}
