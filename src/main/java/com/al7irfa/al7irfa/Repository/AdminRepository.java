package com.al7irfa.al7irfa.Repository;

import com.al7irfa.al7irfa.Entities.Admin;
import com.al7irfa.al7irfa.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminRepository extends JpaRepository<Admin,Integer> {
}
