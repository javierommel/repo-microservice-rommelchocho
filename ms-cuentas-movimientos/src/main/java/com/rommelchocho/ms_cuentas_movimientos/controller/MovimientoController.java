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

import com.rommelchocho.ms_cuentas_movimientos.dto.MovimientoRequestDto;
import com.rommelchocho.ms_cuentas_movimientos.entity.Movimiento;
import com.rommelchocho.ms_cuentas_movimientos.service.MovimientoService;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    private final MovimientoService movimientoService;

    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }
     // Crear un nuevo Movimiento
    @PostMapping
    public ResponseEntity<Movimiento> createMovimiento(@RequestBody MovimientoRequestDto movimientoDto) {
        Movimiento movimiento = movimientoService.createMovimiento(movimientoDto.getNumeroCuenta(), movimientoDto.getTipoMovimiento(), movimientoDto.getValor());
        return ResponseEntity.ok(movimiento);
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
