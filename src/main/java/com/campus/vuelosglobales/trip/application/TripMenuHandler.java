package com.campus.vuelosglobales.trip.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campus.vuelosglobales.trip.application.usecases.AssignPlaneToTripUseCase;
import com.campus.vuelosglobales.trip.application.usecases.ConsultStopoversUseCase;
import com.campus.vuelosglobales.trip.application.usecases.DeleteTripUseCase;
import com.campus.vuelosglobales.trip.application.usecases.InformationTripUseCase;
import com.campus.vuelosglobales.trip.application.usecases.UpdateTripUseCase;
import com.campus.vuelosglobales.tripbookingdetail.application.usecases.DeleteStopoverUseCase;
import com.campus.vuelosglobales.tripbookingdetail.application.usecases.UpdateStopoverUseCase;

@Component 
public class TripMenuHandler {

    @Autowired
    private final AssignPlaneToTripUseCase assignPlaneToTripUseCase;
    private final UpdateTripUseCase updateTripUseCase;
    private final DeleteTripUseCase deleteTripUseCase;
    private final InformationTripUseCase informationTripUseCase;
    private final ConsultStopoversUseCase consultStopoversUseCase;
    private final UpdateStopoverUseCase updateStopoverUseCase;
    private final DeleteStopoverUseCase deleteStopoverUseCase;

    public TripMenuHandler(AssignPlaneToTripUseCase assignPlaneToTripUseCase, UpdateTripUseCase updateTripUseCase,
            DeleteTripUseCase deleteTripUseCase, InformationTripUseCase informationTripUseCase,
            ConsultStopoversUseCase consultStopoversUseCase, UpdateStopoverUseCase updateStopoverUseCase,
            DeleteStopoverUseCase deleteStopoverUseCase) {
        this.assignPlaneToTripUseCase = assignPlaneToTripUseCase;
        this.updateTripUseCase = updateTripUseCase;
        this.deleteTripUseCase = deleteTripUseCase;
        this.informationTripUseCase = informationTripUseCase;
        this.consultStopoversUseCase = consultStopoversUseCase;
        this.updateStopoverUseCase = updateStopoverUseCase;
        this.deleteStopoverUseCase = deleteStopoverUseCase;
    }

    public void manejarOpcionSubmenuRutasyEscalas(int opcionSubMenu) {
            switch (opcionSubMenu) {
            case 1:
                //Asignar Aeronave a Trayecto
                assignPlaneToTripUseCase.execute();
                break;
            case 2:
                //Actualizar Información de Trayecto
                updateTripUseCase.execute();
                break;
            case 3:
                //Eliminar Trayecto;
                deleteTripUseCase.execute();
                break;
            case 4:
                //Consultar Información de Trayecto
                informationTripUseCase.execute();
                break;
            case 5:
                //Consultar Escalas de un Trayecto
                consultStopoversUseCase.execute();
                break;
            case 6:
                //actualizar informacion de revision
                updateStopoverUseCase.execute();
                break;
            case 7:
                //Eliminar Escala
                deleteStopoverUseCase.execute();
                break;
            case 0:
                //Volver al menu principal
                break;
        
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        } 
    }
}
