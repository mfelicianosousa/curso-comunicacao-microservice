package br.com.mfsdevsys.productapi.modules.jwt.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.mfsdevsys.productapi.modules.user.model.User;

public class DetailUserData implements UserDetails {

	private static final long serialVersionUID = 1L;

	private final Optional<User> usuario;

	public DetailUserData (Optional<User> usuario) {
	        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return usuario.orElse(new User()).getPassword();
    }

    @Override
    public String getUsername() {
        return usuario.orElse(new User()).getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

