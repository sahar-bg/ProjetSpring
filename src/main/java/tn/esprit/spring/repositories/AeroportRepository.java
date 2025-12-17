package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.Aeroport;

public interface AeroportRepository extends JpaRepository<Aeroport, Integer> {
}
