package com.campus.vuelosglobales.plane.application.Services;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

//import com.campus.vuelosglobales.flightconnection.domain.repositories.FlightConnectionRepository;
import com.campus.vuelosglobales.flightconnection.infrastructure.adapters.output.FlightConnectionPersistenceAdapter;
import com.campus.vuelosglobales.plane.domain.entities.Plane;
import com.campus.vuelosglobales.plane.domain.repositories.PlaneRepository;

import jakarta.transaction.Transactional;

@Service
public class PlaneService {
    private final FlightConnectionPersistenceAdapter flightConnectionPersistenceAdapter;
    private final PlaneRepository planeRepository;

    

    public PlaneService(FlightConnectionPersistenceAdapter flightConnectionPersistenceAdapter,
            PlaneRepository planeRepository) {
        this.flightConnectionPersistenceAdapter = flightConnectionPersistenceAdapter;
        this.planeRepository = planeRepository;
    }

    public List<Plane> findAll() {
        return planeRepository.findAll();
    }

    public Plane findById(Long id) {
        return planeRepository.findById(id).orElse(null);
    }

    public Plane save(Plane plane) {
        return planeRepository.save(plane);
    }
    @Transactional
    public void deleteById(Long id) throws Exception {       
        flightConnectionPersistenceAdapter.setPlaneToNull(id);
        try {
            planeRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new Exception("No se puede eliminar el avión porque tiene vuelos asociados.");
        }
    }
}
