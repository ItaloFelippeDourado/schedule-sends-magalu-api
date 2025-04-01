package br.com.metaldome.schedule_sends_magalu_api.infra.entities;

import br.com.metaldome.schedule_sends_magalu_api.infra.enums.ScheduledStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "agendamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDate dateScheduled;

    private LocalTime timeScheduled;

    private String content;

    @Enumerated(EnumType.STRING)
    private ScheduledStatus status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "agendamento_destinatario",
            joinColumns = @JoinColumn(name = "agendamento_id"),
            inverseJoinColumns = @JoinColumn(name = "destinatario_id")
    )
    private Set<Destinatario> destinatarios = new HashSet<>();
}
