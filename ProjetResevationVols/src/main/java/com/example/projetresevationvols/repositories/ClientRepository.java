package com.example.projetresevationvols.repositories;

import com.example.projetresevationvols.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findClientByMailAndPassword(String mail,String password);
}