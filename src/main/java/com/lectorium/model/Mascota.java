package com.lectorium.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="mascota")

public class Mascota {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMascota;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 100)
    private String especie;

    @Column(length = 100)
    private Integer edad;

    @Column(length = 250)
    private String dueno;
}
