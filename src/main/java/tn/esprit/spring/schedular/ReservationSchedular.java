package tn.esprit.spring.schedular;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tn.esprit.spring.services.IReservationService;


@Component
@AllArgsConstructor
@Slf4j
public class ReservationSchedular {
     IReservationService reservationService;
    // Exécutée toutes les 60 secondes
    @Scheduled(fixedRate = 60000)
    public void annulerReservationsScheduler() {
        reservationService.annulerReservation();
    }
}
