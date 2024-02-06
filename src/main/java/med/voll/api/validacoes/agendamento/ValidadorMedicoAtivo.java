package med.voll.api.validacoes.agendamento;

import med.voll.api.infra.exception.ValidacaoException;
import med.voll.api.domain.to.DadosAgendamentoConsulta;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsultas {

    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() == null) {
            return;
        }

        var isMedicoAtivo = repository.findAtivoById(dados.idMedico());

        if (!isMedicoAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com médico excluído.");
        }
    }
}
