package com.campus.vuelosglobales.tripbookingdetail.domain.entities;

import java.util.Date;

import com.campus.vuelosglobales.customer.domain.entities.Customer;
import com.campus.vuelosglobales.flightfare.domain.entities.FlightFare;
import com.campus.vuelosglobales.tripbooking.domain.entities.TripBooking;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tripbookingdetails")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TripBookingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "trip_booking_detail_date")
    private Date tripBookingDetailDate;

    @ManyToOne
    @JoinColumn(name = "tripBooking_id", referencedColumnName = "id", nullable = false)
    private TripBooking tripBooking;

    @ManyToOne
    @JoinColumn(name = "customers_id", referencedColumnName = "id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "fares_id", referencedColumnName = "id", nullable = false)
    private FlightFare flightfare;
}

