package com.rommelchocho.ms_clientes_personas.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class Cliente extends Persona{
    
    @Column(unique = true, nullable = false) // Clave única para clienteId
    private String clienteId;
    private String contrasena;
    private Boolean estado;

    @PrePersist
    public void prePersist() {
        if (this.clienteId == null) {
            this.clienteId = "CLI-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        }
    }
}
