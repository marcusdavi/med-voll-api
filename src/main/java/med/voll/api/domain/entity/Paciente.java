package med.voll.api.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.to.DadosAtualizacaoPaciente;
import med.voll.api.domain.to.DadosCadastroPaciente;

/**
 * Representa um paciente.
 */
@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    /**
     * O ID do paciente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * O nome do paciente.
     */
    private String nome;

    /**
     * O CPF do paciente.
     */
    private String cpf;

    /**
     * O e-mail do paciente.
     */
    private String email;

    /**
     * O telefone do paciente.
     */
    private String telefone;

    /**
     * Indica se o paciente está ativo ou não.
     */
    private Boolean ativo;

    /**
     * O endereço do paciente.
     */
    @Embedded
    private Endereco endereco;

    /**
     * Construtor para criar um novo paciente com base nos dados de cadastro.
     * @param dados Os dados de cadastro do paciente.
     */
    public Paciente(DadosCadastroPaciente dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
    }

    /**
     * Atualiza as informações do paciente com base nos dados fornecidos.
     * @param dados Os dados de atualização do paciente.
     */
    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }

        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    /**
     * Exclui o paciente, marcando-o como inativo.
     */
    public void excluir() {
        this.ativo = false;
    }
}
