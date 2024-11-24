package com.rommelchocho.ms_clientes_personas.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.rommelchocho.ms_clientes_personas.config.RabbitMQConfig;
import com.rommelchocho.ms_clientes_personas.dto.ClienteVerificarRequest;
import com.rommelchocho.ms_clientes_personas.dto.ClienteVerificarResponse;
import com.rommelchocho.ms_clientes_personas.service.ClienteService;

@Component
public class ClienteConsumer {
    
    private final RabbitTemplate rabbitTemplate;
    private final ClienteService clienteService;

    public ClienteConsumer(RabbitTemplate rabbitTemplate, ClienteService clienteService) {
        this.rabbitTemplate = rabbitTemplate;
        this.clienteService = clienteService;
    }

    @RabbitListener(queues = RabbitMQConfig.CLIENTE_VERIFICAR_QUEUE)
    public void procesarSolicitudCliente(ClienteVerificarRequest request) {
        boolean existe = clienteService.existeCliente(request.getClienteId());
        ClienteVerificarResponse response = new ClienteVerificarResponse(request.getClienteId(), existe);

        // Publicar la respuesta
        rabbitTemplate.convertAndSend(RabbitMQConfig.CLIENTE_VERIFICAR_RESPONSE_QUEUE, response);
    }
}
