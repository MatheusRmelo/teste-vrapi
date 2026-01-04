package com.example.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

@Configuration
public class RabbitConfig {

    public static final String FILA_ENTRADA = "fila.notificacao.entrada.matheus";

    public static final String FILA_STATUS = "fila.notificacao.status.matheus";

    public static final String EXCHANGE = "exchange.matheus";

    public static final String ROUTING_KEY_ENTRADA = "routing.notificacao.entrada";

    public static final String ROUTING_KEY_STATUS = "routing.notificacao.status";

    @Bean
    public Queue queueEntrada() {
        return QueueBuilder.durable(FILA_ENTRADA).build();
    }

    @Bean
    public Queue queueStatus() {
        return QueueBuilder.durable(FILA_STATUS).build();
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Binding bindingEntrada() {
        return BindingBuilder
                .bind(queueEntrada())
                .to(exchange())
                .with(ROUTING_KEY_ENTRADA);
    }

    @Bean
    public Binding bindingStatus() {
        return BindingBuilder
                .bind(queueStatus())
                .to(exchange())
                .with(ROUTING_KEY_STATUS);
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
