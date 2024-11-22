package com.rommelchocho.ms_clientes_personas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rommelchocho.ms_clientes_personas.entity.Cliente;
import com.rommelchocho.ms_clientes_personas.service.ClienteService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Crear un nuevo Cliente
    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.createCliente(cliente);
        return ResponseEntity.ok(nuevoCliente);

    }

    // Obtener todos los Clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        return ResponseEntity.ok(clienteService.getAllClientes());

    }

    // Obtener un Cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.getClienteById(id));
    }

    // Actualizar un Cliente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente actualizado = clienteService.updateCliente(id, cliente);
        return ResponseEntity.ok(actualizado);
    }

    // Eliminar un Cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }
}
