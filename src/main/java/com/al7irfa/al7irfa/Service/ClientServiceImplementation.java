package com.al7irfa.al7irfa.Service;

import com.al7irfa.al7irfa.Entities.Client;
import com.al7irfa.al7irfa.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImplementation {


        private  ClientRepository clientRepository ;

        @Autowired
    public ClientServiceImplementation(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

      public Client findClientById(Integer id){

                return clientRepository.findById(id).orElse(null);

      }

      public void save(Client client){

            clientRepository.save(client);

      }

      public void delete(Client client){
            clientRepository.delete(client);
      }

      public List<Client> findAll(){

            return clientRepository.findAll();
      }

}
