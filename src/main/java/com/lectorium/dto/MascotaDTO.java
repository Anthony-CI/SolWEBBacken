package com.lectorium.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MascotaDTO {
    private Integer idMascota;
    private String nombre;
    private String especie;
    private Integer edad;
    private String dueno;
}
