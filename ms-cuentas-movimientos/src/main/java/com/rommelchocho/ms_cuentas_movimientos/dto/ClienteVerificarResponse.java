package com.rommelchocho.ms_cuentas_movimientos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteVerificarResponse {

    private String clienteId; // ID del cliente verificado
    private boolean existe;   // Indica si el cliente existe o no
    private String solicitudId;
}
