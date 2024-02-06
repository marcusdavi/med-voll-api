package med.voll.api.validacoes.cancelamento;

import med.voll.api.domain.to.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {

    void validar(DadosCancelamentoConsulta dados);

}
