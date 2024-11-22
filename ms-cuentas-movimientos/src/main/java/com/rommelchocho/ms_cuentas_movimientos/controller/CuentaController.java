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

import com.rommelchocho.ms_cuentas_movimientos.entity.Cuenta;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {
    // Crear una nueva Cuenta
    @PostMapping
    public ResponseEntity<Cuenta> createCuenta(@RequestBody Cuenta cuenta) {
        //return ResponseEntity.ok(cuentaService.createCuenta(cuenta));
        return null;
    }

    // Obtener todas las Cuentas
    @GetMapping
    public ResponseEntity<List<Cuenta>> getAllCuentas() {
        //return ResponseEntity.ok(cuentaService.getAllCuentas());
        return null;
    }

    // Obtener una Cuenta por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> getCuentaById(@PathVariable Long id) {
        //return ResponseEntity.ok(cuentaService.getCuentaById(id));
        return null;
    }

    // Actualizar una Cuenta
    @PutMapping("/{id}")
    public ResponseEntity<Cuenta> updateCuenta(@PathVariable Long id, @RequestBody Cuenta cuenta) {
        //return ResponseEntity.ok(cuentaService.updateCuenta(id, cuenta));
        return null;
    }

    // Eliminar una Cuenta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCuenta(@PathVariable Long id) {
        /*cuentaService.deleteCuenta(id);
        return ResponseEntity.noContent().build();*/
        return null;
    }
}
