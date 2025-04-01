package br.com.metaldome.schedule_sends_magalu_api.business;

import br.com.metaldome.schedule_sends_magalu_api.business.mapper.IAgendamentoMapper;
import br.com.metaldome.schedule_sends_magalu_api.controller.dto.in.AgendamentoDto;
import br.com.metaldome.schedule_sends_magalu_api.controller.dto.out.AgendamentoResponse;
import br.com.metaldome.schedule_sends_magalu_api.infra.entities.Agendamento;
import br.com.metaldome.schedule_sends_magalu_api.infra.exceptions.ScheduleNotFoundException;
import br.com.metaldome.schedule_sends_magalu_api.infra.repositories.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private IAgendamentoMapper agendamentoMapper;

    public AgendamentoResponse create(AgendamentoDto agendamentoDto) {
        return agendamentoMapper.toResponse(
                agendamentoRepository.save(
                        agendamentoMapper.toEntity(agendamentoDto)));
    }

    public AgendamentoResponse findById(UUID id) {
        return agendamentoMapper.toResponse(
                agendamentoRepository.findById(id).orElseThrow(()-> new ScheduleNotFoundException("Agendamento não encontrado")));
    }

    public void cancelSchedule(UUID id) {
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(()-> new ScheduleNotFoundException("Agendamento não encontrado"));
        agendamentoRepository.save(agendamentoMapper.toCancelEntity(agendamento));
    }
}
