package com.rommelchocho.ms_cuentas_movimientos.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rommelchocho.ms_cuentas_movimientos.dto.ReporteMovimientoDto;
import com.rommelchocho.ms_cuentas_movimientos.entity.Cuenta;
import com.rommelchocho.ms_cuentas_movimientos.entity.Movimiento;
import com.rommelchocho.ms_cuentas_movimientos.repository.ClienteReplicaRepository;
import com.rommelchocho.ms_cuentas_movimientos.repository.CuentaRepository;
import com.rommelchocho.ms_cuentas_movimientos.repository.MovimientoRepository;

@Service
public class ReporteServiceImpl implements ReporteService {

    private final CuentaRepository cuentaRepository;
    private final MovimientoRepository movimientoRepository;
    private final ClienteReplicaRepository clienteReplicaRepository;

    public ReporteServiceImpl(CuentaRepository cuentaRepository, MovimientoRepository movimientoRepository, ClienteReplicaRepository clienteReplicaRepository) {
        this.cuentaRepository = cuentaRepository;
        this.movimientoRepository = movimientoRepository;
        this.clienteReplicaRepository = clienteReplicaRepository;
    }

    public List<ReporteMovimientoDto> generarReporte(String clienteId, LocalDate fechaInicio, LocalDate fechaFin) {
        // Obtener las cuentas asociadas al cliente
        List<Cuenta> cuentas = cuentaRepository.findByClienteId(clienteId);

        // Generar el reporte con los movimientos por cuenta
        return cuentas.stream()
                .flatMap(cuenta -> {
                    // Obtener movimientos de la cuenta en el rango de fechas
                    List<Movimiento> movimientos = movimientoRepository.findByNumeroCuentaAndFechaBetween(
                            cuenta, fechaInicio, fechaFin);

                    // Mapear los movimientos al formato del reporte
                    return movimientos.stream().map(mov -> new ReporteMovimientoDto(
                            mov.getFecha().toString(),
                            clienteReplicaRepository.findByClienteId(clienteId).orElseThrow().getNombre(), // Asociar el nombre del cliente
                            cuenta.getNumeroCuenta(),
                            cuenta.getTipo(),
                            cuenta.getSaldoInicial(),
                            cuenta.getEstado(),
                            mov.getValor(),
                            mov.getSaldoDisponible() // Saldo después del movimiento
                    ));
                })
                .collect(Collectors.toList());
    }

}
