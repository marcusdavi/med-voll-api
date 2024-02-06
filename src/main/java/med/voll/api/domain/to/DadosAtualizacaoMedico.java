package med.voll.api.domain.to;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(
        @NotBlank String nome,
        @NotBlank String telefone,
        @NotNull @Valid DadosEndereco endereco) {
}
