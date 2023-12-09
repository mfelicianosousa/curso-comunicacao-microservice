package br.com.mfsdevsys.productapi.modules.user.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mfsdevsys.productapi.modules.user.model.User;
import br.com.mfsdevsys.productapi.modules.user.repository.UserRepository;

//@RestController
//@RequestMapping(value = "/api/users")
public class UserController {

	/*
	private final UserRepository userRepository;
	private final PasswordEncoder encoder;
	
	
	public UserController(UserRepository userRepository, PasswordEncoder encoder) {
		this.userRepository = userRepository;
		this.encoder = encoder;
	}
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		return ResponseEntity.ok( userRepository.findAll());
	}
	
	@PostMapping()
	public ResponseEntity<User> save(@RequestBody User user){
		
		user.setPassword( encoder.encode(user.getPassword()));
		return ResponseEntity.ok(userRepository.save(user));
	}
	
	*/
	/*
	@GetMapping(value="/validatepassword")
	public ResponseEntity<Boolean> validatepassword(@RequestParam String login,
			                                    @RequestParam String password){
		
		
		//Optional<User> optUser = userRepository.findByLogin(login);
		UserDetails optUser = userRepository.findByLogin(login);
		if (optUser.equals(null)) {
		   return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body( false );
		}
		
		User user = optUser.get();
		boolean valid = encoder.matches(password, user.getPassword());
		
		HttpStatus status = (valid) ? HttpStatus.OK : 	HttpStatus.UNAUTHORIZED;
		
		return ResponseEntity.status(status).body(valid);
		
	}
	*/
}
