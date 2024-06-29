package com.campus.vuelosglobales.flightconnection.infrastructure.adapters.output;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.campus.vuelosglobales.flightconnection.domain.entities.FlightConnection;
import com.campus.vuelosglobales.flightconnection.domain.repositories.FlightConnectionRepository;

@Component
public class FlightConnectionRepositoryImpl implements FlightConnectionRepository {

    private final FlightConnectionPersistenceAdapter flightConnectionPersistenceAdapter;

    public FlightConnectionRepositoryImpl(FlightConnectionPersistenceAdapter flightConnectionPersistenceAdapter) {
        this.flightConnectionPersistenceAdapter = flightConnectionPersistenceAdapter;
    }

    @Override
    public List<FlightConnection> findAll() {
        return flightConnectionPersistenceAdapter.findAll();
    }

    @Override
    public Optional<FlightConnection> findById(Long id) {
        return flightConnectionPersistenceAdapter.findById(id);
    }

    @Override
    public FlightConnection save(FlightConnection flightConnection) {
        return flightConnectionPersistenceAdapter.save(flightConnection);
    }

    @Override
    public void deleteById(Long id) {
        flightConnectionPersistenceAdapter.deleteById(id);
    }

    
}
