package med.voll.api.paciente;

import med.voll.api.medico.DadosDetalhamentoMedico;

public record DadosDetalhamentoPaciente(Long id, String nome, String cpf, String email, String telefone ) {

    public DadosDetalhamentoPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getEmail(), paciente.getTelefone());
    }
}
