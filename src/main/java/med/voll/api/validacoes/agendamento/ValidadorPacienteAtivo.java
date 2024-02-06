package med.voll.api.validacoes.agendamento;

import med.voll.api.infra.exception.ValidacaoException;
import med.voll.api.domain.to.DadosAgendamentoConsulta;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsultas {

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        var isPacienteAtivo = repository.findAtivoById(dados.idPaciente());

        if (!isPacienteAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com paciente excluído.");
        }
    }
}
