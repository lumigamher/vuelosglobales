package com.campus.vuelosglobales.tripcrew.application;

import org.springframework.stereotype.Component;

import com.campus.vuelosglobales.tripcrew.application.usecases.AsignarTripulacionUseCase;
import com.campus.vuelosglobales.tripcrew.application.usecases.ConsultarAsignacionesUseCase;

import java.util.Scanner;

@Component
public class TripCrewMenuHandler {

    private final AsignarTripulacionUseCase asignarTripulacionUseCase;
    private final ConsultarAsignacionesUseCase consultarAsignacionesUseCase;

    public TripCrewMenuHandler(AsignarTripulacionUseCase asignarTripulacionUseCase, ConsultarAsignacionesUseCase consultarAsignacionesUseCase) {
        this.asignarTripulacionUseCase = asignarTripulacionUseCase;
        this.consultarAsignacionesUseCase = consultarAsignacionesUseCase;
    }

    public void manejarOpcionSubmenuTripulacion(int opcionSubMenu) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        switch (opcionSubMenu) {
            case 1:
                System.out.print("Ingrese el ID del tripulante: ");
                Long tripulanteId = scanner.nextLong();
                System.out.print("Ingrese el ID del trayecto: ");
                Long trayectoId = scanner.nextLong();
                asignarTripulacionUseCase.execute(tripulanteId, trayectoId);
                break;
            case 2:
                System.out.print("Ingrese el ID del trayecto: ");
                Long trayectoIdConsulta = scanner.nextLong();
                consultarAsignacionesUseCase.execute(trayectoIdConsulta);
                break;
            case 0:
                System.out.println("Volviendo al menú principal...");
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        }
    }

}
