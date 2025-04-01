package br.com.metaldome.schedule_sends_magalu_api.controller.dto.in;

public record DestinatarioDto(
        String receiverEmail,
        String phoneNumber,

        PreferenciaComunicacaoDto preferenciaComunicacao
) {}
