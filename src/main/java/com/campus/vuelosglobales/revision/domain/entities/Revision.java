package com.campus.vuelosglobales.revision.domain.entities;

import java.util.Date;

import com.campus.vuelosglobales.plane.domain.entities.Plane;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "revisions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Revision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "revisionDate")
    @Temporal(TemporalType.DATE)
    private Date revisionDate;

    @ManyToOne
    @JoinColumn(name = "plane_id", referencedColumnName = "id")
    private Plane plane;
}
