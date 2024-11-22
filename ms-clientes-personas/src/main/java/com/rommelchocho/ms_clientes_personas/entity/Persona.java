package com.rommelchocho.ms_clientes_personas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String genero;
    private Integer edad;
    @Column(unique = true, nullable = false)
    private String identificacion;
    private String direccion;
    private String telefono;
}
