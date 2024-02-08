package med.voll.api.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Entidade que representa um usuário no sistema.
 */
@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String senha;

    /**
     * Retorna as autoridades do usuário.
     * @return Lista contendo a autoridade do usuário (ROLE_USER).
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    /**
     * Retorna a senha do usuário.
     * @return A senha do usuário.
     */
    @Override
    public String getPassword() {
        return senha;
    }

    /**
     * Retorna o nome de usuário do usuário.
     * @return O nome de usuário do usuário.
     */
    @Override
    public String getUsername() {
        return login;
    }

    /**
     * Verifica se a conta do usuário não expirou.
     * @return true sempre, pois não há verificação de expiração de conta implementada.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Verifica se a conta do usuário não está bloqueada.
     * @return true sempre, pois não há verificação de conta bloqueada implementada.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Verifica se as credenciais do usuário não expiraram.
     * @return true sempre, pois não há verificação de credenciais expiradas implementada.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Verifica se o usuário está habilitado.
     * @return true sempre, pois não há verificação de usuário habilitado implementada.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
