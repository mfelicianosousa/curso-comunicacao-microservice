package br.com.mfsdevsys.productapi.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.mfsdevsys.productapi.ProductApiApplication;
import br.com.mfsdevsys.productapi.config.AppConfig;
import br.com.mfsdevsys.productapi.modules.user.model.User;
import jakarta.annotation.PostConstruct;

@Component
public class TokenService {
	
	//public static final String SECRET = "463408a1-54c9-4307-bb1c-6cced559f5a7";
	
	private static Logger logger = LoggerFactory.getLogger(ProductApiApplication.class);
	
	private final AppConfig appConfig;
	
	public TokenService(AppConfig appConfig) {
		this.appConfig = appConfig;
	}
	
	@PostConstruct
	public void print(){
		System.out.println(appConfig.getTokenSecret());
		logger.info("Token secret : ".concat(appConfig.getTokenSecret()));
	}

	public String generateToken( User user) {
		try {
					
			Algorithm algorithm = Algorithm.HMAC256( appConfig.getTokenSecret() );
			
			String token = JWT.create()
					.withIssuer( "product-api" )
					.withSubject( user.getLogin() )
					.withExpiresAt( generatorExpirationDate() )
					.sign( algorithm );
			
			logger.info("[TokenService.class] Token gerado com sucesso ".concat(token));
			return token;
			
		} catch(JWTCreationException ex) {
			logger.info("TokenService.class Erro ao gerar o token ".concat(ex.getMessage()));
			throw new RuntimeException("Error while generating token", ex);
		}
	}
		
	public String validateToken(String token) {
		try {
			
			Algorithm algorithm = Algorithm.HMAC256(appConfig.getTokenSecret());
			return JWT.require(algorithm)
					.withIssuer("product-api")
					.build()
					.verify(token)
					.getSubject();
			
		} catch (JWTVerificationException ex) {
			return "";
		}
		
		
	}
	
	private Instant generatorExpirationDate() {
		// timezone de Brasilia (-03:00)
		return LocalDateTime.now().plusHours(2).toInstant( ZoneOffset.of("-03:00"));
	}
}
