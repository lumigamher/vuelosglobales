package com.campus.vuelosglobales.employee.domain.entities;

import java.util.Date;

import com.campus.vuelosglobales.airline.domain.entities.Airline;
import com.campus.vuelosglobales.airport.domain.entities.Airport;
import com.campus.vuelosglobales.tripulantrole.domain.entities.TripulantRole;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "tripulantrole_id", referencedColumnName = "id")
    private TripulantRole tripulantRole;

    @Column(name = "ingresDate")
    @Temporal(TemporalType.DATE)
    private Date ingresdate;

    @ManyToOne
    @JoinColumn(name = "airline_id", referencedColumnName = "id")
    private Airline airline;

    @ManyToOne
    @JoinColumn(name = "airport_id", referencedColumnName = "id")
    private Airport airport;
}

