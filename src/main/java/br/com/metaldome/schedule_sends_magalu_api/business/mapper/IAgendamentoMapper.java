package br.com.metaldome.schedule_sends_magalu_api.business.mapper;

import br.com.metaldome.schedule_sends_magalu_api.controller.dto.in.AgendamentoDto;
import br.com.metaldome.schedule_sends_magalu_api.controller.dto.out.AgendamentoResponse;
import br.com.metaldome.schedule_sends_magalu_api.infra.entities.Agendamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IAgendamentoMapper {

    Agendamento toEntity(AgendamentoDto agendamentoDto);

    AgendamentoResponse toResponse(Agendamento agendamento);

    @Mapping(target = "status", expression = "java(ScheduledStatus.CANCELADO")
    Agendamento toCancelEntity(@MappingTarget Agendamento agendamentoDto);
}
