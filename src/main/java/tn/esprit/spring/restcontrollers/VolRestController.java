package tn.esprit.spring.restcontrollers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.ClassPlace;
import tn.esprit.spring.entities.Vol;
import tn.esprit.spring.services.IVolService;
import tn.esprit.spring.services.VolService;

@RestController
@RequestMapping("/api/vols")
@RequiredArgsConstructor
public class VolRestController {
    private final IVolService volService;  // <--- "final" + injection automatique avec Lombok

    @PostMapping("/ajouterVolEtAeroport")
    public String ajouterVolEtAeroport(@RequestBody Vol vol) {
        return volService.ajouterVolEtAeroport(vol);
    }

    @PostMapping("/reserverVol")
    public String reserverVol(
            @RequestParam int voyageurId,
            @RequestParam int volId,
            @RequestParam ClassPlace classPlace) {

        return volService.reserverVol(voyageurId, volId, classPlace);
    }
    }


