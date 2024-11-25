package com.rommelchocho.ms_clientes_personas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rommelchocho.ms_clientes_personas.dto.ClienteDto;
import com.rommelchocho.ms_clientes_personas.entity.Cliente;

@SpringBootTest
public class ClienteServiceTest {
@Autowired
    private ClienteService clienteService;

    @Test
    public void testCrearCliente() {
        // Crear cliente
        Cliente cliente = new Cliente();
        cliente.setClienteId("CLI-002");
        cliente.setNombre("María López");
        cliente.setGenero("Femenino");
        cliente.setEdad(28);
        cliente.setDireccion("Avenida Siempre Viva");
        cliente.setTelefono("555-6789");
        cliente.setContrasena("password456");
        cliente.setEstado(true);
        cliente.setIdentificacion("0203232234");

        ClienteDto clienteGuardado = clienteService.createCliente(cliente);

        // Verificar creación
        assertNotNull(clienteGuardado.getId());
        assertEquals("CLI-002", clienteGuardado.getClienteId());
        assertEquals("María López", clienteGuardado.getNombre());
    }
}
