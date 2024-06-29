package com.campus.vuelosglobales.revision.application.usecases;

import java.text.SimpleDateFormat;
import java.util.Scanner;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campus.vuelosglobales.revision.application.Services.RevisionService;
import com.campus.vuelosglobales.revision.domain.entities.Revision;
import com.campus.vuelosglobales.plane.application.Services.PlaneService;
import com.campus.vuelosglobales.plane.application.usecases.UseCase;
import com.campus.vuelosglobales.plane.domain.entities.Plane;
import com.campus.vuelosglobales.revisiondetail.application.Services.RevisionDetailService;
import com.campus.vuelosglobales.revisiondetail.domain.entities.RevisionDetail;
import com.campus.vuelosglobales.employee.application.Services.EmployeeService;
import com.campus.vuelosglobales.employee.domain.entities.Employee;

@Component
public class RegisterRevisionUseCase implements UseCase {
    private final RevisionService revisionService;
    private final PlaneService planeService;
    private final RevisionDetailService revisionDetailService;
    private final EmployeeService employeeService;

    //@Autowired
    public RegisterRevisionUseCase(RevisionService revisionService, PlaneService planeService, RevisionDetailService revisionDetailService, EmployeeService employeeService) {
        this.revisionService = revisionService;
        this.planeService = planeService;
        this.revisionDetailService = revisionDetailService;
        this.employeeService = employeeService;
    }

    @Override
    public void execute() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingrese el ID del avión: ");
            Long planeId = Long.parseLong(scanner.nextLine());

            Plane plane = planeService.findById(planeId);
            if (plane == null) {
                System.out.println("Avión no encontrado.");
                return;
            }

            Revision revision = new Revision();
            revision.setPlane(plane);

            System.out.print("Ingrese la fecha de la revisión (dd/MM/yyyy): ");
            String dateStr = scanner.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            revision.setRevisionDate(sdf.parse(dateStr));

            revisionService.save(revision);

            System.out.print("Ingrese la descripción de la revisión: ");
            String description = scanner.nextLine();

            System.out.print("Ingrese el ID del empleado que realizó la revisión: ");
            Long employeeId = Long.parseLong(scanner.nextLine());

            Employee employee = employeeService.findById(employeeId);
            if (employee == null) {
                System.out.println("Empleado no encontrado.");
                return;
            }

            RevisionDetail revisionDetail = new RevisionDetail();
            revisionDetail.setRevision(revision);
            revisionDetail.setDescription(description);
            revisionDetail.setEmployee(employee);

            revisionDetailService.save(revisionDetail);
            System.out.println("Revisión de mantenimiento registrada con éxito.");
        } catch (Exception e) {
            System.out.println("Error al registrar la revisión: " + e.getMessage());
        }
    }
}
