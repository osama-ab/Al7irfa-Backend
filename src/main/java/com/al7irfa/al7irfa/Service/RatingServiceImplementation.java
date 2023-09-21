package com.al7irfa.al7irfa.Service;

import com.al7irfa.al7irfa.Entities.Client;
import com.al7irfa.al7irfa.Entities.Ouvrier;
import com.al7irfa.al7irfa.Entities.Rating;
import com.al7irfa.al7irfa.Repository.ClientRepository;
import com.al7irfa.al7irfa.Repository.OuvrierRepository;
import com.al7irfa.al7irfa.Repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImplementation {
    private RatingRepository ratingRepository;

    private OuvrierRepository ouvrierRepository;

    private ClientRepository clientRepository ;

    @Autowired
    public RatingServiceImplementation( RatingRepository ratingRepository
                                        ,OuvrierRepository ouvrierRepository
                                         ,ClientRepository clientRepository   ) {
        this.ratingRepository = ratingRepository;
        this.clientRepository = clientRepository;
        this.ouvrierRepository = ouvrierRepository;
    }

    public Rating findRatingById(Integer id){

        return ratingRepository.findById(id).orElse(null);

    }

    public void save(Rating rating){

        ratingRepository.save(rating);

    }

    public void delete(Rating rating){
        ratingRepository.delete(rating);
    }

    public List<Rating> findAll(){

        return ratingRepository.findAll();
    }

    public void createRating( String email_ouvrier , int note  ){




        Ouvrier ouvrier = ouvrierRepository.findOuvrierByEmail(email_ouvrier);

           Rating rating = ratingRepository.findRatingByOuvrier(ouvrier);


        if( rating == null ){

            rating = new Rating() ;


            rating.setOuvrier(ouvrier);
            rating.setNote(note);
            ratingRepository.save(rating);

        }

        else {
          int  noteNew =  rating.getNote() + note ;

          rating.setNote(noteNew);

            ratingRepository.save(rating);

        }







    }

}
