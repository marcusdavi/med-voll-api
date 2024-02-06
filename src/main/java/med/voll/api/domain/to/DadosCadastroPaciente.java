package med.voll.api.domain.to;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record DadosCadastroPaciente(
        @NotBlank String nome,
        @NotBlank @CPF String cpf,
        @NotBlank @Email String email,
        @NotBlank String telefone,
        @NotNull @Valid DadosEndereco endereco
) {
}
