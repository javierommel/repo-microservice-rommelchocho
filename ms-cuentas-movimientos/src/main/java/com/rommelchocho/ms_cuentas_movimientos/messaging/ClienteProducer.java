package com.rommelchocho.ms_cuentas_movimientos.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.rommelchocho.ms_cuentas_movimientos.config.RabbitMQConfig;
import com.rommelchocho.ms_cuentas_movimientos.dto.ClienteVerificarRequest;

@Component
public class ClienteProducer {
    
    private final RabbitTemplate rabbitTemplate;

    public ClienteProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarSolicitudCliente(ClienteVerificarRequest request) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.CLIENTE_VERIFICAR_QUEUE, request);
    }
}
