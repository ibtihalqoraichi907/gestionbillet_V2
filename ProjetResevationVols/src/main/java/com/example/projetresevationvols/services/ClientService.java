package com.example.projetresevationvols.services;

import com.example.projetresevationvols.entities.Client;
import com.example.projetresevationvols.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private ClientRepository clientRepository;


    public Client getClientById(Long id) {
        return clientRepository.findById(id).get();
    }


    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Client client){return clientRepository.save(client);}

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public Client login(String mail,String password) {
        return clientRepository.findClientByMailAndPassword(mail,password);
    }
}
