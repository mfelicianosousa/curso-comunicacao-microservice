package br.com.mfsdevsys.productapi.modules.supplier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mfsdevsys.productapi.config.exception.SuccessResponse;
import br.com.mfsdevsys.productapi.modules.supplier.dto.SupplierRequest;
import br.com.mfsdevsys.productapi.modules.supplier.dto.SupplierResponse;
import br.com.mfsdevsys.productapi.modules.supplier.service.SupplierService;

@RestController
@RequestMapping(value = "/api/suppliers")
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	
	@PostMapping
	public SupplierResponse save(@RequestBody SupplierRequest request) {
		return supplierService.save(request);
	}
	
	@PutMapping("{id}")
	public SupplierResponse update(@RequestBody SupplierRequest request, @PathVariable Integer id) {
		return supplierService.update(request, id);
	}
		
	@DeleteMapping("{id}")
	public SuccessResponse delete(@PathVariable Integer id) {
	    return supplierService.delete(id);
	}
	

	@GetMapping("{id}")
	public SupplierResponse findById(@PathVariable Integer id){
		return supplierService.findByIdResponse(id);
	}
	
	@GetMapping
	public List<SupplierResponse> findAll(){
		return supplierService.findAll();
	}
	
	@GetMapping("name/{name}")
	public List<SupplierResponse> findByName(@PathVariable String name){
		return supplierService.findByName(name);
	}

	
}


