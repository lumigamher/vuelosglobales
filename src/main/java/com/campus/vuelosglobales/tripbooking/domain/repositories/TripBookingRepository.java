package com.campus.vuelosglobales.tripbooking.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.campus.vuelosglobales.trip.domain.entities.Trip;
import com.campus.vuelosglobales.tripbooking.domain.entities.TripBooking;

public interface TripBookingRepository {
    List<TripBooking> findAll();
    Optional<TripBooking> findById(Long id);
    TripBooking save(TripBooking tripBooking);
    void deleteById(Long id);
    List<TripBooking> findByTrip(Trip trip);
}
