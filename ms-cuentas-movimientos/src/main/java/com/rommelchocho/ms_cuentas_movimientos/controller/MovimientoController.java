package com.rommelchocho.ms_cuentas_movimientos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rommelchocho.ms_cuentas_movimientos.entity.Movimiento;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

     // Crear un nuevo Movimiento
    @PostMapping
    public ResponseEntity<Movimiento> createMovimiento(@RequestBody Movimiento movimiento) {
        //return ResponseEntity.ok(movimientoService.createMovimiento(movimiento));
        return null;
    }

    // Obtener todos los Movimientos
    @GetMapping
    public ResponseEntity<List<Movimiento>> getAllMovimientos() {
        //return ResponseEntity.ok(movimientoService.getAllMovimientos());
        return null;
    }

    // Obtener un Movimiento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Movimiento> getMovimientoById(@PathVariable Long id) {
        //return ResponseEntity.ok(movimientoService.getMovimientoById(id));
        return null;
    }

    // Actualizar un Movimiento
    @PutMapping("/{id}")
    public ResponseEntity<Movimiento> updateMovimiento(@PathVariable Long id, @RequestBody Movimiento movimiento) {
        //return ResponseEntity.ok(movimientoService.updateMovimiento(id, movimiento));
        return null;
    }

    // Eliminar un Movimiento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovimiento(@PathVariable Long id) {
        /*movimientoService.deleteMovimiento(id);
        return ResponseEntity.noContent().build();*/
        return null;
    }

}
