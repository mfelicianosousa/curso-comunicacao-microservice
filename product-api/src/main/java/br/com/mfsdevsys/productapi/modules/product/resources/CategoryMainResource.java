package br.com.mfsdevsys.productapi.modules.product.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mfsdevsys.productapi.modules.product.dto.CategoryDTO;
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
	
}
