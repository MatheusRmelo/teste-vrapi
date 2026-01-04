package com.example.demo.dto;

import java.util.UUID;

public class MensagemRequest {

    private UUID mensagemId;
    private String conteudoMensagem;

    public UUID getMensagemId() {
        return mensagemId;
    }

    public void setMensagemId(UUID mensagemId) {
        this.mensagemId = mensagemId;
    }

    public String getConteudoMensagem() {
        return conteudoMensagem;
    }

    public void setConteudoMensagem(String conteudoMensagem) {
        this.conteudoMensagem = conteudoMensagem;
    }
}
