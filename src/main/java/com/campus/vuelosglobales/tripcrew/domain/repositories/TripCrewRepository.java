package com.campus.vuelosglobales.tripcrew.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.campus.vuelosglobales.flightconnection.domain.entities.FlightConnection;
import com.campus.vuelosglobales.tripcrew.domain.entities.TripCrew;
import com.campus.vuelosglobales.tripcrew.domain.entities.TripCrewPK;

public interface TripCrewRepository {
    List<TripCrew> findAll();
    Optional<TripCrew> findById(TripCrewPK id);
    TripCrew save(TripCrew tripCrew);
    void deleteById(TripCrewPK id);
    List<TripCrew> findByFlightConnection(FlightConnection flightConnection);
}
