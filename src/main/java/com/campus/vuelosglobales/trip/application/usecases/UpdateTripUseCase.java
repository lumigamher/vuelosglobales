package com.campus.vuelosglobales.trip.application.usecases;

import com.campus.vuelosglobales.plane.application.usecases.InformationPlaneUseCase;
import com.campus.vuelosglobales.trip.domain.entities.Trip;
import com.campus.vuelosglobales.trip.domain.repositories.TripRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class UpdateTripUseCase {

    private final TripRepository tripRepository;
    private final InformationPlaneUseCase informationPlaneUseCase;

    public UpdateTripUseCase(TripRepository tripRepository, InformationPlaneUseCase informationPlaneUseCase) {
        this.tripRepository = tripRepository;
        this.informationPlaneUseCase = informationPlaneUseCase;
    }

    @Transactional
    public void execute() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        // 1. Solicitar el identificador del trayecto
        System.out.print("Ingrese el ID del trayecto a actualizar: ");
        Long tripId = scanner.nextLong();

        // 2. Obtener el trayecto de la base de datos
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new RuntimeException("Trayecto no encontrado con ID: " + tripId));

        // 3. Mostrar la información actual del trayecto
        System.out.println("Información actual del trayecto:");
        mostrarInformacionDelTrayecto(trip);

        // 4. Solicitar los nuevos detalles del trayecto
        System.out.print("Ingrese el nuevo precio del trayecto: ");
        Double newPriceTrip = scanner.nextDouble();

        System.out.print("Ingrese la nueva fecha del trayecto (yyyy-MM-dd): ");
        String newTripDateString = scanner.next();

        // 5. Validar la información ingresada
        if (newPriceTrip <= 0 || newTripDateString.isEmpty()) {
            throw new RuntimeException("Los campos precio y fecha son obligatorios.");
        }

        Date newTripDate;
        try {
            newTripDate = new SimpleDateFormat("yyyy-MM-dd").parse(newTripDateString);
        } catch (ParseException e) {
            throw new RuntimeException("Formato de fecha incorrecto. Use el formato yyyy-MM-dd.");
        }

        // 6. Actualizar la información del trayecto
        trip.setPrice_trip(newPriceTrip);
        trip.setTrip_date(newTripDate);

        // 7. Guardar los cambios en la base de datos
        tripRepository.save(trip);

        // 8. Confirmar la actualización
        System.out.println("Trayecto actualizado exitosamente.");
    }

    private void mostrarInformacionDelTrayecto(Trip trip) {
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
