package med.voll.api.validacoes.agendamento;

import med.voll.api.infra.exception.ValidacaoException;
import med.voll.api.domain.to.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsultas {

    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();

        var isDomingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var isAntesAbertura = dataConsulta.getHour() < 7;
        var isdepoisEncerramentoAbertura = dataConsulta.getHour() > 18;

        if (isDomingo || isAntesAbertura || isdepoisEncerramentoAbertura) {
            throw new ValidacaoException("Consulta fora do horário de funcionamento da clínica");
        }
    }
}
