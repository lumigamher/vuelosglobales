package com.campus.vuelosglobales.plane.application.usecases;

import com.campus.vuelosglobales.plane.application.Services.PlaneService;
import com.campus.vuelosglobales.plane.domain.entities.Plane;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class DeletePlaneUseCase implements UseCase {
    private final Scanner scanner;
    private final PlaneService planeService;

    public DeletePlaneUseCase(PlaneService planeService) {
        this.scanner = new Scanner(System.in);
        this.planeService = planeService;
    }

    @Override
    public void execute() throws Exception {
        System.out.println("Eliminando avión...");
        
        System.out.print("Ingrese el ID del avión a eliminar: ");
        Long id = Long.parseLong(scanner.nextLine());
        
        Plane plane = planeService.findById(id);
        if (plane == null) {
            System.out.println("Avión no encontrado.");
            return;
        }

        // Mostrar información del avión antes de eliminar
        System.out.println("Información del avión a eliminar:");
        System.out.println("ID: " + plane.getId());
        System.out.println("Placas: " + plane.getPlates());
        System.out.println("Capacidad: " + plane.getCapacity());
        System.out.println("Modelo: " + plane.getModel().getName());
        System.out.println("Estado: " + plane.getStatus().getName());

        System.out.print("¿Está seguro que desea eliminar este avión? (s/n): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("s")) {
            planeService.deleteById(id);
            System.out.println("Avión eliminado con éxito.");
        } else {
            System.out.println("Operación de eliminación cancelada.");
        }
    }
}