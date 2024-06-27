package com.campus.vuelosglobales.trip.domain.entities;

import java.util.Date;

import com.campus.vuelosglobales.employee.domain.entities.Employee;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "trips")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "trip_date")
    @Temporal(TemporalType.DATE)
    private Date trip_date;

    @Column(name = "price_trip")
    private Double price_trip;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
}
