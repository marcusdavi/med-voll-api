package med.voll.api.domain.to;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.enums.MotivoCancelamento;

public record DadosCancelamentoConsulta(@NotNull
                                        Long idConsulta,

                                        @NotNull
                                        MotivoCancelamento motivo) {
}
