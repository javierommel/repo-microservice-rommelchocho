package com.rommelchocho.ms_clientes_personas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rommelchocho.ms_clientes_personas.dto.ClienteDTO;
import com.rommelchocho.ms_clientes_personas.dto.mapper.ClienteMapperDTO;
import com.rommelchocho.ms_clientes_personas.entity.Cliente;
import com.rommelchocho.ms_clientes_personas.exception.NotFoundException;
import com.rommelchocho.ms_clientes_personas.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);

    }

    @Override
    public List<ClienteDTO> getAllClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    public Optional<ClienteDTO> getClienteById(Long id) {
        Optional<Cliente> o = clienteRepository.findById(id);
        if (o.isPresent()) {
            return Optional.of(
                    ClienteMapperDTO.builder());
        } else {
            new NotFoundException("Cliente no encontrado con ID: " + id);
        }
    }

    @Override
    public Optional<ClienteD> updateCliente(Long id, Cliente clienteNuevo) {
        ClienteDTO cliente = getClienteById(id);
        cliente.setContrasena(clienteNuevo.getContrasena());
        cliente.setEstado(clienteNuevo.getEstado());
        return clienteRepository.save(cliente);
    }

}
