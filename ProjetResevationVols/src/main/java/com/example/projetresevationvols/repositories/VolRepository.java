package com.example.projetresevationvols.repositories;

import com.example.projetresevationvols.entities.Vol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolRepository extends JpaRepository<Vol,Long> {
}
