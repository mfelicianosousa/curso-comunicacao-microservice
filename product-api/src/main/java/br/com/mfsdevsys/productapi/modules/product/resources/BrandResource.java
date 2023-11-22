package br.com.mfsdevsys.productapi.modules.product.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mfsdevsys.productapi.modules.product.dto.BrandDTO;
import br.com.mfsdevsys.productapi.modules.product.dto.CategoryDTO;
import br.com.mfsdevsys.productapi.modules.product.dto.CategoryMainDTO;
import br.com.mfsdevsys.productapi.modules.product.service.BrandService;

@RestController
@RequestMapping(value = "api/brands")
public class BrandResource {
	
	@Autowired
	private BrandService service;
	
	/*
	@GetMapping
	public ResponseEntity<List<Brand>> findAll() {
		
		List<Brand> list = new ArrayList<>();
		// public Brand(Integer id, String name, String meta_link, byte active) {
		
		list.add( new Brand( 1, "LG", "lg", (byte) 1 ));
		list.add( new Brand( 2, "DELL", "dell", (byte) 1 ));
		list.add( new Brand( 3, "SAMSUNG", "sansung", (byte) 1 ));
		
		return ResponseEntity.ok().body(list);
		
	};
	*/
	
	@GetMapping
	public ResponseEntity<List<BrandDTO>> findAll() {
		
		List<BrandDTO> list = service.findAll();
				
		return ResponseEntity.ok().body(list);
		
	};
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<BrandDTO> findById(@PathVariable Integer id ) {
		
		BrandDTO dto = service.findById( id );
				
		return ResponseEntity.ok().body( dto );
		
	};
	
	@PostMapping
	public ResponseEntity<BrandDTO> insert(@RequestBody BrandDTO dto){
		dto = service.insert(dto) ;
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				       .buildAndExpand( dto.getId() ).toUri();
		
		return ResponseEntity.created( uri ).body( dto );
		
	}
	

}
