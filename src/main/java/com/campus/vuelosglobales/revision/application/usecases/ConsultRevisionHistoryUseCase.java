package com.campus.vuelosglobales.revision.application.usecases;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campus.vuelosglobales.plane.application.usecases.UseCase;
import com.campus.vuelosglobales.revision.application.Services.RevisionService;
import com.campus.vuelosglobales.revision.domain.entities.Revision;
import com.campus.vuelosglobales.revisiondetail.application.Services.RevisionDetailService;
import com.campus.vuelosglobales.revisiondetail.domain.entities.RevisionDetail;

@Component
public class ConsultRevisionHistoryUseCase implements UseCase {
    private final RevisionService revisionService;
    private final RevisionDetailService revisionDetailService;

    public ConsultRevisionHistoryUseCase(RevisionService revisionService, RevisionDetailService revisionDetailService) {
        this.revisionService = revisionService;
        this.revisionDetailService = revisionDetailService;
    }

    @Override
    public void execute() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingrese el ID del avión: ");
            Long planeId = Long.parseLong(scanner.nextLine());
            List<Revision> revisions = revisionService.findByPlaneId(planeId);
            if (revisions.isEmpty()) {
                System.out.println("No se encontraron revisiones para el avión con ID: " + planeId);
                return;
            }

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (Revision revision : revisions) {
                System.out.println("+----------------------------------------+");
                System.out.println("| Revisión ID: " + revision.getId());
                System.out.println("| Fecha de Revisión: " + sdf.format(revision.getRevisionDate()));
                System.out.println("| Detalles de la Revisión:");
                
                List<RevisionDetail> details = revisionDetailService.findByRevision_Id(revision.getId());
                for (RevisionDetail detail : details) {
                    System.out.println("| - Descripción: " + detail.getDescription());
                    System.out.println("| - Empleado: " + detail.getEmployee().getName());
                }
                System.out.println("+----------------------------------------+");
            }
        } catch (Exception e) {
            System.out.println("Error al consultar el historial de revisiones: " + e.getMessage());
        }
    }
}

           
