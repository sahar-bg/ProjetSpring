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
public class Vol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idVol;
    Date dateDepart;
    Date dateArrive;


    @OneToMany(mappedBy = "vol")
    List<Reservation>reservations;
    @ManyToOne
    Aeroport aeroportDepart;

    @ManyToOne
    Aeroport aeroportArrive;

}
