package com.al7irfa.al7irfa.Controller;


import com.al7irfa.al7irfa.Service.ConsultationServiceImplementation;
import com.al7irfa.al7irfa.Service.ReviewServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
@CrossOrigin("*")
public class ReviewController {


    private final ReviewServiceImplementation reviewServiceImplementation ;

    private final ConsultationServiceImplementation consultationServiceImplementation ;


    @Autowired

    public ReviewController(ReviewServiceImplementation reviewServiceImplementation ,
                            ConsultationServiceImplementation consultationServiceImplementation) {
        this.reviewServiceImplementation = reviewServiceImplementation;
        this.consultationServiceImplementation = consultationServiceImplementation ;
    }


    @PostMapping("/create")
    public ResponseEntity<String> createReview(@RequestParam int id , @RequestParam String commentaire){

        reviewServiceImplementation.createReview(id,commentaire);
        return ResponseEntity.ok("OK ");
    }


//    @GetMapping("/getall")
//
//    public ResponseEntity<String> getAllReview(@RequestParam int id){
//
//
//
//    }
}
