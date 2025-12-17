package tn.esprit.spring.restcontrollers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entities.Voyageur;
import tn.esprit.spring.services.IVoyageurService;

import java.util.List;

@RestController
@RequestMapping("/api/voyageur")
@RequiredArgsConstructor
public class VoyageurRestController {
    private final IVoyageurService voyageurService;

    @PostMapping("/ajouterVoyageur")
        public List<Voyageur> ajouterVoyageurs(@RequestBody List<Voyageur> voyageurs) {
            return voyageurService.ajouterVoyageurs(voyageurs);
        }
    }

