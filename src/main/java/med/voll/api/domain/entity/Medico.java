package med.voll.api.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.to.DadosAtualizacaoMedico;
import med.voll.api.domain.to.DadosCadastroMedico;
import med.voll.api.domain.enums.Especialidade;

/**
 * Representa um médico.
 */
@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    /**
     * O ID do médico.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * O nome do médico.
     */
    private String nome;

    /**
     * O e-mail do médico.
     */
    private String email;

    /**
     * O telefone do médico.
     */
    private String telefone;

    /**
     * O número do CRM do médico.
     */
    private String crm;

    /**
     * Indica se o médico está ativo ou não.
     */
    private Boolean ativo;

    /**
     * A especialidade do médico.
     */
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    /**
     * O endereço do médico.
     */
    @Embedded
    private Endereco endereco;

    /**
     * Construtor para criar um novo médico com base nos dados de cadastro.
     *
     * @param dados Os dados de cadastro do médico.
     */
    public Medico(DadosCadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    /**
     * Atualiza as informações do médico com base nos dados fornecidos.
     *
     * @param dados Os dados de atualização do médico.
     */
    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
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
     * Exclui o médico, marcando-o como inativo.
     */
    public void excluir() {
        this.ativo = false;
    }
}
