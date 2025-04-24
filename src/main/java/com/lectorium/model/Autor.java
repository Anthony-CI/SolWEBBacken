package com.lectorium.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authors")
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idAutor;
	
	@Column(nullable = false, length = 60)
	private String lastName;
	@Column(nullable = false, length = 60)
	private String firstName;
	@Column(nullable = true, length = 100)
	private LocalDate birthDate;
	@Column(nullable = false, length = 100)
	private String placeBirthDate;
	

}
