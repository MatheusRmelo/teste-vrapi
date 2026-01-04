package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.config.RabbitConfig;
import com.example.demo.dto.MensagemRequest;

@Service
public class ConsumerService {
    private final RabbitTemplate rabbitTemplate;

    public ConsumerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = RabbitConfig.FILA_ENTRADA)
    public void consumeMessage(MensagemRequest message) throws InterruptedException {

        System.out.println("Processando mensagem: "
                + message.getMensagemId());

        Thread.sleep(2000);

        Map<String, Object> status = new HashMap<>();
        status.put("mensagemId", message.getMensagemId());
        status.put("status", "PROCESSADO_SUCESSO");
        status.put("conteudoMensagem", message.getConteudoMensagem());

        rabbitTemplate.convertAndSend(
                RabbitConfig.FILA_STATUS,
                status);

        System.out.println("Mensagem processada com sucesso");
    }
}
