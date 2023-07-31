package com.al7irfa.al7irfa.Repository;


import com.al7irfa.al7irfa.Entities.TypeConsultation;
import com.al7irfa.al7irfa.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TypeConsultationRepository extends JpaRepository<TypeConsultation,Integer> {
}
