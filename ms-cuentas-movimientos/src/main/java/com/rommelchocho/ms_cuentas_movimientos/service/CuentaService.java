package com.rommelchocho.ms_cuentas_movimientos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rommelchocho.ms_cuentas_movimientos.entity.Cuenta;

@Service
public interface CuentaService {
    Cuenta createCuenta(Cuenta cuenta);

    List<Cuenta> geAllCuentas();

    Cuenta getCuentaById(Long id);

    Cuenta updateCuenta(Long id);

    Cuenta updateCuenta(Long id, Cuenta cuenta);

    void deleteCuenta(Long id);
}
