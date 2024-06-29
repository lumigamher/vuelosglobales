package com.campus.vuelosglobales.airport.infrastructure.adapters.output;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campus.vuelosglobales.airport.domain.entities.Airport;

@Repository
public interface AirportPersistenceAdapter extends JpaRepository<Airport, Long> {

}
