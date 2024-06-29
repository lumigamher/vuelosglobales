package com.campus.vuelosglobales.trip.application.usecases;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.vuelosglobales.plane.domain.entities.Plane;
import com.campus.vuelosglobales.plane.domain.repositories.PlaneRepository;
import com.campus.vuelosglobales.trip.domain.entities.Trip;
import com.campus.vuelosglobales.trip.domain.repositories.TripRepository;

import jakarta.transaction.Transactional;


@Service
public class AssignPlaneToTripUseCase {
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private PlaneRepository planeRepository;

    @Transactional
    public void execute() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        // 1. Mostrar lista de trayectos disponibles
        List<Trip> trips = tripRepository.findAll();
        System.out.println("Trayectos disponibles:");
        for (int i = 0; i < trips.size(); i++) {
            System.out.println((i + 1) + ". " + trips.get(i).getId() + " - " + trips.get(i).getTrip_date() + " a " + trips.get(i).getPrice_trip());
        }

        // 2. Seleccionar un trayecto
        System.out.print("Seleccione el número del trayecto: ");
        int tripIndex = scanner.nextInt() - 1;
        if (tripIndex < 0 || tripIndex >= trips.size()) {
            throw new RuntimeException("Trayecto no válido.");
        }
        Trip trip = trips.get(tripIndex);

        // 3. Mostrar lista de aeronaves disponibles
        List<Plane> planes = planeRepository.findAll();
        if (planes.isEmpty()) {
            throw new RuntimeException("No hay aeronaves disponibles.");
        }
        System.out.println("Aeronaves disponibles:");
        for (int i = 0; i < planes.size(); i++) {
            System.out.println((i + 1) + ". " + planes.get(i).getId() + " - " + planes.get(i).getModel());
        }

        // 4. Seleccionar una aeronave
        System.out.print("Seleccione el número de la aeronave: ");
        int planeIndex = scanner.nextInt() - 1;
        if (planeIndex < 0 || planeIndex >= planes.size()) {
            throw new RuntimeException("Aeronave no válida.");
        }
        Plane plane = planes.get(planeIndex);

        // 5. Asignar la aeronave al trayecto y guardar
        trip.setPlane(plane);
        tripRepository.save(trip);

        // 6. Confirmar la asignación
        System.out.println("Aeronave asignada al trayecto exitosamente.");
    }
}
