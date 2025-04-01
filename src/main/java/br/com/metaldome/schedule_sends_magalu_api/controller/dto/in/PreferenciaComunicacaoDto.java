package br.com.metaldome.schedule_sends_magalu_api.controller.dto.in;

public record PreferenciaComunicacaoDto(
        Boolean email,
        Boolean sms,
        Boolean push,
        Boolean whatsapp
) {}
