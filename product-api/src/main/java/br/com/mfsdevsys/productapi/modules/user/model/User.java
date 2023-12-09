package br.com.mfsdevsys.productapi.modules.user.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="users")
@SequenceGenerator(name = "sequence_users_id", sequenceName = "sequence_users_id", allocationSize = 1, initialValue = 1)
public class User implements UserDetails, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_users_id")
	private Integer id;

	@Column(name="login", length = 50, nullable = false, unique=true)
	private String login;
	
	@Column(name="password", length = 120, nullable = false)
	private String password;
	
	@Column(name="role", length = 40, nullable = false)
	private UserRole role;
	
	
    public User(){
    	
    }


	public User(Integer id, String login, String password, UserRole role) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.role = role;
	}
	
	public User(String login, String password, UserRole role) {	
		this.login = login;
		this.password = password;
		this.role = role;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	


	public UserRole getRole() {
		return role;
	}


	public void setRole(UserRole role) {
		this.role = role;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

	    if (this.role == UserRole.ADMIN)
	       return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
	    else
	       return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	    
	}


	@Override
	public String getUsername() {

		return login;
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
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

}
