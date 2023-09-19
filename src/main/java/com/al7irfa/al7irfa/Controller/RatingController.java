package com.al7irfa.al7irfa.Controller;


import com.al7irfa.al7irfa.Entities.Rating;
import com.al7irfa.al7irfa.Service.RatingServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rating")

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
}
