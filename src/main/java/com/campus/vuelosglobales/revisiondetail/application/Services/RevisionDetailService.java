package com.campus.vuelosglobales.revisiondetail.application.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.campus.vuelosglobales.revisiondetail.domain.entities.RevisionDetail;
import com.campus.vuelosglobales.revisiondetail.domain.repositories.RevisionDetailRepository;

@Service
public class RevisionDetailService {

    private final RevisionDetailRepository revisionDetailRepository;

    public RevisionDetailService(RevisionDetailRepository revisionDetailRepository) {
        this.revisionDetailRepository = revisionDetailRepository;
    }

    public List<RevisionDetail> findAll() {
        return revisionDetailRepository.findAll();
    }

    public RevisionDetail findById(Long id) {
        return revisionDetailRepository.findById(id).orElse(null);
    }

    public RevisionDetail save(RevisionDetail revisionDetail) {
        return revisionDetailRepository.save(revisionDetail);
    }

    public void deleteById(Long id) {
        revisionDetailRepository.deleteById(id);
    }

    public List<RevisionDetail> findByRevision_Id(Long revisionId) {
        return revisionDetailRepository.findByRevision_Id(revisionId);
    }

}
