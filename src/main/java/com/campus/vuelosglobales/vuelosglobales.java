package com.campus.vuelosglobales;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.campus.vuelosglobales.plane.application.PlaneMenuHandler;
import com.campus.vuelosglobales.trip.application.TripMenuHandler;
import com.campus.vuelosglobales.tripcrew.application.TripCrewMenuHandler;

@SpringBootApplication
public class vuelosglobales implements CommandLineRunner {

    private final PlaneMenuHandler planeMenuHandler;
    private final TripCrewMenuHandler tripCrewMenuHandler;
    private final TripMenuHandler tripMenuHandler;

    public vuelosglobales(PlaneMenuHandler planeMenuHandler, TripCrewMenuHandler tripCrewMenuHandler,
            TripMenuHandler tripMenuHandler) {
        this.planeMenuHandler = planeMenuHandler;
        this.tripCrewMenuHandler = tripCrewMenuHandler;
        this.tripMenuHandler = tripMenuHandler;
    }

    public static void main(String[] args) {
        SpringApplication.run(vuelosglobales.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcionPrincipal = -1, opcionSubMenu = -1;

        while (true) {
            try {
                mostrarMenuPrincipal();
                if (scanner.hasNextInt()) {
                    opcionPrincipal = scanner.nextInt();
                    scanner.nextLine(); // Consumir nueva línea
                } else {
                    System.out.println("Por favor, ingrese un número válido.");
                    scanner.next(); // Descartar entrada no válida
                    continue;
                }

                switch (opcionPrincipal) {
                    case 1:
                        mostrarSubMenuAviones();
                        if (scanner.hasNextInt()) {
                            opcionSubMenu = scanner.nextInt();
                            scanner.nextLine(); // Consumir nueva línea
                        } else {
                            System.out.println("Por favor, ingrese un número válido.");
                            scanner.next(); // Descartar entrada no válida
                            continue;
                        }
                        planeMenuHandler.manejarOpcionSubmenuAviones(opcionSubMenu);
                        break;
                    case 2:
                        mostrarSubMenuTripulacion();
                        if (scanner.hasNextInt()) {
                            opcionSubMenu = scanner.nextInt();
                            scanner.nextLine(); // Consumir nueva línea
                        } else {
                            System.out.println("Por favor, ingrese un número válido.");
                            scanner.next(); // Descartar entrada no válida
                            continue;
                        }
                        tripCrewMenuHandler.manejarOpcionSubmenuTripulacion(opcionSubMenu);
                        break;
                    case 3:
                        mostrarSubMenuRutasyEscalas();
                        if (scanner.hasNextInt()) {
                            opcionSubMenu = scanner.nextInt();
                            scanner.nextLine(); // Consumir nueva línea
                        } else {
                            System.out.println("Por favor, ingrese un número válido.");
                            scanner.next(); // Descartar entrada no válida
                            continue;
                        }
                        tripMenuHandler.manejarOpcionSubmenuRutasyEscalas(opcionSubMenu);
                        break;
                    case 4:
                        mostrarSubMenuAeropuertos();
                        if (scanner.hasNextInt()) {
                            opcionSubMenu = scanner.nextInt();
                            scanner.nextLine(); // Consumir nueva línea
                        } else {
                            System.out.println("Por favor, ingrese un número válido.");
                            scanner.next(); // Descartar entrada no válida
                            continue;
                        }
                        manejarOpcionSubmenuAeropuertos(opcionSubMenu);
                        break;
                    case 5:
                        mostrarSubMenuReservas();
                        if (scanner.hasNextInt()) {
                            opcionSubMenu = scanner.nextInt();
                            scanner.nextLine(); // Consumir nueva línea
                        } else {
                            System.out.println("Por favor, ingrese un número válido.");
                            scanner.next(); // Descartar entrada no válida
                            continue;
                        }
                        manejarOpcionSubmenuReservas(opcionSubMenu);
                        break;
                    case 6:
                        mostrarSubMenuClientes();
                        if (scanner.hasNextInt()) {
                            opcionSubMenu = scanner.nextInt();
                            scanner.nextLine(); // Consumir nueva línea
                        } else {
                            System.out.println("Por favor, ingrese un número válido.");
                            scanner.next(); // Descartar entrada no válida
                            continue;
                        }
                        manejarOpcionSubmenuClientes(opcionSubMenu);
                        break;
                    case 7:
                        mostrarSubMenuTarifas();
                        if (scanner.hasNextInt()) {
                            opcionSubMenu = scanner.nextInt();
                            scanner.nextLine(); // Consumir nueva línea
                        } else {
                            System.out.println("Por favor, ingrese un número válido.");
                            scanner.next(); // Descartar entrada no válida
                            continue;
                        }
                        manejarOpcionSubmenuTarifas(opcionSubMenu);
                        break;
                    case 8:
                        mostrarSubMenuDocumentos();
                        if (scanner.hasNextInt()) {
                            opcionSubMenu = scanner.nextInt();
                            scanner.nextLine(); // Consumir nueva línea
                        } else {
                            System.out.println("Por favor, ingrese un número válido.");
                            scanner.next(); // Descartar entrada no válida
                            continue;
                        }
                        manejarOpcionSubmenuDocumentos(opcionSubMenu);
                        break;
                    case 9:
                        mostrarSubMenuBuscaryReservarVuelos();
                        if (scanner.hasNextInt()) {
                            opcionSubMenu = scanner.nextInt();
                            scanner.nextLine(); // Consumir nueva línea
                        } else {
                            System.out.println("Por favor, ingrese un número válido.");
                            scanner.next(); // Descartar entrada no válida
                            continue;
                        }
                        manejarOpcionSubmenuBuscaryReservarVuelos(opcionSubMenu);
                        break;
                    case 10:
                        mostrarSubMenuConsultas();
                        if (scanner.hasNextInt()) {
                            opcionSubMenu = scanner.nextInt();
                            scanner.nextLine(); // Consumir nueva línea
                        } else {
                            System.out.println("Por favor, ingrese un número válido.");
                            scanner.next(); // Descartar entrada no válida
                            continue;
                        }
                        manejarOpcionSubMenuCosultas(opcionSubMenu);
                        break;
                    case 11:
                        mostrarSubMenuVuelos();
                        if (scanner.hasNextInt()) {
                            opcionSubMenu = scanner.nextInt();
                            scanner.nextLine(); // Consumir nueva línea
                        } else {
                            System.out.println("Por favor, ingrese un número válido.");
                            scanner.next(); // Descartar entrada no válida
                            continue;
                        }
                        manejarOpcionSubmenuVuelos(opcionSubMenu);
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                }
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error: " + e.getMessage());
            }
        }
    }
    private void manejarOpcionSubmenuVuelos(int opcionSubMenu) {
        switch (opcionSubMenu) {
            case 1:
                // Lógica para crear vuelo
                break;
            case 2:
                // Lógica para consultar vuelo
                break;
            case 3:
                // Lógica para actualizar vuelo
                break;
            case 4:
                // Lógica para eliminar vuelo
                break;
            case 0:
                // Volver al menú principal
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        } 
    }

    private static void mostrarSubMenuVuelos() {
        System.out.println("\n=====================================");
        System.out.println("           GESTIÓN DE VUELOS         ");
        System.out.println("=====================================");
        System.out.println("1. Crear Vuelo");
        System.out.println("-------------------------------------");
        System.out.println("2. Consultar Vuelo");
        System.out.println("-------------------------------------");
        System.out.println("3. Actualizar Vuelo");
        System.out.println("-------------------------------------");
        System.out.println("4. Eliminar Vuelo");
        System.out.println("-------------------------------------");
        System.out.println("0. Volver al Menú Principal");
        System.out.println("=====================================");
        System.out.print("Seleccione una opción: ");
    }
    
    private void manejarOpcionSubMenuCosultas(int opcionSubMenu) {
        switch (opcionSubMenu) {
            case 1:
                //Consultar Información de Vuelo
                break;
            case 0:
                //Volver al menu principal
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        }     
    }

    private static void mostrarSubMenuConsultas() {
        System.out.println("\n====================================");
        System.out.println("            CONSULTAS               ");
        System.out.println("====================================");
        System.out.println("1. Consultar Información de Vuelo");
        System.out.println("------------------------------------");
        System.out.println("0. Volver al Menú Principal");
        System.out.println("====================================");
        System.out.print("Seleccione una opción: ");
    }
    

    private void manejarOpcionSubmenuBuscaryReservarVuelos(int opcionSubMenu) {
        switch (opcionSubMenu) {
            case 1:
                //Buscar Vuelos
                break;
            case 2:
                //Seleccionar Vuelo 
                break;
            case 3:
                //Añadir Pasajeros
                break;
            case 4:
                //Seleccionar Asientos
                break;
            case 5:
                //Realizar Pago
                break;
            case 6:
                //Consultar Reserva de Vuelo
                break;
            case 7:
                //Cancelar Reserva de Vuelo
                break;
            case 8:
                //Modificar Reserva de Vuelo
                break;
            case 0:
                //Volver al menu principal
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        } 
    }

    private static void mostrarSubMenuBuscaryReservarVuelos() {
        System.out.println("\n====================================");
        System.out.println("    BUSCAR Y RESERVAR VUELOS        ");
        System.out.println("====================================");
        System.out.println("1. Buscar Vuelos");
        System.out.println("------------------------------------");
        System.out.println("2. Seleccionar Vuelo");
        System.out.println("------------------------------------");
        System.out.println("3. Añadir Pasajeros");
        System.out.println("------------------------------------");
        System.out.println("4. Seleccionar Asientos");
        System.out.println("------------------------------------");
        System.out.println("5. Realizar Pago");
        System.out.println("------------------------------------");
        System.out.println("6. Consultar Reserva de Vuelo");
        System.out.println("------------------------------------");
        System.out.println("7. Cancelar Reserva de Vuelo");
        System.out.println("------------------------------------");
        System.out.println("8. Modificar Reserva de Vuelo");
        System.out.println("------------------------------------");
        System.out.println("0. Volver al Menú Principal");
        System.out.println("====================================");
        System.out.print("Seleccione una opción: ");
    }
    

    private void manejarOpcionSubmenuDocumentos(int opcionSubMenu) {
        switch (opcionSubMenu) {
            case 1:
                //Registrar tipo de documento 
                break;
            case 2:
                //Actualizar tipo de documento 
                break;
            case 3:
                //Eliminar tipo de documento 
                break;
            case 4:
                //Consultar tipo de documento 
                break;
            case 0:
                //Volver al menu principal
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        } 
    }

    private static void mostrarSubMenuDocumentos() {
        System.out.println("\n====================================");
        System.out.println("         GESTIÓN DE DOCUMENTOS       ");
        System.out.println("====================================");
        System.out.println("1. Registrar Tipo de Documento");
        System.out.println("------------------------------------");
        System.out.println("2. Actualizar Tipo de Documento");
        System.out.println("------------------------------------");
        System.out.println("3. Eliminar Tipo de Documento");
        System.out.println("------------------------------------");
        System.out.println("4. Consultar Tipo de Documento");
        System.out.println("------------------------------------");
        System.out.println("0. Volver al Menú Principal");
        System.out.println("====================================");
        System.out.print("Seleccione una opción: ");
    }
    

    private void manejarOpcionSubmenuTarifas(int opcionSubMenu) {
        switch (opcionSubMenu) {
            case 1:
                //Registrar tarifa de vuelo
                break;
            case 2:
                //Actualizar Información de tarifa de vuelo
                break;
            case 3:
                //Eliminar tarifa de vuelo
                break;
            case 4:
                //Consultar tarifa de vuelo
                break;
            case 0:
                //Volver al menu principal
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        } 
    }

    private static void mostrarSubMenuTarifas() {
        System.out.println("\n====================================");
        System.out.println("         GESTIÓN DE TARIFAS        ");
        System.out.println("====================================");
        System.out.println("1. Registrar Tarifa de Vuelo");
        System.out.println("------------------------------------");
        System.out.println("2. Actualizar Información de Tarifa de Vuelo");
        System.out.println("------------------------------------");
        System.out.println("3. Eliminar Tarifa de Vuelo");
        System.out.println("------------------------------------");
        System.out.println("4. Consultar Tarifa de Vuelo");
        System.out.println("------------------------------------");
        System.out.println("0. Volver al Menú Principal");
        System.out.println("====================================");
        System.out.print("Seleccione una opción: ");
    }
    

    private void manejarOpcionSubmenuClientes(int opcionSubMenu) {
        switch (opcionSubMenu) {
            case 1:
                //Registrar cliente
                break;
            case 2:
                //Consultar informacion cliente
                break;
            case 3:
                //Actualizar informacion cliente
                break;
            case 0:
                //Volver al menu principal
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        } 
    }

    private static void mostrarSubMenuClientes() {
        System.out.println("\n====================================");
        System.out.println("         GESTIÓN DE CLIENTES        ");
        System.out.println("====================================");
        System.out.println("1. Registrar Cliente");
        System.out.println("------------------------------------");
        System.out.println("2. Consultar Información de Cliente");
        System.out.println("------------------------------------");
        System.out.println("3. Actualizar Información de Cliente");
        System.out.println("------------------------------------");
        System.out.println("0. Volver al Menú Principal");
        System.out.println("====================================");
        System.out.print("Seleccione una opción: ");
    }
    

    private void manejarOpcionSubmenuReservas(int opcionSubMenu) {
        switch (opcionSubMenu) {
            case 1:
                //Crear Reserva de Vuelo
                break;
            case 2:
                //Consultar Reserva de Vuelo
                break;
            case 3:
                //Eliminar Reserva de Vuelo
                break;
            case 0:
                //Volver al menu principal
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        } 
    }

    private static void mostrarSubMenuReservas() {
        System.out.println("\n====================================");
        System.out.println("         GESTIÓN DE RESERVAS        ");
        System.out.println("====================================");
        System.out.println("1. Crear Reserva de Vuelo");
        System.out.println("------------------------------------");
        System.out.println("2. Consultar Reserva de Vuelo");
        System.out.println("------------------------------------");
        System.out.println("3. Eliminar Reserva de Vuelo");
        System.out.println("------------------------------------");
        System.out.println("0. Volver al Menú Principal");
        System.out.println("====================================");
        System.out.print("Seleccione una opción: ");
    }

    private void manejarOpcionSubmenuAeropuertos(int opcionSubMenu) {
        
        switch (opcionSubMenu) {
            case 1:
                //Registrar Aeropuerto
                break;
            case 2:
                //Actualizar Información de Aeropuerto 
                break;
            case 3:
                //Eliminar Aeropuerto
                break;
            case 4:
                //Consultar Información de Aeropuerto
                break;
            case 0:
                //Volver al menu principal
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        } 
    }

    private static void mostrarSubMenuAeropuertos() {
        System.out.println("\n====================================");
        System.out.println("       GESTIÓN DE AEROPUERTOS       ");
        System.out.println("====================================");
        System.out.println("1. Registrar Aeropuerto");
        System.out.println("------------------------------------");
        System.out.println("2. Actualizar Información de Aeropuerto");
        System.out.println("------------------------------------");
        System.out.println("3. Eliminar Aeropuerto");
        System.out.println("------------------------------------");
        System.out.println("4. Consultar Información de Aeropuerto");
        System.out.println("------------------------------------");
        System.out.println("0. Volver al Menú Principal");
        System.out.println("====================================");
        System.out.print("Seleccione una opción: ");
    }
    
    private static void mostrarSubMenuRutasyEscalas() {
        System.out.println("\n=====================================");
        System.out.println("     GESTIÓN DE RUTAS Y ESCALAS      ");
        System.out.println("=====================================");
        System.out.println("1. Asignar Aeronave a Trayecto");
        System.out.println("-------------------------------------");
        System.out.println("2. Actualizar Información de Trayecto");
        System.out.println("-------------------------------------");
        System.out.println("3. Eliminar Trayecto");
        System.out.println("-------------------------------------");
        System.out.println("4. Consultar Información de Trayecto");
        System.out.println("-------------------------------------");
        System.out.println("5. Consultar Escalas de un Trayecto");
        System.out.println("-------------------------------------");
        System.out.println("6. Actualizar Información de Escala");
        System.out.println("-------------------------------------");
        System.out.println("7. Eliminar Escala");
        System.out.println("-------------------------------------");
        System.out.println("0. Volver al Menú Principal");
        System.out.println("=====================================");
        System.out.print("Seleccione una opción: ");
    }
    
    private void mostrarSubMenuTripulacion() {
        System.out.println("\n=============================================");
        System.out.println("            GESTIÓN DE TRIPULACIÓN           ");
        System.out.println("=============================================");
        System.out.println("1. Asignar Tripulación a Trayecto");
        System.out.println("---------------------------------------------");
        System.out.println("2. Consultar Asignación de Tripulación");
        System.out.println("---------------------------------------------");
        System.out.println("0. Volver al Menú Principal");
        System.out.println("=============================================");
        System.out.print("Seleccione una opción: ");
    }

    private void mostrarSubMenuAviones() {
        System.out.println("\n=============================================");
        System.out.println("              GESTIÓN DE AVIONES             ");
        System.out.println("=============================================");
        System.out.println("1. Registrar Ávion");
        System.out.println("---------------------------------------------");
        System.out.println("2. Actualizar Informacion del Ávion");
        System.out.println("---------------------------------------------");
        System.out.println("3. Eliminar Ávion");
        System.out.println("---------------------------------------------");
        System.out.println("4. Consultar Información de Avión");
        System.out.println("---------------------------------------------");
        System.out.println("5. Registrar Revisión de Mantenimiento");
        System.out.println("---------------------------------------------");
        System.out.println("6. Actualizar Información de Revisión");
        System.out.println("---------------------------------------------");
        System.out.println("7. Eliminar Revisión de Mantenimiento");
        System.out.println("---------------------------------------------");
        System.out.println("8. Consultar Historial de Revisiones de Avión");
        System.out.println("---------------------------------------------");
        System.out.println("0. Volver al Menú Principal");
        System.out.println("=============================================");
        System.out.print("Seleccione una opción: ");
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n======================================");
        System.out.println("             MENÚ PRINCIPAL           ");
        System.out.println("======================================");
        System.out.println("1. Gestión de Aviones");
        System.out.println("--------------------------------------");
        System.out.println("2. Gestión  de Tripulación");
        System.out.println("--------------------------------------");
        System.out.println("3. Gestión de Rutas y Escalas");
        System.out.println("--------------------------------------");
        System.out.println("4. Gestión de Aeropuertos");
        System.out.println("--------------------------------------");
        System.out.println("5. Gestión de Reservas");
        System.out.println("--------------------------------------");
        System.out.println("6. Gestión de Clientes");
        System.out.println("--------------------------------------");
        System.out.println("7. Gestión de Tarifas");
        System.out.println("--------------------------------------");
        System.out.println("8. Gestión de Documentos");
        System.out.println("--------------------------------------");
        System.out.println("9. Buscar y Reservar Vuelos (Clientes)");
        System.out.println("--------------------------------------");
        System.out.println("10. Consultas");
        System.out.println("--------------------------------------");
        System.out.println("11. Gestión de Vuelos");
        System.out.println("--------------------------------------");
        System.out.println("0. Salir");
        System.out.println("======================================");
        System.out.print("Seleccione una opción: ");
    }
    
    

}

