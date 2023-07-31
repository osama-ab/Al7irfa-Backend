package com.al7irfa.al7irfa.Repository;

import com.al7irfa.al7irfa.Entities.Reclamation;
import com.al7irfa.al7irfa.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReclamationRepository extends JpaRepository<Reclamation,Integer> {
}
