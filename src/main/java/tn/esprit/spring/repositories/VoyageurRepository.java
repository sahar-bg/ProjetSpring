package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.Voyageur;

public interface VoyageurRepository extends JpaRepository<Voyageur, Integer> {
}
