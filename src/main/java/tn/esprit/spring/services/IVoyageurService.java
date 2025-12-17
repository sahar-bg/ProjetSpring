package tn.esprit.spring.services;

import tn.esprit.spring.entities.Voyageur;

import java.util.List;

public interface IVoyageurService {
    List<Voyageur> ajouterVoyageurs(List<Voyageur> voyageurs);
}
