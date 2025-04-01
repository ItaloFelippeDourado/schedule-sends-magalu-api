package br.com.metaldome.schedule_sends_magalu_api.infra.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "preferencias_comunicacao")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PreferenciaComunicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Boolean email;

    private Boolean sms;

    private Boolean push;

    private Boolean whatsapp;
}
