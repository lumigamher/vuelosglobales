package com.campus.vuelosglobales.airport.infrastructure.adapters.output;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.campus.vuelosglobales.airport.domain.entities.Airport;
import com.campus.vuelosglobales.airport.domain.repositories.AirportRepository;

@Repository
public class AirportRepositoryImpl implements AirportRepository {

    private final AirportPersistenceAdapter airportPersistenceAdapter;

    public AirportRepositoryImpl(AirportPersistenceAdapter airportPersistenceAdapter) {
        this.airportPersistenceAdapter = airportPersistenceAdapter;
    }

    @Override
    public List<Airport> findAll() {
        return airportPersistenceAdapter.findAll();
    }

    @Override
    public Optional<Airport> findById(long id) {
        return airportPersistenceAdapter.findById(id);
    }

    @Override
    public Airport save(Airport airport) {
        return airportPersistenceAdapter.save(airport);
    }

    @Override
    public void deleteById(long id) {
        airportPersistenceAdapter.deleteById(id);
    }

}
