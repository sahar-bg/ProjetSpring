package tn.esprit.spring.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Voyageur;
import tn.esprit.spring.repositories.VoyageurRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class VoyageurService implements IVoyageurService {
    private VoyageurRepository voyageurRepository;
     @Override
     public List<Voyageur> ajouterVoyageurs(List<Voyageur> voyageurs){
         return voyageurRepository.saveAll(voyageurs);
     }
}
