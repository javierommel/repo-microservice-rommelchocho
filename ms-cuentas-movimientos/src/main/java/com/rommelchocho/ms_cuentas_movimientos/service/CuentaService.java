package com.rommelchocho.ms_cuentas_movimientos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rommelchocho.ms_cuentas_movimientos.entity.Cuenta;

@Service
public interface CuentaService {
    
    Cuenta createCuenta(Cuenta cuenta);

    List<Cuenta> getAllCuentas();

    Optional<Cuenta> getCuentaById(Long id);

    Optional<Cuenta> updateCuenta(Long id, Cuenta cuenta);

    void deleteCuenta(Long id);
}
