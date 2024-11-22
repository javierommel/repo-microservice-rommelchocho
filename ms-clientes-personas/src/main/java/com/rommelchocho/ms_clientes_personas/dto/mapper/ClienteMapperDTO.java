package com.rommelchocho.ms_clientes_personas.dto.mapper;

import com.rommelchocho.ms_clientes_personas.dto.ClienteDTO;
import com.rommelchocho.ms_clientes_personas.entity.Cliente;

public class ClienteMapperDTO {

    private static ClienteMapperDTO mapper;
    
    private Cliente cliente;

    private ClienteMapperDTO() {

    }

    public static ClienteMapperDTO getInstance() {
        mapper = new ClienteMapperDTO();
        return mapper;
    }

    public ClienteMapperDTO setCliente(Cliente cliente) {
        this.cliente = cliente;
        return mapper;
    }

    public ClienteDTO build() {
        if (cliente == null) {
            throw new RuntimeException("Debe pasar el entity");
        }
        return new ClienteDTO(cliente);
    }

}
