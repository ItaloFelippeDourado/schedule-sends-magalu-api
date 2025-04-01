package br.com.metaldome.schedule_sends_magalu_api.infra.repositories;

import br.com.metaldome.schedule_sends_magalu_api.infra.entities.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, UUID> {
}
