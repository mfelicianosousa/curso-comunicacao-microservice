package br.com.mfsdevsys.productapi.modules.product.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mfsdevsys.productapi.modules.product.model.CategoryMain;
import br.com.mfsdevsys.productapi.modules.product.model.Supplier;

@RestController
@RequestMapping(value = "api/suppliers")
public class SupplierResource {
	
	@GetMapping
	public ResponseEntity<List<Supplier>> findAll() {
		
		List<Supplier> list = new ArrayList<>();
		
        // public Supplier(Integer id, String name, byte active) {

		
		list.add( new Supplier( 1, "Hardware", (byte) 1));
		list.add( new Supplier( 2, "Notebooks",(byte) 1 ));
		list.add( new Supplier( 3, "Celulares", (byte) 1 ));
		
		return ResponseEntity.ok().body(list);
		
	};

}
