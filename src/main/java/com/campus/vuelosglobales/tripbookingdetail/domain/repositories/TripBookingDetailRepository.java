package com.campus.vuelosglobales.tripbookingdetail.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.campus.vuelosglobales.tripbookingdetail.domain.entities.TripBookingDetail;

public interface TripBookingDetailRepository {
    List<TripBookingDetail> findAll();
    Optional<TripBookingDetail> findById(Long id);
    TripBookingDetail save(TripBookingDetail tripBookingDetail);
    void deleteById(Long id);
    void delete(TripBookingDetail tripBookingDetail);
}
