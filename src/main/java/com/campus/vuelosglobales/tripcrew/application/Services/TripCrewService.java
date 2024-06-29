package com.campus.vuelosglobales.tripcrew.application.Services;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.vuelosglobales.employee.domain.entities.Employee;
import com.campus.vuelosglobales.employee.domain.repositories.EmployeeRepository;
import com.campus.vuelosglobales.flightconnection.domain.entities.FlightConnection;
import com.campus.vuelosglobales.flightconnection.domain.repositories.FlightConnectionRepository;
import com.campus.vuelosglobales.tripcrew.domain.entities.TripCrew;
import com.campus.vuelosglobales.tripcrew.domain.entities.TripCrewPK;
import com.campus.vuelosglobales.tripcrew.domain.repositories.TripCrewRepository;

@Service
public class TripCrewService {

    private final TripCrewRepository tripCrewRepository;
    private final EmployeeRepository employeeRepository;
    private final FlightConnectionRepository flightConnectionRepository;

    //@Autowired
    public TripCrewService(TripCrewRepository tripCrewRepository,
                           EmployeeRepository employeeRepository,
                           FlightConnectionRepository flightConnectionRepository) {
        this.tripCrewRepository = tripCrewRepository;
        this.employeeRepository = employeeRepository;
        this.flightConnectionRepository = flightConnectionRepository;
    }

    public void asignarTripulanteATrayecto(Long tripulanteId, Long trayectoId) {
        Employee employee = employeeRepository.findById(tripulanteId).orElseThrow();
        FlightConnection flightConnection = flightConnectionRepository.findById(trayectoId).orElseThrow();

        TripCrewPK tripCrewPK = new TripCrewPK(tripulanteId, trayectoId);
        TripCrew tripCrew = TripCrew.builder()
                                    .id(tripCrewPK)
                                    .employee(employee)
                                    .flightConnection(flightConnection)
                                    .build();

        tripCrewRepository.save(tripCrew);
    }

    public List<TripCrew> consultarAsignacionesDeTripulacion(Long trayectoId) {
        FlightConnection flightConnection = flightConnectionRepository.findById(trayectoId).orElseThrow();
        return tripCrewRepository.findByFlightConnection(flightConnection);
    }

    public List<TripCrew> findAll() {
        return tripCrewRepository.findAll();
    }

    public TripCrew findById(TripCrewPK id) {
        return tripCrewRepository.findById(id).orElse(null);
    }

    public TripCrew save(TripCrew tripCrew) {
        return tripCrewRepository.save(tripCrew);
    }

    public void deleteById(TripCrewPK id) {
        tripCrewRepository.deleteById(id);
    }
}
