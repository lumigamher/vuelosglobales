// ConsultarAsignacionesUseCase.java
package com.campus.vuelosglobales.tripcrew.application.usecases;

import org.springframework.stereotype.Component;

import com.campus.vuelosglobales.tripcrew.application.Services.TripCrewService;
import com.campus.vuelosglobales.tripcrew.domain.entities.TripCrew;

import java.util.List;

@Component
public class ConsultarAsignacionesUseCase {

    private final TripCrewService tripCrewService;

    public ConsultarAsignacionesUseCase(TripCrewService tripCrewService) {
        this.tripCrewService = tripCrewService;
    }

    public void execute(Long trayectoId) {
        List<TripCrew> asignaciones = tripCrewService.consultarAsignacionesDeTripulacion(trayectoId);
        // Aquí puedes implementar la lógica para mostrar o manejar las asignaciones encontradas
        asignaciones.forEach(System.out::println);
    }
}

