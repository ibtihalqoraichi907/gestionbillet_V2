package com.example.projetresevationvols.services;

import com.example.projetresevationvols.entities.Vol;
import com.example.projetresevationvols.repositories.VolRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VolService {

    private VolRepository volRepository;


    public Vol getVolById(Long id) {
        return volRepository.findById(id).orElse(null);
    }

    public List<Vol> getAllVols() {
        return volRepository.findAll();
    }

    public Vol saveVol(Vol vol) {
        return volRepository.save(vol);
    }

    public Vol updateVol(Vol updatedVol) {
       return volRepository.save(updatedVol);
    }

    public void deleteVol(Long id) {
        volRepository.deleteById(id);
    }
}
