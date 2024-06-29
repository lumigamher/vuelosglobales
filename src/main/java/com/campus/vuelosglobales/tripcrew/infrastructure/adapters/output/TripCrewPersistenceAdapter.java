package com.campus.vuelosglobales.tripcrew.infrastructure.adapters.output;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campus.vuelosglobales.flightconnection.domain.entities.FlightConnection;
import com.campus.vuelosglobales.tripcrew.domain.entities.TripCrew;
import com.campus.vuelosglobales.tripcrew.domain.entities.TripCrewPK;

@Repository
public interface TripCrewPersistenceAdapter extends JpaRepository<TripCrew, TripCrewPK> {
    List<TripCrew> findByFlightConnection(FlightConnection flightConnection);
}
