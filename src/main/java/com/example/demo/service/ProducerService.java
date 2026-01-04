package com.example.demo.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.config.RabbitConfig;

@Service
public class ProducerService {
    private final RabbitTemplate rabbitTemplate;

    public ProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Object payload) {
        rabbitTemplate.convertAndSend(RabbitConfig.FILA_ENTRADA, payload);
    }
}
