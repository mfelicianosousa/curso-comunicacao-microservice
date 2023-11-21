package br.com.mfsdevsys.productapi.modules.product.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mfsdevsys.productapi.modules.product.model.Brand;

@RestController
@RequestMapping(value = "api/brands")
public class BrandResource {
	
	@GetMapping
	public ResponseEntity<List<Brand>> findAll() {
		
		List<Brand> list = new ArrayList<>();
		// public Brand(Integer id, String name, String meta_link, byte active) {
		
		list.add( new Brand( 1, "LG", "lg", (byte) 1 ));
		list.add( new Brand( 2, "DELL", "dell", (byte) 1 ));
		list.add( new Brand( 3, "SAMSUNG", "sansung", (byte) 1 ));
		
		return ResponseEntity.ok().body(list);
		
	};
	

}
