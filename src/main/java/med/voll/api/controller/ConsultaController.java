package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.consulta.AgendaDeConsultas;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.consulta.DadosDetalhamentoConsulta;
import med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultas agendaDeConsultas;



    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoConsulta> create(@RequestBody @Valid DadosAgendamentoConsulta dados, UriComponentsBuilder uriBuilder) {
        var agendamento = agendaDeConsultas.agendar(dados);
        return ResponseEntity.ok(agendamento);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoConsulta dados) {
        agendaDeConsultas.cancelar(dados);
        return ResponseEntity.noContent().build();
    }
}
