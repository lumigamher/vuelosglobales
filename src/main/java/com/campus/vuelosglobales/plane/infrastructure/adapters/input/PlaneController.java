package com.campus.vuelosglobales.plane.infrastructure.adapters.input;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campus.vuelosglobales.plane.application.Services.PlaneService;
import com.campus.vuelosglobales.plane.domain.entities.Plane;

@RestController
@RequestMapping("/planes")
public class PlaneController {

    private final PlaneService planeService;

    public PlaneController(PlaneService planeService) {
        this.planeService = planeService;
    }

    @GetMapping
    public List<Plane> getAllPlanes() {
        return planeService.findAll();
    }

    @GetMapping("/{id}")
    public Plane getPlaneById(@PathVariable Long id) {
        return planeService.findById(id);
    }

    @PostMapping
    public Plane createPlane(@RequestBody Plane plane) {
        return planeService.save(plane);
    }

    @PutMapping("/{id}")
    public Plane updatePlane(@PathVariable Long id, @RequestBody Plane plane) {
        plane.setId(id);
        return planeService.save(plane);
    }

    @DeleteMapping("/{id}")
    public void deletePlane(@PathVariable Long id) throws Exception {
        planeService.deleteById(id);
    }
}
 