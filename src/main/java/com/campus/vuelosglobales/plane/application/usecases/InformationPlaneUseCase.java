package com.campus.vuelosglobales.plane.application.usecases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.campus.vuelosglobales.plane.application.Services.PlaneService;
import com.campus.vuelosglobales.plane.domain.entities.Plane;

@Component
public class InformationPlaneUseCase implements UseCase {
    private final PlaneService planeService;
    private final Logger logger = LoggerFactory.getLogger(InformationPlaneUseCase.class);

    public InformationPlaneUseCase(PlaneService planeService) {
        this.planeService = planeService;
    }

    @SuppressWarnings("resource")
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        try {
            logger.info("Consultando información del avión...");

            System.out.print("Ingrese el ID del avión a consultar: ");
            try {
                Long id = Long.parseLong(scanner.nextLine());
                logger.info("Consultando información del avión con ID: {}", id);

                Plane plane = planeService.findById(id);
                if (plane == null) {
                    logger.warn("Avión no encontrado con ID: {}", id);
                    System.out.println("Avión no encontrado.");
                    return;
                }

                mostrarInformacionDelAvion(plane);

            } catch (NumberFormatException e) {
                logger.error("Error al convertir el ID: {}", e.getMessage());
                System.out.println("Error: Ingrese un ID válido.");
            }
        } catch (Exception e) {
            logger.error("Error inesperado: {}", e.getMessage());
            System.out.println("Error: Ocurrió un error inesperado.");
        }
    }

    public void mostrarInformacionDelAvion(Plane plane) {
        System.out.println("+-----------------+----------------------+");
        System.out.println("| Campo           | Valor                |");
        System.out.println("+-----------------+----------------------+");
        System.out.printf("| ID               | %-20s |\n", plane.getId());
        System.out.printf("| Matrícula        | %-20s |\n", plane.getPlates());
        System.out.printf("| Capacidad        | %-20d |\n", plane.getCapacity());
        System.out.printf("| Fecha Fabricación| %-20s |\n", formatDate(plane.getFabricationdate()));
        System.out.printf("| Estado           | %-20s |\n", plane.getStatus().getName());
        System.out.printf("| Modelo           | %-20s |\n", plane.getModel().getName());
        System.out.println("+-----------------+----------------------+");
    }

    private String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
    }
}
