package com.campus.vuelosglobales.flightfare.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "flightfares")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightFare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "details")
    private String details;

    @Column(name = "value", nullable = false)
    private double value;

    public Object getFareName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFareName'");
    }
}
