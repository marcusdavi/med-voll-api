package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsultaMesmoHorario implements ValidadorAgendamentoDeConsultas {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
       var isMedicoPossuiConsultaMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());


        if (isMedicoPossuiConsultaMesmoHorario) {
            throw new ValidacaoException("Médico já possui outra consulta agendada nesse mesmo horário.");
        }
    }
}
