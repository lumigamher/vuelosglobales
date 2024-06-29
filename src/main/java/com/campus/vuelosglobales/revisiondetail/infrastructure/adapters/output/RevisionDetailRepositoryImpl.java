package com.campus.vuelosglobales.revisiondetail.infrastructure.adapters.output;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.campus.vuelosglobales.revisiondetail.domain.entities.RevisionDetail;
import com.campus.vuelosglobales.revisiondetail.domain.repositories.RevisionDetailRepository;

@Component
public class RevisionDetailRepositoryImpl implements RevisionDetailRepository {

    private final RevisionDetailPersistenceAdapter revisionDetailPersistenceAdapter;

    public RevisionDetailRepositoryImpl(RevisionDetailPersistenceAdapter revisionDetailPersistenceAdapter) {
        this.revisionDetailPersistenceAdapter = revisionDetailPersistenceAdapter;
    }

    @Override
    public List<RevisionDetail> findAll() {
        return revisionDetailPersistenceAdapter.findAll();
    }

    @Override
    public Optional<RevisionDetail> findById(Long id) {
        return revisionDetailPersistenceAdapter.findById(id);
    }

    @Override
    public RevisionDetail save(RevisionDetail revisionDetail) {
        return revisionDetailPersistenceAdapter.save(revisionDetail);
    }

    @Override
    public void deleteById(Long id) {
        revisionDetailPersistenceAdapter.deleteById(id);
    }

    @Override
    public List<RevisionDetail> findByRevision_Id(Long id) {
        return revisionDetailPersistenceAdapter.findByRevision_Id(id);
    }
}
