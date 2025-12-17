package tn.esprit.spring.services;

import tn.esprit.spring.entities.EtatReservation;
import tn.esprit.spring.entities.Reservation;
import tn.esprit.spring.entities.Vol;
import tn.esprit.spring.repositories.ReservationRepository;

import java.util.List;

public class ReservationService implements IReservationService {
    private ReservationRepository reservationRepository;
    @Override
    public Reservation confirmerReservation(String resId) {
        // Trouver la réservation
        Reservation reservation = reservationRepository.findById(resId).orElse(null);

        if (reservation != null) {
            reservation.setEtatReservation(EtatReservation.CONFIRMEE);
            return reservationRepository.save(reservation);
        }

        return null; // si la réservation n'existe pas

    }

    @Override
    public void annulerReservation(){
    // 1️⃣ Récupérer toutes les réservations dont l'état est ENCOURS
    List<Reservation> enCoursReservations = reservationRepository
            .findByEtatReservation(EtatReservation.ENCOURS);

    // 2️⃣ Parcourir chaque réservation en cours
    for (Reservation res : enCoursReservations) {

        // Récupérer le vol associé à la réservation
        Vol vol = res.getVol();

        // Vérifier que le vol et sa date de départ ne sont pas nuls
        if (vol == null || vol.getDateDepart() == null) continue;

        // 3️⃣ Calculer la différence en jours entre aujourd'hui et la date de départ du vol
        long diffDays = java.time.temporal.ChronoUnit.DAYS.between(
                java.time.LocalDate.now(), // date du jour
                vol.getDateDepart().toInstant() // conversion Date → Instant
                        .atZone(java.time.ZoneId.systemDefault()) // fuseau système
                        .toLocalDate() // conversion en LocalDate
        );

        // 4️⃣ Si le vol part aujourd'hui ou demain (différence ≤ 1 jour)
        if (diffDays <= 1) {

            // Changer l'état de la réservation en ANNULEE
            res.setEtatReservation(EtatReservation.ANNULEE);

            // Sauvegarder la modification dans la base
            reservationRepository.save(res);

            // 5️⃣ Afficher un message dans la console pour suivre les annulations
            System.out.println("Réservation annulée : " + res.getIdReservation()
                    + " - Voyageur : " + res.getVoyageur().getIdVoyageur()
                    + " - Vol : " + vol.getIdVol());
        }
    }

    }
}
