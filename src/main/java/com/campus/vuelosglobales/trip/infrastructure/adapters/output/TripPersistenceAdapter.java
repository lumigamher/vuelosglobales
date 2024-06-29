package com.campus.vuelosglobales.trip.infrastructure.adapters.output;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campus.vuelosglobales.trip.domain.entities.Trip;

@Repository
public interface TripPersistenceAdapter extends JpaRepository<Trip, Long> {
    
}
