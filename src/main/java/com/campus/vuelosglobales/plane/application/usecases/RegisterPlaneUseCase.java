package com.campus.vuelosglobales.plane.application.usecases;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.campus.vuelosglobales.model.application.Services.ModelService;
import com.campus.vuelosglobales.model.domain.entities.Model;
import com.campus.vuelosglobales.plane.application.Services.PlaneService;
import com.campus.vuelosglobales.plane.domain.entities.Plane;
import com.campus.vuelosglobales.status.application.Services.StatusService;
import com.campus.vuelosglobales.status.domain.entities.Status;

@Component
public class RegisterPlaneUseCase implements UseCase {
    private final Scanner scanner;
    private final StatusService statusService;
    private final ModelService modelService;
    private final PlaneService planeService;

    public RegisterPlaneUseCase(StatusService statusService, ModelService modelService, PlaneService planeService) {
        this.scanner = new Scanner(System.in);
        this.statusService = statusService;
        this.modelService = modelService;
        this.planeService = planeService;
    }

    
    @Override
    public void execute() {
        System.out.println("Registrando nuevo avión...");
        
        System.out.print("Ingrese las placas: ");
        String plates = scanner.nextLine();
        
        System.out.print("Ingrese la capacidad: ");
        Integer capacity = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Ingrese la fecha de fabricación (YYYY-MM-DD): ");
        Date fabricationDate = java.sql.Date.valueOf(scanner.nextLine());
        
        Status status = selectStatus();
        Model model = selectModel();

        Plane newPlane = Plane.builder()
                .plates(plates)
                .capacity(capacity)
                .fabricationdate(fabricationDate)
                .status(status)
                .model(model)
                .build();

        planeService.save(newPlane);
        System.out.println("Avión registrado con éxito.");
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