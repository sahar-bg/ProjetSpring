package tn.esprit.spring.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.repositories.AeroportRepository;
import tn.esprit.spring.repositories.ReservationRepository;
import tn.esprit.spring.repositories.VolRepository;
import tn.esprit.spring.repositories.VoyageurRepository;

import java.time.LocalDate;
import java.util.Date;

@Service
@AllArgsConstructor
public class VolService implements IVolService {
    private VolRepository volRepository;
    private AeroportRepository aeroportRepository;
    private VoyageurRepository voyageurRepository;
    private ReservationRepository reservationRepository;

 @Override
 public String ajouterVolEtAeroport(Vol vol){
     // Vérification des codes AITA
     if(vol.getAeroportDepart().getCodeAITA().equalsIgnoreCase(vol.getAeroportArrive().getCodeAITA())) {
         return "Vérifier les aéroports saisis !";
     }
     // Sauvegarde des aéroports et du vol
     aeroportRepository.save(vol.getAeroportDepart());
     aeroportRepository.save(vol.getAeroportArrive());
     volRepository.save(vol);

     return "Le vol est ajouté avec succès !";


}

    @Override
    public String reserverVol(int voyageurId, int volId, ClassPlace classPlace) {

        // Récupérer le vol depuis la base de données à partir de son ID
        // Si le vol n'existe pas, vol sera null
        Vol vol = volRepository.findById(volId).orElse(null);

        // Récupérer le voyageur depuis la base de données à partir de son ID
        // Si le voyageur n'existe pas, voyageur sera null
        Voyageur voyageur = voyageurRepository.findById(voyageurId).orElse(null);

        // Compter le nombre de réservations existantes pour ce vol et cette classe
        // findByVolAndClassPlace retourne une liste de réservations
        int nbReservations = reservationRepository
                .findByVolAndClassPlace(vol, classPlace)
                .size();

        // Définir le nombre maximum de places selon la classe
        // BUSINESS → 2 places
        // Autres classes → 3 places
        int maxPlaces = (classPlace == ClassPlace.BUSINESS) ? 2 : 3;

        // Vérifier si la classe est complète
        if (nbReservations >= maxPlaces) {
            // Si aucune place n'est disponible, retourner un message d'erreur
            return "La classe '" + classPlace + "' du vol " + volId + " est complet";
        }

        // Générer un identifiant unique pour la réservation
        // Exemple : BUS-10-5
        String idReservation =
                classPlace.name().substring(0, 3) + "-" + volId + "-" + voyageurId;

        // Créer une nouvelle instance de réservation
        Reservation reservation = new Reservation();

        reservation.setIdReservation(idReservation);

        // Associer le vol à la réservation
        reservation.setVol(vol);

        // Associer le voyageur à la réservation
        reservation.setVoyageur(voyageur);

        // Définir la classe de la place réservée
        reservation.setClassPlace(classPlace);

        // Définir l'état de la réservation (en cours)
        reservation.setEtatReservation(EtatReservation.ENCOURS);

        // Définir la date de réservation à la date du jour
       // reservation.setDateReservation(LocalDate.now());
        // Conversion LocalDate → java.util.Date pour dateReservation
        Date date = Date.from(java.time.LocalDate.now()
                .atStartOfDay(java.time.ZoneId.systemDefault())
                .toInstant());
        reservation.setDateReservation(date);

        // Sauvegarder la réservation dans la base de données
        reservationRepository.save(reservation);

        // Retourner un message confirmant la réservation
        return "L'affectation du voyageur est effectué avec succès : " + idReservation;
    }


}
