package com.campus.vuelosglobales.tripbookingdetail.application.usecases;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.campus.vuelosglobales.tripbookingdetail.domain.entities.TripBookingDetail;
import com.campus.vuelosglobales.plane.application.usecases.UseCase;
import com.campus.vuelosglobales.tripbookingdetail.application.Services.TripBookingDetailService;

@Component
public class DeleteStopoverUseCase implements UseCase {
    private final TripBookingDetailService tripBookingDetailService;
    private final Logger logger = LoggerFactory.getLogger(DeleteStopoverUseCase.class);

    public DeleteStopoverUseCase(TripBookingDetailService tripBookingDetailService) {
        this.tripBookingDetailService = tripBookingDetailService;
    }

    @SuppressWarnings("resource")
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        try {
            logger.info("Eliminando escala...");

            System.out.print("Ingrese el ID de la escala a eliminar: ");
            try {
                Long id = Long.parseLong(scanner.nextLine());
                logger.info("Eliminando escala con ID: {}", id);

                TripBookingDetail tripBookingDetail = tripBookingDetailService.findById(id);
                if (tripBookingDetail == null) {
                    logger.warn("Escala no encontrada con ID: {}", id);
                    System.out.println("Escala no encontrada.");
                    return;
                }

                System.out.println("Información de la escala a eliminar:");
                mostrarInformacionDeEscala(tripBookingDetail);

                System.out.print("¿Está seguro de que desea eliminar esta escala? (S/N): ");
                String confirmacion = scanner.nextLine();

                if (confirmacion.equalsIgnoreCase("S")) {
                    tripBookingDetailService.delete(tripBookingDetail);
                    System.out.println("Escala eliminada exitosamente.");
                } else {
                    System.out.println("Eliminación cancelada.");
                }

            } catch (NumberFormatException e) {
                logger.error("Error al convertir el ID: {}", e.getMessage());
                System.out.println("Error: Ingrese un ID válido.");
            }
        } catch (Exception e) {
            logger.error("Error inesperado: {}", e.getMessage());
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
}
