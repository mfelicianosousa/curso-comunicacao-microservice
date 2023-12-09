package br.com.mfsdevsys.productapi.modules.loja.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mfsdevsys.productapi.modules.brand.dto.BrandDTO;
import br.com.mfsdevsys.productapi.modules.loja.dto.LojaDTO;
import br.com.mfsdevsys.productapi.modules.loja.service.LojaService;
import br.com.mfsdevsys.productapi.modules.supplier.dto.SupplierDTO;

//@RestController
//@RequestMapping(value = "api/lojas")
public class LojaResource {
	
//	@Autowired
//	private LojaService service;
	
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
	
	
	@GetMapping
	public ResponseEntity<List<LojaDTO>> findAll() {
		
		List<LojaDTO> list = service.findAll();
				
		return ResponseEntity.ok().body(list);
		
	};
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<LojaDTO> findById(@PathVariable Integer id ) {
		
		LojaDTO dto = service.findById( id );
				
		return ResponseEntity.ok().body( dto );
		
	};
	
	@PostMapping
	public ResponseEntity<LojaDTO> insert(@RequestBody LojaDTO dto){
		dto = service.insert(dto) ;
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				       .buildAndExpand( dto.getId() ).toUri();
		
		return ResponseEntity.created( uri ).body( dto );
		
	}
	
	@PutMapping(value= "/{id}")
	public ResponseEntity<LojaDTO> update(@PathVariable Integer id, @RequestBody LojaDTO dto){
		dto = service.update(id, dto) ;
		return ResponseEntity.ok().body( dto );
	}
	
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id) ;
		return ResponseEntity.noContent().build();
	}
	
*/
}
