package com.rommelchocho.ms_clientes_personas.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.rommelchocho.ms_clientes_personas.entity.Cliente;

@DataJpaTest
public class ClienteRepositoryTest {
@Autowired
    private ClienteRepository clienteRepository;
    @Test
    public void testCrearYBuscarCliente() {
        // Crear cliente
        Cliente cliente = new Cliente();
        cliente.setClienteId("CLI-001");
        cliente.setNombre("Juan Pérez");
        cliente.setGenero("Masculino");
        cliente.setEdad(30);
        cliente.setDireccion("Calle 123");
        cliente.setTelefono("555-1234");
        cliente.setIdentificacion("0104223430");
        cliente.setContrasena("password123");
        cliente.setEstado(true);

        Cliente clienteGuardado = clienteRepository.save(cliente);

        // Verificar que se creó correctamente
        assertNotNull(clienteGuardado.getId());
        assertEquals("CLI-001", clienteGuardado.getClienteId());

        // Buscar cliente por ID
        Optional<Cliente> clienteBuscado = clienteRepository.findById(clienteGuardado.getId());
        assertTrue(clienteBuscado.isPresent());
        assertEquals("Juan Pérez", clienteBuscado.get().getNombre());

        // Buscar cliente por clienteId
        Optional<Cliente> clientePorClienteId = clienteRepository.findByClienteId("CLI-001");
        assertNotNull(clientePorClienteId.isPresent());
        assertEquals("Juan Pérez", clientePorClienteId.orElseThrow().getNombre());
    }
}
