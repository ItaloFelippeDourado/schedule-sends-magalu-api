package br.com.metaldome.schedule_sends_magalu_api.controller.dto.out;

import br.com.metaldome.schedule_sends_magalu_api.infra.enums.ScheduledStatus;

import java.util.UUID;

public record AgendamentoResponse(UUID id,
                                  ScheduledStatus status) {
}
