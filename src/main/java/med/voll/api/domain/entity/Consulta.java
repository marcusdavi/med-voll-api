package med.voll.api.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.enums.MotivoCancelamento;

import java.time.LocalDateTime;

/**
 * Representa uma consulta médica.
 */
@Table(name = "consultas")
@Entity(name = "Consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {

    /**
     * O ID da consulta.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * O médico responsável pela consulta.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    /**
     * O paciente que está agendado para a consulta.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    /**
     * A data e hora da consulta.
     */
    private LocalDateTime data;

    /**
     * O motivo do cancelamento, se a consulta foi cancelada.
     */
    @Column(name = "motivo_cancelamento")
    @Enumerated(EnumType.STRING)
    private MotivoCancelamento motivoCancelamento;

    /**
     * Cancela a consulta com o motivo especificado.
     * @param motivo O motivo do cancelamento.
     */
    public void cancelar(MotivoCancelamento motivo) {
        this.motivoCancelamento = motivo;
    }
}
