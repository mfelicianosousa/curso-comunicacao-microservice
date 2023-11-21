package br.com.mfsdevsys.productapi.modules.product.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mfsdevsys.productapi.modules.product.dto.LojaDTO;
import br.com.mfsdevsys.productapi.modules.product.service.LojaService;

@RestController
@RequestMapping(value = "api/lojas")
public class LojaResource {
	
	@Autowired
	private LojaService service;
	
	/*
	@GetMapping
	public ResponseEntity<List<Loja>> findAll() {
		
		List<Loja> list = new ArrayList<>();
		// 	public Loja(Integer id, String name, String fantasy, String cnpj) {
		
		list.add( new Loja( 1, "Catarina e Giovanni Comercio de Bebidas Ltda", "LG", "40.286.119/0001-97" ));
		list.add( new Loja( 2, "Lúcia e Julio Mudanças Ltda", "DELL", "54.629.566/0001-06" ));
		list.add( new Loja( 3, "Sabrina e Márcio Contábil ME", "SAMGUNG", "86.286.528/0001-94" ));
		
		return ResponseEntity.ok().body(list);
		
	};
	*/
	
	@GetMapping
	public ResponseEntity<List<LojaDTO>> findAll() {
		
		List<LojaDTO> list = service.findAll();
				
		return ResponseEntity.ok().body(list);
		
	};
	

}
