package br.com.metaldome.schedule_sends_magalu_api.infra.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "destinatarios")
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Destinatario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String receiverEmail;

    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "preferencia_comunicacao_id", referencedColumnName = "id", unique = true)
    private PreferenciaComunicacao preferenciaComunicacao;

    @ManyToMany(mappedBy = "destinatarios")
    private Set<Agendamento> agendamentos = new HashSet<>();

}
