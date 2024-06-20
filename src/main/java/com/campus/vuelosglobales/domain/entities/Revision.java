package com.campus.vuelosglobales.domain.entities;

import java.util.Date;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "airport_revisions")
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
    private Date revisionDate;

    @ManyToOne
    @JoinColumn(name = "idPlane")
    private Plane plane;
}
