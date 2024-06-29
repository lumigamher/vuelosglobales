package com.campus.vuelosglobales.trip.application.usecases;

import com.campus.vuelosglobales.plane.application.usecases.InformationPlaneUseCase;
import com.campus.vuelosglobales.trip.domain.entities.Trip;
import com.campus.vuelosglobales.trip.domain.repositories.TripRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

@Service
public class DeleteTripUseCase {

    private final TripRepository tripRepository;
    private final InformationPlaneUseCase informationPlaneUseCase;

    

    public DeleteTripUseCase(TripRepository tripRepository, InformationPlaneUseCase informationPlaneUseCase) {
        this.tripRepository = tripRepository;
        this.informationPlaneUseCase = informationPlaneUseCase;
    }

    @Transactional
    public void execute() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        // 1. Solicitar el identificador del trayecto
        System.out.print("Ingrese el ID del trayecto a eliminar: ");
        Long tripId = scanner.nextLong();

        // 2. Obtener el trayecto de la base de datos
        Optional<Trip> optionalTrip = tripRepository.findById(tripId);
        if (!optionalTrip.isPresent()) {
            System.out.println("Trayecto no encontrado con ID: " + tripId);
            return;
        }
        Trip trip = optionalTrip.get();

        // 3. Mostrar la información del trayecto
        System.out.println("Información del trayecto a eliminar:");
        mostrarInformacionDelTrayecto(trip);

        // 4. Pedir confirmación para eliminar el trayecto
        System.out.print("¿Está seguro de que desea eliminar este trayecto? (s/n): ");
        String confirmacion = scanner.next();
        if (!confirmacion.equalsIgnoreCase("s")) {
            System.out.println("Eliminación de trayecto cancelada.");
            return;
        }

        // 5. Eliminar el trayecto
        tripRepository.deleteById(trip.getId());
        System.out.println("Trayecto eliminado exitosamente.");
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
}
