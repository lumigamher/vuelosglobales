package com.campus.vuelosglobales.tripbookingdetail.application.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.campus.vuelosglobales.tripbookingdetail.domain.entities.TripBookingDetail;
import com.campus.vuelosglobales.tripbookingdetail.domain.repositories.TripBookingDetailRepository;

@Service
public class TripBookingDetailService {

    private final TripBookingDetailRepository tripBookingDetailRepository;

    public TripBookingDetailService(TripBookingDetailRepository tripBookingDetailRepository) {
        this.tripBookingDetailRepository = tripBookingDetailRepository;
    }

    public List<TripBookingDetail> findAll() {
        return tripBookingDetailRepository.findAll();
    }

    public TripBookingDetail findById(Long id) {
        return tripBookingDetailRepository.findById(id).orElse(null);
    }

    public TripBookingDetail save(TripBookingDetail tripBookingDetail) {
        return tripBookingDetailRepository.save(tripBookingDetail);
    }

    public void deleteById(Long id) {
        tripBookingDetailRepository.deleteById(id);
    }

    public void delete(TripBookingDetail tripBookingDetail) {
        tripBookingDetailRepository.delete(tripBookingDetail);
    }
}
