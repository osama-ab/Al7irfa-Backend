package com.al7irfa.al7irfa.Service;

import com.al7irfa.al7irfa.Entities.Client;
import com.al7irfa.al7irfa.Entities.Consultation;
import com.al7irfa.al7irfa.Entities.Review;
import com.al7irfa.al7irfa.Repository.ClientRepository;
import com.al7irfa.al7irfa.Repository.ConsultationRepository;
import com.al7irfa.al7irfa.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImplementation {
    private ReviewRepository reviewRepository;

    private ConsultationRepository consultationRepository ;

    @Autowired
    public ReviewServiceImplementation (ReviewRepository reviewRepository ,ConsultationRepository consultationRepository) {
        this.reviewRepository = reviewRepository;
        this.consultationRepository = consultationRepository;
    }

    public Review findReviewById(Integer id){

        return reviewRepository.findById(id).orElse(null);

    }

    public void save(Review review){

        reviewRepository.save(review);

    }

    public void delete(Review review){
        reviewRepository.delete(review);
    }

    public List<Review> findAll(){

        return reviewRepository.findAll();
    }

    public void createReview(int id_consultation , String commentaire){

      Consultation consultation =  consultationRepository.findConsultationByIdConsultation(id_consultation);

      Review review = new Review();
      review.setConsultation(consultation);
      review.setCommentaire(commentaire);

      consultation.setReview(review);

            reviewRepository.save(review);
            consultationRepository.save(consultation);





    }


}
