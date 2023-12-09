package br.com.mfsdevsys.productapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //(exclude = {SecurityAutoConfiguration.class})
public class ProductApiApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(ProductApiApplication.class, args);
	}
	

}
