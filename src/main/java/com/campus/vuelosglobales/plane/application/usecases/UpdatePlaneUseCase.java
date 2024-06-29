package com.campus.vuelosglobales.plane.application.usecases;

import com.campus.vuelosglobales.plane.domain.entities.Plane;
import com.campus.vuelosglobales.plane.application.Services.PlaneService;
import com.campus.vuelosglobales.status.application.Services.StatusService;
import com.campus.vuelosglobales.model.application.Services.ModelService;
import com.campus.vuelosglobales.status.domain.entities.Status;
import com.campus.vuelosglobales.model.domain.entities.Model;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class UpdatePlaneUseCase implements UseCase {
    private final Scanner scanner;
    private final PlaneService planeService;
    private final StatusService statusService;
    private final ModelService modelService;

    public UpdatePlaneUseCase(PlaneService planeService, StatusService statusService, ModelService modelService) {
        this.scanner = new Scanner(System.in);
        this.planeService = planeService;
        this.statusService = statusService;
        this.modelService = modelService;
    }

    @Override
    public void execute() {
        System.out.println("Actualizando información del avión...");
        
        System.out.print("Ingrese el ID del avión a actualizar: ");
        Long id = Long.parseLong(scanner.nextLine());
        
        Plane plane = planeService.findById(id);
        if (plane == null) {
            System.out.println("Avión no encontrado.");
            return;
        }

        System.out.print("Ingrese las nuevas placas (deje en blanco para no cambiar): ");
        String plates = scanner.nextLine();
        if (!plates.isEmpty()) {
            plane.setPlates(plates);
        }

        System.out.print("Ingrese la nueva capacidad (deje en blanco para no cambiar): ");
        String capacityStr = scanner.nextLine();
        if (!capacityStr.isEmpty()) {
            plane.setCapacity(Integer.parseInt(capacityStr));
        }

        System.out.println("¿Desea actualizar el estado? (s/n): ");
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            Status newStatus = selectStatus();
            plane.setStatus(newStatus);
        }

        System.out.println("¿Desea actualizar el modelo? (s/n): ");
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            Model newModel = selectModel();
            plane.setModel(newModel);
        }

        planeService.save(plane);
        System.out.println("Información del avión actualizada con éxito.");
    }

    private Status selectStatus() {
        List<Status> statuses = statusService.findAll();
        System.out.println("Seleccione un estado:");
        for (int i = 0; i < statuses.size(); i++) {
            System.out.println((i+1) + ". " + statuses.get(i).getName());
        }
        int selection = Integer.parseInt(scanner.nextLine()) - 1;
        return statuses.get(selection);
    }

    private Model selectModel() {
        List<Model> models = modelService.findAll();
        System.out.println("Seleccione un modelo:");
        for (int i = 0; i < models.size(); i++) {
            System.out.println((i+1) + ". " + models.get(i).getName());
        }
        int selection = Integer.parseInt(scanner.nextLine()) - 1;
        return models.get(selection);
    }
}