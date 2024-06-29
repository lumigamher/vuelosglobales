package com.campus.vuelosglobales.tripbookingdetail.infrastructure.adapters.output;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.campus.vuelosglobales.tripbookingdetail.domain.entities.TripBookingDetail;
import com.campus.vuelosglobales.tripbookingdetail.domain.repositories.TripBookingDetailRepository;

@Component
public class TripBookingDetailRepositoryImpl implements TripBookingDetailRepository {

    private final TripBookingDetailPersistenceAdapter tripBookingDetailPersistenceAdapter;

    public TripBookingDetailRepositoryImpl(TripBookingDetailPersistenceAdapter tripBookingDetailPersistenceAdapter) {
        this.tripBookingDetailPersistenceAdapter = tripBookingDetailPersistenceAdapter;
    }

    @Override
    public List<TripBookingDetail> findAll() {
        return tripBookingDetailPersistenceAdapter.findAll();
    }

    @Override
    public Optional<TripBookingDetail> findById(Long id) {
        return tripBookingDetailPersistenceAdapter.findById(id);
    }

    @Override
    public TripBookingDetail save(TripBookingDetail tripBookingDetail) {
        return tripBookingDetailPersistenceAdapter.save(tripBookingDetail);
    }

    @Override
    public void deleteById(Long id) {
        tripBookingDetailPersistenceAdapter.deleteById(id);
    }

    @Override
    public void delete(TripBookingDetail tripBookingDetail) {
        tripBookingDetailPersistenceAdapter.delete(tripBookingDetail);
    }
}
