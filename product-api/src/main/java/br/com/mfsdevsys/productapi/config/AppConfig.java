package br.com.mfsdevsys.productapi.config;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.app-config.secrets")
public class AppConfig implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String url;
	
	@Value("${spring.app-config.secrets.token-secret}")
	private String tokenSecret;
	
	public AppConfig() {}
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTokenSecret() {
		return tokenSecret;
	}
	public void setTokenSecret(String tokenSecret) {
		this.tokenSecret = tokenSecret;
	}
	
	

}
