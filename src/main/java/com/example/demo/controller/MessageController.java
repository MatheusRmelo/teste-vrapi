package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.MensagemRequest;
import com.example.demo.service.ProducerService;

@RestController
@RequestMapping("/api/notificar")
public class MessageController {
    private final ProducerService producerService;

    public MessageController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping()
    public ResponseEntity<Map<String, Object>> send(@RequestBody MensagemRequest request) {
        if (request.getMensagemId() == null) {
            request.setMensagemId(UUID.randomUUID());
        }
        producerService.sendMessage(request);

        Map<String, Object> resposta = new HashMap<>();
        resposta.put("mensagemId", request.getMensagemId());
        resposta.put("status", "RECEBIDO");

        return ResponseEntity.accepted().body(resposta);
    }
}
