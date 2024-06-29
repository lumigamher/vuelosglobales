package com.campus.vuelosglobales.tripbookingdetail.application.usecases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.campus.vuelosglobales.tripbookingdetail.domain.entities.TripBookingDetail;
import com.campus.vuelosglobales.plane.application.usecases.UseCase;
import com.campus.vuelosglobales.tripbookingdetail.application.Services.TripBookingDetailService;

@Component
public class UpdateStopoverUseCase implements UseCase {
    private final TripBookingDetailService tripBookingDetailService;

    public UpdateStopoverUseCase(TripBookingDetailService tripBookingDetailService) {
        this.tripBookingDetailService = tripBookingDetailService;
    }

    @Override
    public void execute() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Actualizando información de la escala...");

            System.out.print("Ingrese el ID de la escala a actualizar: ");
            try {
                Long id = Long.parseLong(scanner.nextLine());

                TripBookingDetail tripBookingDetail = tripBookingDetailService.findById(id);
                if (tripBookingDetail == null) {
                    System.out.println("Escala no encontrada.");
                    return;
                }

                System.out.println("Información actual de la escala:");
                mostrarInformacionDeEscala(tripBookingDetail);

                // Solicitar los nuevos detalles de la escala
                System.out.print("Ingrese la nueva fecha de la escala (dd/MM/yyyy): ");
                String newDateStr = scanner.nextLine();

                // Validar y actualizar los campos
                Date newDate = parseDate(newDateStr);
                tripBookingDetail.setTripBookingDetailDate(newDate);

                // Guardar los cambios
                tripBookingDetailService.save(tripBookingDetail);

                System.out.println("Escala actualizada exitosamente.");

            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un ID válido.");
            }
        } catch (Exception e) {
            System.out.println("Error: Ocurrió un error inesperado.");
        }
    }

    private void mostrarInformacionDeEscala(TripBookingDetail tripBookingDetail) {
        System.out.println("+-----------------+----------------------+");
        System.out.println("| Campo           | Valor                |");
        System.out.println("+-----------------+----------------------+");
        System.out.printf("| ID               | %-20s |\n", tripBookingDetail.getId());
        System.out.printf("| Fecha Detalle    | %-20s |\n", tripBookingDetail.getTripBookingDetailDate());
        System.out.printf("| Cliente          | %-20s |\n", tripBookingDetail.getCustomer().getFirstName());
        System.out.printf("| Tarifa de Vuelo  | %-20s |\n", tripBookingDetail.getFlightfare().getFareName());
        System.out.println("+-----------------+----------------------+");
    }

    private Date parseDate(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("Error al parsear la fecha: " + dateStr);
        }
    }
}
