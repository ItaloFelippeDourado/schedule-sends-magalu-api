package br.com.metaldome.schedule_sends_magalu_api.controller;

import br.com.metaldome.schedule_sends_magalu_api.business.AgendamentoService;
import br.com.metaldome.schedule_sends_magalu_api.controller.dto.in.AgendamentoDto;
import br.com.metaldome.schedule_sends_magalu_api.controller.dto.out.AgendamentoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService service;

    @PostMapping
    public ResponseEntity<AgendamentoResponse> criarAgendamento(@RequestBody AgendamentoDto agendamentoDto) {
        return ResponseEntity.ok(service.create(agendamentoDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoResponse> buscarAgendamento(@PathVariable String id) {

        UUID uuid = UUID.fromString(id);
        return ResponseEntity.ok(service.findById(uuid));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAgendamento(@PathVariable String id) {

        UUID uuid = UUID.fromString(id);
        service.cancelSchedule(uuid);
        return ResponseEntity.accepted().build();
    }
}
