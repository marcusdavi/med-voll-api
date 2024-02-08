package med.voll.api.domain.to;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.enums.Especialidade;

import java.time.LocalDateTime;

/**
 * Representa os dados de um agendamento de consulta.
 */
public record DadosAgendamentoConsulta(
        /**
         * O ID do médico responsável pela consulta.
         */
        Long idMedico,

        /**
         * O ID do paciente que está agendando a consulta.
         */
        @NotNull Long idPaciente,

        /**
         * A data e hora da consulta, que deve ser no futuro.
         */
        @NotNull @Future LocalDateTime data,

        /**
         * A especialidade médica para a qual a consulta está sendo agendada.
         */
        Especialidade especialidade
) {
}
