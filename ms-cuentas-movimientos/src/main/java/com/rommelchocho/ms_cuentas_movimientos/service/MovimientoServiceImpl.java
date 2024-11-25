package com.rommelchocho.ms_cuentas_movimientos.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rommelchocho.ms_cuentas_movimientos.entity.Cuenta;
import com.rommelchocho.ms_cuentas_movimientos.entity.Movimiento;
import com.rommelchocho.ms_cuentas_movimientos.exception.SaldoInsuficienteException;
import com.rommelchocho.ms_cuentas_movimientos.repository.CuentaRepository;
import com.rommelchocho.ms_cuentas_movimientos.repository.MovimientoRepository;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    private final MovimientoRepository movimientoRepository;
    private final CuentaRepository cuentaRepository;

    public MovimientoServiceImpl(MovimientoRepository movimientoRepository, CuentaRepository cuentaRepository) {
        this.movimientoRepository = movimientoRepository;
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public Movimiento createMovimiento(String numeroCuenta, String tipoMovimiento, Double valor) {
        Cuenta cuenta = cuentaRepository.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        // Obtener el saldo disponible desde el último movimiento o el saldo inicial
        Optional<Movimiento> ultimoMovimiento = movimientoRepository.findTopByNumeroCuentaOrderByFechaDesc(cuenta);

        Double saldoDisponible = ultimoMovimiento
                .map(Movimiento::getSaldoDisponible) // Saldo del último movimiento
                .orElse(cuenta.getSaldoInicial()); // Saldo inicial de la cuenta si no hay movimientos previos
        System.out.println("Disponible: " + saldoDisponible);
        // Verificar saldo para retiros
        if ("Retiro".equalsIgnoreCase(tipoMovimiento) && saldoDisponible + valor < 0) {
            throw new SaldoInsuficienteException("Saldo no disponible");
        }
        System.out.println("Valor: " + valor);
        // Calcular el nuevo saldo disponible
        Double nuevoSaldoDisponible = saldoDisponible + valor;

        // Crear y guardar el movimiento
        Movimiento movimiento = new Movimiento();
        movimiento.setFecha(LocalDate.now());
        movimiento.setTipoMovimiento(tipoMovimiento);
        movimiento.setValor(valor);
        movimiento.setSaldoDisponible(nuevoSaldoDisponible);
        movimiento.setNumeroCuenta(cuenta);

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
            movimientoDb.setNumeroCuenta(movimientoNuevo.getNumeroCuenta());
            movimientoDb.setValor(movimientoNuevo.getValor());
            movimientoOptional = movimientoRepository.save(movimientoDb);
        }
        return Optional.ofNullable(movimientoOptional);
    }

}
