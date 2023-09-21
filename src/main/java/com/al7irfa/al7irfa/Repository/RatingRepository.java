package com.al7irfa.al7irfa.Repository;


import com.al7irfa.al7irfa.Entities.Ouvrier;
import com.al7irfa.al7irfa.Entities.Rating;
import com.al7irfa.al7irfa.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;




public interface RatingRepository extends JpaRepository<Rating,Integer> {

    Rating findRatingByOuvrier(Ouvrier ouvrier);
}
