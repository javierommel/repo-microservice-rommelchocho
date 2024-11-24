package com.rommelchocho.ms_cuentas_movimientos.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String CLIENTE_VERIFICAR_QUEUE = "cliente_verificar_queue";
    public static final String CLIENTE_VERIFICAR_RESPONSE_QUEUE = "cliente_verificar_response_queue";

    @Bean
    public Queue clienteVerificarQueue() {
        return new Queue(CLIENTE_VERIFICAR_QUEUE, true);
    }

    @Bean
    public Queue clienteVerificarResponseQueue() {
        return new Queue(CLIENTE_VERIFICAR_RESPONSE_QUEUE, true);
    }
}
