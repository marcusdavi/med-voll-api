package med.voll.api.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        @NotBlank String nome,
        @NotBlank String telefone,
        @NotNull @Valid DadosEndereco endereco) {
}
