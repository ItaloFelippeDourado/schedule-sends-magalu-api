package br.com.metaldome.schedule_sends_magalu_api.controller.dto.in;

import br.com.metaldome.schedule_sends_magalu_api.infra.enums.ScheduledStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public record AgendamentoDto(
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        LocalDate dateScheduled,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
        LocalTime timeScheduled,
        String content,
        ScheduledStatus status,
        Set<DestinatarioDto> destinatarios
) {}
