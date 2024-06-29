package com.campus.vuelosglobales.revision.domain.repositories;

import java.util.List;
import java.util.Optional;
import com.campus.vuelosglobales.revision.domain.entities.Revision;

public interface RevisionRepository {
    List<Revision> findAll();
    Optional<Revision> findById(Long id);
    Revision save(Revision revision);
    void deleteById(Long id);
    List<Revision> findByPlane_Id(Long planeId);
    boolean existsById(Long id);
}