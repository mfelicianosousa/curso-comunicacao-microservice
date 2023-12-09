package br.com.mfsdevsys.productapi.modules.supplier.resources;

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

import br.com.mfsdevsys.productapi.modules.supplier.dto.SupplierDTO;
import br.com.mfsdevsys.productapi.modules.supplier.dto.SupplierRequest;
import br.com.mfsdevsys.productapi.modules.supplier.dto.SupplierResponse;
import br.com.mfsdevsys.productapi.modules.supplier.service.SupplierService;

//@RestController
//@RequestMapping(value = "api/suppliers")
public class SupplierResource {
	
//	@Autowired
//	private SupplierService service;
	
	
	/*
	@GetMapping
	public ResponseEntity<List<Supplier>> findAll() {
		
		List<Supplier> list = new ArrayList<>();
		
        // public Supplier(Integer id, String name, byte active) {

		
		list.add( new Supplier( 1, "Hardware", (byte) 1));
		list.add( new Supplier( 2, "Notebooks",(byte) 1 ));
		list.add( new Supplier( 3, "Celulares", (byte) 1 ));
		
		return ResponseEntity.ok().body(list);
		
	};
	*/
/*
	@GetMapping
	public ResponseEntity<List<SupplierDTO>> findAll() {
		
		List<SupplierDTO> list = service.findAll();
				
		return ResponseEntity.ok().body(list);
		
	};
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<SupplierDTO> findById(@PathVariable Integer id ) {
		
		SupplierDTO dto = service.findById( id );
				
		return ResponseEntity.ok().body( dto );
		
	};
	
	@PostMapping
	public SupplierResponse save(@RequestBody SupplierRequest request) {
		return service.save(request);
	}
	
	/*
	@PostMapping
	public ResponseEntity<SupplierDTO> insert(@RequestBody SupplierDTO dto){
		dto = service.insert(dto) ;
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				       .buildAndExpand( dto.getId() ).toUri();	
		return ResponseEntity.created( uri ).body( dto );
		
	}
	*/
	/*
	@PutMapping(value= "/{id}")
	public ResponseEntity<SupplierDTO> update(@PathVariable Integer id, @RequestBody SupplierDTO dto){
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
