package com.rommelchocho.ms_cuentas_movimientos.service;

import java.util.List;
import java.util.Optional;

import com.rommelchocho.ms_cuentas_movimientos.entity.Cuenta;
import com.rommelchocho.ms_cuentas_movimientos.entity.Movimiento;
import com.rommelchocho.ms_cuentas_movimientos.repository.MovimientoRepository;

public class MovimientoServiceImpl implements MovimientoService {

    private final MovimientoRepository movimientoRepository;

    public MovimientoServiceImpl(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }

    @Override
    public Movimiento createMovimiento(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    @Override
    public void deleteMovimiento(Long id) {
        movimientoRepository.deleteById(id);

    }

    @Override
    public List<Movimiento> geAllMovimientos() {
        return (List<Movimiento>) movimientoRepository.findAll();
    }

    @Override
    public Optional<Movimiento> getMovimientoById(Long id) {
        return movimientoRepository.findById(id);
    }

    @Override
    public Optional<Movimiento> updateMovimiento(Long id, Movimiento movimientoNuevo) {
        Optional<Movimiento> movimiento = movimientoRepository.findById(id);
        Movimiento movimientoOptional = null;
        if (movimiento.isPresent()) {
            Movimiento movimientoDb = movimiento.orElseThrow();
            movimientoDb.setCuenta(movimientoNuevo.getCuenta());
            movimientoDb.setValor(movimientoNuevo.getValor());
            movimientoOptional = movimientoRepository.save(movimientoDb);
        }
        return Optional.ofNullable(movimientoOptional);
    }

}
