package com.example.projetresevationvols.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateDepart;
    private String dateArrive;
    private String compagnie;
    private String aeroport;
    private String escale;
    private Long rel;

    @OneToMany(fetch = FetchType.LAZY)
    List<Reservation> reservationList;

}
