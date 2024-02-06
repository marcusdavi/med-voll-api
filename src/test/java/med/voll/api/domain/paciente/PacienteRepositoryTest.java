package med.voll.api.domain.paciente;

import med.voll.api.domain.endereco.DadosEndereco;
import med.voll.api.domain.medico.Especialidade;
import med.voll.api.domain.medico.MedicoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class PacienteRepositoryTest {

    @Autowired
    private PacienteRepository repository;

    @Autowired
    private TestEntityManager em;

    @Test
    @DisplayName("Deve retornar uma lista com dois pacientes")
    void findAllByAtivoTrue() {
        var paciente1 = cadastrarPaciente("Paciente1", "paciente1@email.com", "03151265544");
        var paciente2 = cadastrarPaciente("Paciente2", "paciente2@email.com", "03152265544");

        //when or act
        var pacientes = repository.findAllByAtivoTrue(Pageable.ofSize(10));

        // then or assert
        assertThat(pacientes.getTotalElements()).isEqualTo(2);
    }

    @Test
    @DisplayName("Deve retornar verdadeiro, pois o paciente esta ativo")
    void findAtivoById() {
        var paciente = cadastrarPaciente("Paciente1", "paciente1@email.com", "03151265544");

        //when or act
        var pacienteResponse = repository.findAtivoById(paciente.getId());

        // then or assert
        assertThat(pacienteResponse).isTrue();
    }

    @Test
    @DisplayName("Deve retornar falso, pois o paciente esta inativo/excluido")
    void findAtivoByIdInativo() {
        var paciente = cadastrarPaciente("Paciente1", "paciente1@email.com", "03151265544");
        paciente.excluir();
        em.persist(paciente);

        //when or act
        var pacienteResponse = repository.findAtivoById(paciente.getId());

        // then or assert
        assertThat(pacienteResponse).isFalse();
    }

    private Paciente cadastrarPaciente(String nome, String email, String cpf) {
        var paciente = new Paciente(dadosPaciente(nome, email, cpf));
        em.persist(paciente);
        return paciente;
    }

    private DadosCadastroPaciente dadosPaciente(String nome, String email, String cpf) {
        return new DadosCadastroPaciente(
                nome,
                cpf,
                email,
                "61999999999",
                dadosEndereco()
        );
    }

    private DadosEndereco dadosEndereco() {
        return new DadosEndereco(
                "rua xpto",
                "bairro",
                "00000000",
                "Brasilia",
                "DF",
                null,
                null
        );
    }
}