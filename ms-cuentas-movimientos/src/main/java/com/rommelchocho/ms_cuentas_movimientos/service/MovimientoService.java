package com.rommelchocho.ms_cuentas_movimientos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rommelchocho.ms_cuentas_movimientos.entity.Movimiento;

@Service
public interface MovimientoService {

    Movimiento createMovimiento(Movimiento cuenta);

    List<Movimiento> geAllMovimientos();

    Optional<Movimiento> getMovimientoById(Long id);

    Optional<Movimiento> updateMovimiento(Long id, Movimiento cuenta);

    void deleteMovimiento(Long id);
}
