package com.campus.vuelosglobales.revision.application.usecases;

import java.util.Scanner;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campus.vuelosglobales.plane.application.usecases.UseCase;
import com.campus.vuelosglobales.revision.application.Services.RevisionService;
import com.campus.vuelosglobales.revisiondetail.application.Services.RevisionDetailService;

@Component
public class DeleteRevisionUseCase implements UseCase {
    private final RevisionService revisionService;
    private final RevisionDetailService revisionDetailService;

    public DeleteRevisionUseCase(RevisionService revisionService, RevisionDetailService revisionDetailService) {
        this.revisionService = revisionService;
        this.revisionDetailService = revisionDetailService;
    }

    @Override
    public void execute() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingrese el ID de la revisión a eliminar: ");
            Long revisionId = Long.parseLong(scanner.nextLine());

            if (!revisionService.existsById(revisionId)) {
                System.out.println("Revisión no encontrada.");
                return;
            }

            revisionDetailService.deleteById(revisionId); // Ensure details are deleted first
            revisionService.deleteById(revisionId);
            System.out.println("Revisión de mantenimiento eliminada con éxito.");
        } catch (Exception e) {
            System.out.println("Error al eliminar la revisión: " + e.getMessage());
        }
    }
}
