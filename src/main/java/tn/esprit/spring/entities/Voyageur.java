package tn.esprit.spring.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Voyageur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idVoyageur;
    String nom;
    String prenom;
    Date dateNaissance;



    @OneToMany(mappedBy = "voyageur")
    List<Reservation> reservations;

}
