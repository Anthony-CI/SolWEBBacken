package com.lectorium.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Integer idBook;
    @NotBlank(message = "Title es obligatorio")
    private String title;
    @NotBlank(message = "subtitle es obligatorio")
    private String subtitle;
    @NotBlank(message = "description es obligatorio")
    private String description;
    private Integer idPublisher;
    private Integer idCategory;

}
