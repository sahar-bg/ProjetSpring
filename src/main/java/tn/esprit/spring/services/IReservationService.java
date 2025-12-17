package tn.esprit.spring.services;

import tn.esprit.spring.entities.Reservation;

public interface IReservationService {
    Reservation confirmerReservation(String resId);
    void annulerReservation();
}
