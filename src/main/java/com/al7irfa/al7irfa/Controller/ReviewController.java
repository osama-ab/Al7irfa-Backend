package com.al7irfa.al7irfa.Controller;


import com.al7irfa.al7irfa.Service.ReviewServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
@CrossOrigin("*")
public class ReviewController {


    private final ReviewServiceImplementation reviewServiceImplementation ;


    @Autowired

    public ReviewController(ReviewServiceImplementation reviewServiceImplementation) {
        this.reviewServiceImplementation = reviewServiceImplementation;
    }


    @PostMapping("/create")
    public ResponseEntity<String> createReview(@RequestParam int id , @RequestParam String commentaire){

        reviewServiceImplementation.createReview(id,commentaire);
        return ResponseEntity.ok("OK ");
    }
}
