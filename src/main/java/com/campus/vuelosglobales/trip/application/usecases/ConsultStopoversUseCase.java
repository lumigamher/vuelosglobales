package com.campus.vuelosglobales.trip.application.usecases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.campus.vuelosglobales.trip.domain.entities.Trip;
import com.campus.vuelosglobales.plane.application.usecases.UseCase;
import com.campus.vuelosglobales.trip.application.Services.TripService;
import com.campus.vuelosglobales.tripbooking.domain.entities.TripBooking;
import com.campus.vuelosglobales.tripbooking.application.Services.TripBookingService;
import com.campus.vuelosglobales.tripbookingdetail.domain.entities.TripBookingDetail;

@Component
public class ConsultStopoversUseCase implements UseCase {
    private final TripService tripService;
    private final TripBookingService tripBookingService;
    private final Logger logger = LoggerFactory.getLogger(ConsultStopoversUseCase.class);

    public ConsultStopoversUseCase(TripService tripService, TripBookingService tripBookingService) {
        this.tripService = tripService;
        this.tripBookingService = tripBookingService;
    }

    @SuppressWarnings("resource")
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        try {
            logger.info("Consultando escalas del trayecto...");

            System.out.print("Ingrese el ID del trayecto: ");
            try {
                Long id = Long.parseLong(scanner.nextLine());
                logger.info("Consultando escalas para el trayecto con ID: {}", id);

                Trip trip = tripService.findById(id);
                if (trip == null) {
                    logger.warn("Trayecto no encontrado con ID: {}", id);
                    System.out.println("Trayecto no encontrado.");
                    return;
                }

                List<TripBooking> tripBookings = tripBookingService.findByTrip(trip);
                if (tripBookings.isEmpty()) {
                    logger.info("No hay reservas (y por tanto, escalas) para el trayecto con ID: {}", id);
                    System.out.println("No hay escalas para este trayecto.");
                    return;
                }

                mostrarInformacionDeEscalas(tripBookings);

            } catch (NumberFormatException e) {
                logger.error("Error al convertir el ID: {}", e.getMessage());
                System.out.println("Error: Ingrese un ID válido.");
            }
        } catch (Exception e) {
            logger.error("Error inesperado: {}", e.getMessage());
            System.out.println("Error: Ocurrió un error inesperado.");
        }
    }

    private void mostrarInformacionDeEscalas(List<TripBooking> tripBookings) {
        for (TripBooking tripBooking : tripBookings) {
            System.out.println("+-----------------+----------------------+");
            System.out.println("| Escalas del trayecto ID: " + tripBooking.getTrip().getId() + " |");
            System.out.println("+-----------------+----------------------+");
            for (TripBookingDetail detail : tripBooking.getTripBookingDetails()) {
                System.out.printf("| ID Detalle        | %-20s |\n", detail.getId());
                System.out.printf("| Fecha Detalle     | %-20s |\n", formatDate(detail.getTripBookingDetailDate()));
                System.out.printf("| Cliente           | %-20s |\n", detail.getCustomer().getFirstName());
                System.out.printf("| Tarifa de Vuelo   | %-20s |\n", detail.getFlightfare().getFareName());
                System.out.println("+-----------------+----------------------+");
            }
        }
    }

    private String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
    }
}
