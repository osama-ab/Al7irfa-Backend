package com.al7irfa.al7irfa.Service;

import com.al7irfa.al7irfa.Entities.Admin;
import com.al7irfa.al7irfa.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImplementation {
    private AdminRepository adminRepository;

    @Autowired

    public AdminServiceImplementation(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }
    public Admin findAdminById(Integer id){
        return adminRepository.findById(id).orElse(null);
    }
    public void save(Admin admin){
        adminRepository.save(admin);
    }
    public void delete(Admin admin){adminRepository.delete(admin);}

    public List<Admin> findAll(){
        return adminRepository.findAll();
    }
}
