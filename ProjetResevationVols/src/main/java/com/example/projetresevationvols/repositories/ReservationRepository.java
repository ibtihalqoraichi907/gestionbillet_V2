package com.example.projetresevationvols.repositories;

import com.example.projetresevationvols.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> getAllByRel(Long rel);
}
