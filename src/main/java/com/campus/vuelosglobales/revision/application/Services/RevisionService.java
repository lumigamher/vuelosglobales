package com.campus.vuelosglobales.revision.application.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.vuelosglobales.revision.domain.entities.Revision;
import com.campus.vuelosglobales.revision.domain.repositories.RevisionRepository;

import java.util.List;

@Service
public class RevisionService {
    @Autowired
    private RevisionRepository revisionRepository;

    public Revision save(Revision revision) {
        return revisionRepository.save(revision);
    }

    public Revision findById(Long id) {
        return revisionRepository.findById(id).orElse(null);
    }

    public List<Revision> findByPlaneId(Long planeId) {
        return revisionRepository.findByPlane_Id(planeId);
    }

    public boolean existsById(Long id) {
        return revisionRepository.existsById(id);
    }

    public void deleteById(Long id) {
        revisionRepository.deleteById(id);
    }

    public List<Revision> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}
