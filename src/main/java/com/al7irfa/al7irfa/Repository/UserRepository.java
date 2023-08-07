package com.al7irfa.al7irfa.Repository;


import com.al7irfa.al7irfa.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Integer> {



    Optional<User> findByEmail(String email);
}
