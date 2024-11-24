package com.rommelchocho.ms_clientes_personas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rommelchocho.ms_clientes_personas.dto.ClienteDto;
import com.rommelchocho.ms_clientes_personas.dto.mapper.ClienteMapperDto;
import com.rommelchocho.ms_clientes_personas.entity.Cliente;
import com.rommelchocho.ms_clientes_personas.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteDto createCliente(Cliente cliente) {
        return ClienteMapperDto.build(clienteRepository.save(cliente));
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);

    }

    @Override
    public List<ClienteDto> getAllClientes() {
        List<Cliente> cliente = (List<Cliente>) clienteRepository.findAll();
        return cliente.stream().map(c -> ClienteMapperDto.build(c)).collect(Collectors.toList());
    }

    @Override
    public Optional<ClienteDto> getClienteById(Long id) {
        Optional<Cliente> o = clienteRepository.findById(id);
        if (o.isPresent()) {
            return Optional.of(
                    ClienteMapperDto.build(o.orElseThrow()));
        }
        return Optional.empty();
    }

    @Override
    public Optional<ClienteDto> updateCliente(Long id, Cliente clienteNuevo) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        Cliente clienteOptional = null;
        if (cliente.isPresent()) {
            Cliente clienteDb = cliente.orElseThrow();
            clienteDb.setContrasena(clienteNuevo.getContrasena());
            clienteDb.setEstado(clienteNuevo.getEstado());
            clienteRepository.save(cliente.orElseThrow());
        }
        return Optional.ofNullable(ClienteMapperDto.build(clienteOptional));
    }

    @Override
    public Boolean existeCliente(String clienteId) {
        Optional<Cliente> cliente = clienteRepository.findByClienteId(clienteId);
        if (cliente.isPresent())
            return true;
        return false;
    }

}
