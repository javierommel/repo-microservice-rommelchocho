package com.rommelchocho.ms_cuentas_movimientos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReporteMovimientoDto {

    private String fecha;           // Fecha del movimiento
    private String cliente;         // Nombre del cliente
    private String numeroCuenta;    // Número de cuenta
    private String tipo;            // Tipo de cuenta (Corriente o Ahorros)
    private Double saldoInicial;    // Saldo inicial de la cuenta
    private Boolean estado;         // Estado de la cuenta
    private Double movimiento;      // Valor del movimiento (positivo o negativo)
    private Double saldoDisponible; // Saldo después del movimiento
}