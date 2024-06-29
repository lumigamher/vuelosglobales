package com.campus.vuelosglobales.flightconnection.infrastructure.adapters.output;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.campus.vuelosglobales.flightconnection.domain.entities.FlightConnection;

import jakarta.transaction.Transactional;

@Repository
public interface FlightConnectionPersistenceAdapter extends JpaRepository<FlightConnection, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE FlightConnection fc SET fc.plane = NULL WHERE fc.plane.id = :planeId")
    void setPlaneToNull(Long planeId);
}
