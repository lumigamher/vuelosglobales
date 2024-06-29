package com.campus.vuelosglobales.tripcrew.infrastructure.adapters.output;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.campus.vuelosglobales.flightconnection.domain.entities.FlightConnection;
import com.campus.vuelosglobales.tripcrew.domain.entities.TripCrew;
import com.campus.vuelosglobales.tripcrew.domain.entities.TripCrewPK;
import com.campus.vuelosglobales.tripcrew.domain.repositories.TripCrewRepository;

@Component
public class TripCrewRepositoryImpl implements TripCrewRepository {

    private final TripCrewPersistenceAdapter tripCrewPersistenceAdapter;

    public TripCrewRepositoryImpl(TripCrewPersistenceAdapter tripCrewPersistenceAdapter) {
        this.tripCrewPersistenceAdapter = tripCrewPersistenceAdapter;
    }

    @Override
    public List<TripCrew> findAll() {
        return tripCrewPersistenceAdapter.findAll();
    }

    @Override
    public Optional<TripCrew> findById(TripCrewPK id) {
        return tripCrewPersistenceAdapter.findById(id);
    }

    @Override
    public TripCrew save(TripCrew tripCrew) {
        return tripCrewPersistenceAdapter.save(tripCrew);
    }

    @Override
    public void deleteById(TripCrewPK id) {
        tripCrewPersistenceAdapter.deleteById(id);
    }

    @Override
    public List<TripCrew> findByFlightConnection(FlightConnection flightConnection) {
        return tripCrewPersistenceAdapter.findByFlightConnection(flightConnection);
    }
}
