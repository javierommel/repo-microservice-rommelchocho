package com.rommelchocho.ms_cuentas_movimientos.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.rommelchocho.ms_cuentas_movimientos.dto.ClienteVerificarRequest;
import com.rommelchocho.ms_cuentas_movimientos.entity.Cuenta;
import com.rommelchocho.ms_cuentas_movimientos.messaging.ClienteProducer;
import com.rommelchocho.ms_cuentas_movimientos.repository.CuentaRepository;

public class CuentaServiceImpl implements CuentaService {

    private final CuentaRepository cuentaRepository;
    private final ClienteProducer clienteProducer;
    private final ConcurrentHashMap<String, Cuenta> solicitudesPendientes = new ConcurrentHashMap<>();

    public CuentaServiceImpl(CuentaRepository cuentaRepository, ClienteProducer clienteProducer) {
        this.cuentaRepository = cuentaRepository;
        this.clienteProducer = clienteProducer;
    }

    @Override
    public Cuenta createCuenta(Cuenta cuenta) {
        String solicitudId = UUID.randomUUID().toString();
        solicitudesPendientes.put(solicitudId, cuenta);
        solicitudesPendientes.put(solicitudId, cuenta);
        ClienteVerificarRequest request = new ClienteVerificarRequest(cuenta.getClienteId(), solicitudId);
        clienteProducer.enviarSolicitudCliente(request);
        return cuentaRepository.save(cuenta);
    }

    @Override
    public void deleteCuenta(Long id) {
        cuentaRepository.deleteById(id);

    }

    @Override
    public List<Cuenta> geAllCuentas() {
        return (List<Cuenta>) cuentaRepository.findAll();
    }

    @Override
    public Optional<Cuenta> getCuentaById(Long id) {
        return cuentaRepository.findById(id);
    }

    @Override
    public Optional<Cuenta> updateCuenta(Long id, Cuenta cuentaNueva) {
        Optional<Cuenta> cuenta = cuentaRepository.findById(id);
        Cuenta cuentaOptional = null;
        if (cuenta.isPresent()) {
            Cuenta cuentaDb = cuenta.orElseThrow();
            cuentaDb.setNumeroCuenta(cuentaNueva.getNumeroCuenta());
            cuentaDb.setEstado(cuentaNueva.getEstado());
            cuentaRepository.save(cuenta.orElseThrow());
        }
        return Optional.ofNullable(cuentaOptional);
    }

}
