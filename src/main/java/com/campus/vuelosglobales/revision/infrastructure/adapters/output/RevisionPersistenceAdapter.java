package com.campus.vuelosglobales.revision.infrastructure.adapters.output;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.campus.vuelosglobales.revision.domain.entities.Revision;

@Repository
public interface RevisionPersistenceAdapter extends JpaRepository<Revision, Long> {
    List<Revision> findByPlane_Id(Long planeId);
}