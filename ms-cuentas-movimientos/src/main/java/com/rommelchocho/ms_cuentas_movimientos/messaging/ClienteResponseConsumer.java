package com.rommelchocho.ms_cuentas_movimientos.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rommelchocho.ms_cuentas_movimientos.config.RabbitMQConfig;
import com.rommelchocho.ms_cuentas_movimientos.dto.ClienteVerificarResponse;

@Component
public class ClienteResponseConsumer {

    @RabbitListener(queues = RabbitMQConfig.CLIENTE_VERIFICAR_RESPONSE_QUEUE)
    public void procesarRespuestaCliente(ClienteVerificarResponse response) {
        System.out.println("Respuesta recibida: Cliente " + response.getClienteId() + " existe: " + response.isExiste());
        // Aquí podrías almacenar en caché o continuar el flujo de creación de cuentas.
    }
}
