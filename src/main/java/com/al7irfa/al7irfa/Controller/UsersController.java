package com.al7irfa.al7irfa.Controller;

import com.al7irfa.al7irfa.Entities.User;
import com.al7irfa.al7irfa.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
@CrossOrigin("*")


public class UsersController {

    private final UserRepository userRepository;


@Autowired
    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }




    @GetMapping ("/u")
    public List<User> getUsers() {

        return userRepository.findAll();
    }

//    @GetMapping ("/getUser")
//    public ResponseEntity<> getUserByEmail(String email ){
//
//      return userRepository.findByEmail(email) ;
//    }






}
