package com.campus.vuelosglobales.tripbooking.infrastructure.adapters.output;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campus.vuelosglobales.trip.domain.entities.Trip;
import com.campus.vuelosglobales.tripbooking.domain.entities.TripBooking;

@Repository
public interface TripBookingPersistenceAdapter extends JpaRepository<TripBooking, Long> {
    List<TripBooking> findByTrip(Trip trip);
}
