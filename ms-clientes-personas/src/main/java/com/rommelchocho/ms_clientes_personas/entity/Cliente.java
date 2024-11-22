package com.rommelchocho.ms_clientes_personas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class Cliente extends Persona{
    @Column(unique=true, nullable = false)
    private String clienteId;
    private String contrasena;
    private Boolean estado;
}
