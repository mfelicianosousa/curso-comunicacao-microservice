package br.com.mfsdevsys.productapi.modules.product.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mfsdevsys.productapi.modules.product.dto.CategoryDTO;
import br.com.mfsdevsys.productapi.modules.product.service.CategoryService;

@RestController
@RequestMapping(value = "api/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	/*  Moock
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		
		List<Category> list = new ArrayList<>();
		
        //		public Category(Integer id, String name) 

		
		list.add( new Category( 1, "Book"));
		list.add( new Category( 2, "Eletronics"));
		list.add( new Category( 3, "Computers"));
		
		return ResponseEntity.ok().body(list);
		
	};
	*/
	
	@GetMapping
	public ResponseEntity< List< CategoryDTO >> findAll() {
		
		List< CategoryDTO > list = service.findAll();
				
		return ResponseEntity.ok().body( list );
		
	};
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<CategoryDTO> findById(@PathVariable Integer id ) {
		
		CategoryDTO dto = service.findById( id );
				
		return ResponseEntity.ok().body( dto );
		
	};
	
	
}