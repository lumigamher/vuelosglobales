package com.campus.vuelosglobales.tripbooking.infrastructure.adapters.output;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.campus.vuelosglobales.trip.domain.entities.Trip;
import com.campus.vuelosglobales.tripbooking.domain.entities.TripBooking;
import com.campus.vuelosglobales.tripbooking.domain.repositories.TripBookingRepository;

@Component
public class TripBookingRepositoryImpl implements TripBookingRepository {

    private final TripBookingPersistenceAdapter tripBookingPersistenceAdapter;

    public TripBookingRepositoryImpl(TripBookingPersistenceAdapter tripBookingPersistenceAdapter) {
        this.tripBookingPersistenceAdapter = tripBookingPersistenceAdapter;
    }

    @Override
    public List<TripBooking> findAll() {
        return tripBookingPersistenceAdapter.findAll();
    }

    @Override
    public Optional<TripBooking> findById(Long id) {
        return tripBookingPersistenceAdapter.findById(id);
    }

    @Override
    public TripBooking save(TripBooking tripBooking) {
        return tripBookingPersistenceAdapter.save(tripBooking);
    }

    @Override
    public void deleteById(Long id) {
        tripBookingPersistenceAdapter.deleteById(id);
    }

    @Override
    public List<TripBooking> findByTrip(Trip trip) {
        return tripBookingPersistenceAdapter.findByTrip(trip);
    }
}
