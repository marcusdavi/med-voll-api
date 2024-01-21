package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.DadosAtualizacaoMedico;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import med.voll.api.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> findAll(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable paginacao) {
        return ResponseEntity.ok(repository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemPaciente::new));
    }

    @PutMapping("/{id}")
    @Transactional
    public void update(@PathVariable  Long id, @RequestBody @Valid DadosAtualizacaoPaciente dados) {
        Paciente paciente = repository.getReferenceById(id);
        paciente.atualizarInformacoes(dados);
    }

    @PatchMapping("/{id}")
    @Transactional
    public void toInactive(@PathVariable Long id) {
        Paciente paciente = repository.getReferenceById(id);
        paciente.inativar();
    }
}
