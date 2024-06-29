package com.campus.vuelosglobales.revision.application.usecases;

import java.text.SimpleDateFormat;
import java.util.Scanner;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campus.vuelosglobales.revision.application.Services.RevisionService;
import com.campus.vuelosglobales.revision.domain.entities.Revision;
import com.campus.vuelosglobales.revisiondetail.application.Services.RevisionDetailService;
import com.campus.vuelosglobales.revisiondetail.domain.entities.RevisionDetail;
import com.campus.vuelosglobales.employee.application.Services.EmployeeService;
import com.campus.vuelosglobales.employee.domain.entities.Employee;
import com.campus.vuelosglobales.plane.application.usecases.UseCase;

@Component
public class UpdateRevisionUseCase implements UseCase {
    private final RevisionService revisionService;
    private final RevisionDetailService revisionDetailService;
    private final EmployeeService employeeService;

    //@Autowired
    public UpdateRevisionUseCase(RevisionService revisionService, RevisionDetailService revisionDetailService, EmployeeService employeeService) {
        this.revisionService = revisionService;
        this.revisionDetailService = revisionDetailService;
        this.employeeService = employeeService;
    }

    @Override
    public void execute() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingrese el ID de la revisión a actualizar: ");
            Long revisionId = Long.parseLong(scanner.nextLine());

            Revision revision = revisionService.findById(revisionId);
            if (revision == null) {
                System.out.println("Revisión no encontrada.");
                return;
            }

            System.out.print("Ingrese la nueva fecha de la revisión (dd/MM/yyyy): ");
            String dateStr = scanner.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            revision.setRevisionDate(sdf.parse(dateStr));

            revisionService.save(revision);

            System.out.print("Ingrese la nueva descripción de la revisión: ");
            String description = scanner.nextLine();

            System.out.print("Ingrese el ID del nuevo empleado que realizó la revisión: ");
            Long employeeId = Long.parseLong(scanner.nextLine());

            Employee employee = employeeService.findById(employeeId);
            if (employee == null) {
                System.out.println("Empleado no encontrado.");
                return;
            }

            RevisionDetail revisionDetail = revisionDetailService.findByRevision_Id(revisionId).get(0); // Assuming one detail per revision for simplicity
            revisionDetail.setDescription(description);
            revisionDetail.setEmployee(employee);

            revisionDetailService.save(revisionDetail);
            System.out.println("Revisión de mantenimiento actualizada con éxito.");
        } catch (Exception e) {
            System.out.println("Error al actualizar la revisión: " + e.getMessage());
        }
    }
}
