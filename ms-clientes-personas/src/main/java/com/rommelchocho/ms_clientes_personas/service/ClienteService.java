package com.rommelchocho.ms_clientes_personas.service;

import java.util.List;
import java.util.Optional;

import com.rommelchocho.ms_clientes_personas.dto.ClienteDTO;
import com.rommelchocho.ms_clientes_personas.entity.Cliente;

public interface ClienteService {
    
    Cliente createCliente(Cliente cliente);

    List<ClienteDTO> getAllClientes();

    Optional<ClienteDTO> getClienteById(Long id);

    Optional<ClienteDTO> updateCliente(Long id, Cliente cliente);

    void deleteCliente(Long id);
}
