package med.voll.api.validacoes.agendamento;

import med.voll.api.domain.to.DadosAgendamentoConsulta;

public interface ValidadorAgendamentoDeConsultas {

    void validar(DadosAgendamentoConsulta dados);
}
