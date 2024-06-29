package com.campus.vuelosglobales.revisiondetail.infrastructure.adapters.output;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campus.vuelosglobales.revisiondetail.domain.entities.RevisionDetail;

@Repository
public interface RevisionDetailPersistenceAdapter extends JpaRepository<RevisionDetail, Long> {
    List<RevisionDetail> findByRevision_Id(Long id);
    void deleteByRevision_Id(Long id);
}
