package com.campus.vuelosglobales.revisiondetail.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.campus.vuelosglobales.revisiondetail.domain.entities.RevisionDetail;

public interface RevisionDetailRepository {
    List<RevisionDetail> findAll();
    Optional<RevisionDetail> findById(Long id);
    RevisionDetail save(RevisionDetail revisionDetail);
    void deleteById(Long id);
    List<RevisionDetail> findByRevision_Id(Long revisionId);
}
