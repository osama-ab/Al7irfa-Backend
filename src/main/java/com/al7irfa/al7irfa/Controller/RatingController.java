package com.al7irfa.al7irfa.Controller;


import com.al7irfa.al7irfa.Entities.Rating;
import com.al7irfa.al7irfa.Service.RatingServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
@CrossOrigin("*")


public class RatingController {

    private RatingServiceImplementation ratingServiceImplementation;

    @Autowired
    public RatingController(RatingServiceImplementation ratingServiceImplementation){
        this.ratingServiceImplementation=ratingServiceImplementation;
    }

    @GetMapping("/FindAll")
    public List<Rating>findAllRatings(){
        return ratingServiceImplementation.findAll();
    }


    @PostMapping("/create")
    public ResponseEntity<String> createRating( @RequestParam String email_ouvrier
                                               , @RequestParam int note ){

        ratingServiceImplementation.createRating(email_ouvrier,note);

        return ResponseEntity.ok("Rating OK") ;
    }


    @GetMapping("/FindRatingByOuvrier")
    public Rating FindRatingByOuvrier(@RequestParam int id){
        return ratingServiceImplementation.FindRateByOuvrier(id);
    }
}
