package com.rommelchocho.ms_cuentas_movimientos.repository;

import org.springframework.data.repository.CrudRepository;

import com.rommelchocho.ms_cuentas_movimientos.entity.Movimiento;

public interface MovimientoRepository extends CrudRepository<Movimiento, Long> {

}
