package com.campus.vuelosglobales.revision.infrastructure.adapters.output;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import com.campus.vuelosglobales.revision.domain.entities.Revision;
import com.campus.vuelosglobales.revision.domain.repositories.RevisionRepository;

@Component
public class RevisionRepositoryImpl implements RevisionRepository {
    private final RevisionPersistenceAdapter revisionPersistenceAdapter;

    public RevisionRepositoryImpl(RevisionPersistenceAdapter revisionPersistenceAdapter) {
        this.revisionPersistenceAdapter = revisionPersistenceAdapter;
    }

    @Override
    public List<Revision> findAll() {
        return revisionPersistenceAdapter.findAll();
    }

    @Override
    public Optional<Revision> findById(Long id) {
        return revisionPersistenceAdapter.findById(id);
    }

    @Override
    public Revision save(Revision revision) {
        return revisionPersistenceAdapter.save(revision);
    }

    @Override
    public void deleteById(Long id) {
        revisionPersistenceAdapter.deleteById(id);
    }

    @Override
    public List<Revision> findByPlane_Id(Long id) {
        return revisionPersistenceAdapter.findByPlane_Id(id);
    }

    @Override
    public boolean existsById(Long id) {
        return revisionPersistenceAdapter.existsById(id);
    }
} 