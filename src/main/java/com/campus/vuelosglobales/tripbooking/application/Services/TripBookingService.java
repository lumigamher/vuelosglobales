package com.campus.vuelosglobales.tripbooking.application.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.campus.vuelosglobales.trip.domain.entities.Trip;
import com.campus.vuelosglobales.tripbooking.domain.entities.TripBooking;
import com.campus.vuelosglobales.tripbooking.domain.repositories.TripBookingRepository;

@Service
public class TripBookingService {

    private final TripBookingRepository tripBookingRepository;

    public TripBookingService(TripBookingRepository tripBookingRepository) {
        this.tripBookingRepository = tripBookingRepository;
    }

    public List<TripBooking> findAll() {
        return tripBookingRepository.findAll();
    }

    public TripBooking findById(Long id) {
        return tripBookingRepository.findById(id).orElse(null);
    }

    public TripBooking save(TripBooking tripBooking) {
        return tripBookingRepository.save(tripBooking);
    }

    public void deleteById(Long id) {
        tripBookingRepository.deleteById(id);
    }

    public List<TripBooking> findByTrip(Trip trip) {
        return tripBookingRepository.findByTrip(trip);
    }
}
