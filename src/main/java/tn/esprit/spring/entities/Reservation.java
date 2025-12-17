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
public class Reservation {
    @Id

    String idReservation;
    Date dateReservation;
    @Enumerated(EnumType.STRING)
    ClassPlace classPlace;
    @Enumerated(EnumType.STRING)
    EtatReservation etatReservation;

    @ManyToOne
    Voyageur voyageur;

    @ManyToOne
    Vol vol;
}
