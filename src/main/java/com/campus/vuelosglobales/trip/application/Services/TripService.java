package com.campus.vuelosglobales.trip.application.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.campus.vuelosglobales.trip.domain.entities.Trip;
import com.campus.vuelosglobales.trip.domain.repositories.TripRepository;

@Service
public class TripService {

    private final TripRepository tripRepository;


    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    public Trip findById(Long id) {
        return tripRepository.findById(id).orElse(null);
    }

    public Trip save(Trip trip) {
        return tripRepository.save(trip);
    }

    public void deleteById(Long id) {
        tripRepository.deleteById(id);
    }    
}
