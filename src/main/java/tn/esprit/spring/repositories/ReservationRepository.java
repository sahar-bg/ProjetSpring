package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.ClassPlace;
import tn.esprit.spring.entities.EtatReservation;
import tn.esprit.spring.entities.Reservation;
import tn.esprit.spring.entities.Vol;

import java.util.Collection;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
    List<Reservation> findByVolAndClassPlace(Vol vol, ClassPlace classPlace);

    List<Reservation> findByEtatReservation(EtatReservation etatReservation);
}
