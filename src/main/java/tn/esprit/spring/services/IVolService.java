package tn.esprit.spring.services;

import tn.esprit.spring.entities.ClassPlace;
import tn.esprit.spring.entities.Vol;

public interface IVolService {
    String ajouterVolEtAeroport(Vol vol);
    String reserverVol(int voyageurId, int volId, ClassPlace classPlace);
}
