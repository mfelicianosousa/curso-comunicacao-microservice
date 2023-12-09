package br.com.mfsdevsys.productapi.modules.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.mfsdevsys.productapi.modules.user.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	//public Optional<User> findByLogin(String login);

	UserDetails findByLogin(String login);

}
