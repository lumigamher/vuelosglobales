// AsignarTripulacionUseCase.java
package com.campus.vuelosglobales.tripcrew.application.usecases;

import org.springframework.stereotype.Component;

import com.campus.vuelosglobales.tripcrew.application.Services.TripCrewService;

@Component
public class AsignarTripulacionUseCase {

    private final TripCrewService tripCrewService;

    public AsignarTripulacionUseCase(TripCrewService tripCrewService) {
        this.tripCrewService = tripCrewService;
    }

    public void execute(Long tripulanteId, Long trayectoId) {
        tripCrewService.asignarTripulanteATrayecto(tripulanteId, trayectoId);
    }
}
