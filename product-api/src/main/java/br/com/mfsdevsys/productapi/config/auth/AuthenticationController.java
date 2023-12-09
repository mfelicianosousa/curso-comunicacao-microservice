package br.com.mfsdevsys.productapi.config.auth;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mfsdevsys.productapi.infra.security.TokenService;
import br.com.mfsdevsys.productapi.modules.user.dto.AuthenticationDTO;
import br.com.mfsdevsys.productapi.modules.user.dto.LoginResponseDTO;
import br.com.mfsdevsys.productapi.modules.user.dto.RegisterDTO;
import br.com.mfsdevsys.productapi.modules.user.model.User;
import br.com.mfsdevsys.productapi.modules.user.repository.UserRepository;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TokenService tokenService;
	

	@PostMapping("/login")
	public ResponseEntity login(@RequestBody AuthenticationDTO data ) {
		
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
	    var auth = this.authenticationManager.authenticate(usernamePassword);
	    
	    var token = tokenService.generateToken( (User) auth.getPrincipal());
	    return ResponseEntity.ok( new LoginResponseDTO( token ));
	} 
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody RegisterDTO data) {
		
		if ( this.userRepository.findByLogin( data.login()) != null)
            return ResponseEntity.badRequest().build();	
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
		
		User newUser = new User(data.login(), encryptedPassword, data.role());
		
		this.userRepository.save(newUser) ;
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getListAll(){
		
		return ResponseEntity.ok( userRepository.findAll());
	}
	
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
