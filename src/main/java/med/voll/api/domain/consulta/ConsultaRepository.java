package med.voll.api.domain.consulta;

import med.voll.api.domain.medico.Medico;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    boolean existsByPacienteIdAndDataBetween(Long idPaciente, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);
    boolean existsByMedicoIdAndData(Long idMedico, LocalDateTime data);
}
