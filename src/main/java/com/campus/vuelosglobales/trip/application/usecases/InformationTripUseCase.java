package com.campus.vuelosglobales.trip.application.usecases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.campus.vuelosglobales.trip.domain.entities.Trip;
import com.campus.vuelosglobales.plane.application.usecases.InformationPlaneUseCase;
import com.campus.vuelosglobales.plane.application.usecases.UseCase;
import com.campus.vuelosglobales.trip.application.Services.TripService;

@Component
public class InformationTripUseCase implements UseCase {
    private final TripService tripService;
    private final InformationPlaneUseCase informationPlaneUseCase;
    private final Logger logger = LoggerFactory.getLogger(InformationTripUseCase.class);

    
    public InformationTripUseCase(TripService tripService, InformationPlaneUseCase informationPlaneUseCase) {
        this.tripService = tripService;
        this.informationPlaneUseCase = informationPlaneUseCase;
    }

    @SuppressWarnings("resource")
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        try {
            logger.info("Consultando información del trayecto...");

            System.out.print("Ingrese el ID del trayecto a consultar: ");
            try {
                Long id = Long.parseLong(scanner.nextLine());
                logger.info("Consultando información del trayecto con ID: {}", id);

                Trip trip = tripService.findById(id);
                if (trip == null) {
                    logger.warn("Trayecto no encontrado con ID: {}", id);
                    System.out.println("Trayecto no encontrado.");
                    return;
                }

                mostrarInformacionDelTrayecto(trip);

            } catch (NumberFormatException e) {
                logger.error("Error al convertir el ID: {}", e.getMessage());
                System.out.println("Error: Ingrese un ID válido.");
            }
        } catch (Exception e) {
            logger.error("Error inesperado: {}", e.getMessage());
            System.out.println("Error: Ocurrió un error inesperado.");
        }
    }

    public void mostrarInformacionDelTrayecto(Trip trip) {
        System.out.println("+-----------------+----------------------+");
        System.out.println("| Campo           | Valor                |");
        System.out.println("+-----------------+----------------------+");
        System.out.printf("| ID               | %-20s |\n", trip.getId());
        System.out.printf("| Fecha de Trayecto| %-20s |\n", formatDate(trip.getTrip_date()));
        System.out.printf("| Precio del Trayecto| %-20.2f |\n", trip.getPrice_trip());
        if (trip.getPlane() != null) {
            System.out.println("+-----------------+----------------------+");
            System.out.println("| Información del Avión                  |");
            System.out.println("+-----------------+----------------------+");
            informationPlaneUseCase.mostrarInformacionDelAvion(trip.getPlane());
        }
        System.out.println("+-----------------+----------------------+");
    }

    private String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
    }
}
