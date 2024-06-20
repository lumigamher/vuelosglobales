package com.campus.vuelosglobales.model.domain.entities;

import com.campus.vuelosglobales.manufacture.domain.entities.Manufacturer;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "airport_models")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "idManufacturer")
    private Manufacturer manufacturer;
}