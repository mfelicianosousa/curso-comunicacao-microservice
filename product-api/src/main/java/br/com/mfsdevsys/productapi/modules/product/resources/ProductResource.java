package br.com.mfsdevsys.productapi.modules.product.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mfsdevsys.productapi.modules.product.dto.ProductDTO;
import br.com.mfsdevsys.productapi.modules.product.service.ProductService;

@RestController
@RequestMapping(value = "api/products")
public class ProductResource {

	@Autowired
	private ProductService service;
	
	/*  Moock
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		
		List<Product> list = new ArrayList<>();
		
        //		public Product(Integer id, String name) 

		
		list.add( new Product( 1, "Book"));
		list.add( new Product( 2, "Eletronics"));
		list.add( new Product( 3, "Computers"));
		
		return ResponseEntity.ok().body(list);
		
	};

	
	
	@GetMapping
	public ResponseEntity< List< ProductDTO >> findAll() {
		
		List< ProductDTO > list = service.findAll();
				
		return ResponseEntity.ok().body( list );
		
	};
	*/

	@GetMapping
	public ResponseEntity< Page< ProductDTO >> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy
		   ) {
		
		       PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf( direction ), orderBy) ;
		 
		       Page< ProductDTO > list = service.findAllPaged( pageRequest );
				
		       return ResponseEntity.ok().body( list );
		
	};
	
	
	
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable Integer id ) {
		
		ProductDTO dto = service.findById( id );
				
		return ResponseEntity.ok().body( dto );
		
	};
	
	@PostMapping
	public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto){
		dto = service.insert(dto) ;
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				       .buildAndExpand( dto.getId() ).toUri();
		
		return ResponseEntity.created( uri ).body( dto );
		
	}
	
	@PutMapping(value= "/{id}")
	public ResponseEntity<ProductDTO> update(@PathVariable Integer id, @RequestBody ProductDTO dto){
		dto = service.update(id, dto) ;
		return ResponseEntity.ok().body( dto );
	}
	
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id) ;
		return ResponseEntity.noContent().build();
	}
}
