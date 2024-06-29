package com.campus.vuelosglobales.plane.application;

import org.springframework.stereotype.Component;
// import org.springframework.beans.factory.annotation.Autowired;

import com.campus.vuelosglobales.plane.application.usecases.RegisterPlaneUseCase;
import com.campus.vuelosglobales.plane.application.usecases.UpdatePlaneUseCase;
import com.campus.vuelosglobales.revision.application.usecases.ConsultRevisionHistoryUseCase;
import com.campus.vuelosglobales.revision.application.usecases.DeleteRevisionUseCase;
import com.campus.vuelosglobales.revision.application.usecases.RegisterRevisionUseCase;
import com.campus.vuelosglobales.revision.application.usecases.UpdateRevisionUseCase;
import com.campus.vuelosglobales.plane.application.usecases.DeletePlaneUseCase;
import com.campus.vuelosglobales.plane.application.usecases.InformationPlaneUseCase;

@Component
public class PlaneMenuHandler {
    
    private final RegisterPlaneUseCase registerPlaneUseCase;
    private final UpdatePlaneUseCase updatePlaneUseCase;
    private final DeletePlaneUseCase deletePlaneUseCase;
    private final InformationPlaneUseCase informationPlaneUseCase;
    private final DeleteRevisionUseCase deleteRevisionUseCase;
    private final RegisterRevisionUseCase registerRevisionUseCase;
    private final UpdateRevisionUseCase updateRevisionUseCase;
    private final ConsultRevisionHistoryUseCase consultRevisionHistoryUseCase;
    
    // @Autowired
    public PlaneMenuHandler(RegisterPlaneUseCase registerPlaneUseCase, UpdatePlaneUseCase updatePlaneUseCase,
            DeletePlaneUseCase deletePlaneUseCase, InformationPlaneUseCase informationPlaneUseCase,
            DeleteRevisionUseCase deleteRevisionUseCase, RegisterRevisionUseCase registerRevisionUseCase,
            UpdateRevisionUseCase updateRevisionUseCase, ConsultRevisionHistoryUseCase consultRevisionHistoryUseCase) {
        this.registerPlaneUseCase = registerPlaneUseCase;
        this.updatePlaneUseCase = updatePlaneUseCase;
        this.deletePlaneUseCase = deletePlaneUseCase;
        this.informationPlaneUseCase = informationPlaneUseCase;
        this.deleteRevisionUseCase = deleteRevisionUseCase;
        this.registerRevisionUseCase = registerRevisionUseCase;
        this.updateRevisionUseCase = updateRevisionUseCase;
        this.consultRevisionHistoryUseCase = consultRevisionHistoryUseCase;
    }

    public void manejarOpcionSubmenuAviones(int opcionSubMenu) throws Exception {
        switch (opcionSubMenu) {
            case 1:
                registerPlaneUseCase.execute();
                break;
            case 2:
                updatePlaneUseCase.execute();
                break;
            case 3:
                deletePlaneUseCase.execute();
                break;
            case 4:
                //consultar informacion del avion
                informationPlaneUseCase.execute();
                break;
            case 5:
                //registrar revision de mantenimiento
                registerRevisionUseCase.execute();
                break;
            case 6:
                //actualizar informacion de revision
                updateRevisionUseCase.execute();
                break;
            case 7:
                //eliminar revision de mantenimiento 
                deleteRevisionUseCase.execute();
                break;
            case 8:
                //Consultar historial de revisiones del avion 
                consultRevisionHistoryUseCase.execute();
                break;
                //Volver al menu principal
            case 0:
                System.out.println("Volviendo al menú principal...");
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        }
    }
}
