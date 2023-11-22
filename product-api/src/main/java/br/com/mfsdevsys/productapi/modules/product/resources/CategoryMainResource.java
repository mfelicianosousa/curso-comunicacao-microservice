package br.com.mfsdevsys.productapi.modules.product.resources;

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

import br.com.mfsdevsys.productapi.modules.product.dto.CategoryMainDTO;
import br.com.mfsdevsys.productapi.modules.product.service.CategoryMainService;

@RestController
@RequestMapping(value = "api/categorymain")
public class CategoryMainResource {
	
	@Autowired
	private CategoryMainService service;
	
	
	/*
	@GetMapping
	public ResponseEntity<List<CategoryMain>> findAll() {
		
		List<CategoryMain> list = new ArrayList<>();
		
//		public CategoryMain(Integer id, String name, String description, String meta_link) {

		
		list.add( new CategoryMain( 1, "Hardware", "hardware", "hardware" ));
		list.add( new CategoryMain( 2, "Notebooks", "Notebooks", "notebooks" ));
		list.add( new CategoryMain( 3, "Celulares", "celulares", "Celulares" ));
		
		return ResponseEntity.ok().body(list);
		
	};
	*/
	@GetMapping
	public ResponseEntity<List<CategoryMainDTO>> findAll() {
		
		List<CategoryMainDTO> list = service.findAll();
				
		return ResponseEntity.ok().body(list);
		
	};
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<CategoryMainDTO> findById(@PathVariable Integer id ) {
		
		CategoryMainDTO dto = service.findById( id );
				
		return ResponseEntity.ok().body( dto );
		
	};
	
	@PostMapping
	public ResponseEntity<CategoryMainDTO> insert(@RequestBody CategoryMainDTO dto){
		dto = service.insert(dto) ;
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				       .buildAndExpand( dto.getId() ).toUri();
		
		return ResponseEntity.created( uri ).body( dto );
		
	}
	
	@PutMapping(value= "/{id}")
	public ResponseEntity<CategoryMainDTO> update(@PathVariable Integer id, @RequestBody CategoryMainDTO dto){
		dto = service.update(id, dto) ;
		return ResponseEntity.ok().body( dto );
	}
	
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id) ;
		return ResponseEntity.noContent().build();
	}
	
	
	

}
