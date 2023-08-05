package com.al7irfa.al7irfa.Service;

import com.al7irfa.al7irfa.Entities.Client;
import com.al7irfa.al7irfa.Entities.User;
import com.al7irfa.al7irfa.Repository.ClientRepository;
import com.al7irfa.al7irfa.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(Integer id){

        return userRepository.findById(id).orElse(null);

    }

    public void save(User user){

        userRepository.save(user);

    }

    public void delete(User user){
        userRepository.delete(user);
    }

    public List<User> findAll(){

        return userRepository.findAll();
    }

}
