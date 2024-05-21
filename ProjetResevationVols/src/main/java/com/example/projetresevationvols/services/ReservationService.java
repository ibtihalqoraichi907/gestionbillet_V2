package com.example.projetresevationvols.services;

import com.example.projetresevationvols.entities.Reservation;
import com.example.projetresevationvols.repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService {

    private ReservationRepository reservationRepository;


    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Reservation updatedReservation) {
       return reservationRepository.save(updatedReservation);}

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
    public List<Reservation> getAllByRel(Long rel){
        return  reservationRepository.getAllByRel(rel);
    }
}
