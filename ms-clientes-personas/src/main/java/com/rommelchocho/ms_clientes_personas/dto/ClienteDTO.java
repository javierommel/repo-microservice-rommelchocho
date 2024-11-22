package com.rommelchocho.ms_clientes_personas.dto;

import com.rommelchocho.ms_clientes_personas.entity.Cliente;

import lombok.Data;

@Data
public class ClienteDTO {
    
    public ClienteDTO(Cliente cliente){
        this.clienteId=cliente.getId();
        this.nombre=cliente.getNombre();
        this.identificacion=cliente.getIdentificacion();
    }

    private Long clienteId;
    private String contrasena;
    private Boolean estado;
    private String nombre;
    private String genero;
    private Integer edad;
    private String identificacion;
    private String direccion;
    private String telefono;
}
