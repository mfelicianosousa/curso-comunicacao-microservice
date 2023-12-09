package br.com.mfsdevsys.productapi.modules.loja.controller;

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
import br.com.mfsdevsys.productapi.modules.loja.dto.LojaRequest;
import br.com.mfsdevsys.productapi.modules.loja.dto.LojaResponse;
import br.com.mfsdevsys.productapi.modules.loja.service.LojaService;
import br.com.mfsdevsys.productapi.modules.supplier.dto.SupplierRequest;
import br.com.mfsdevsys.productapi.modules.supplier.dto.SupplierResponse;

@RestController
@RequestMapping(value = "/api/lojas")
public class LojaController {
	
	@Autowired
	private LojaService lojaService;
		
	@PostMapping
	public LojaResponse save(@RequestBody LojaRequest request) {
		return lojaService.save(request);
	}
	
	@PutMapping("{id}")
	public LojaResponse update(@RequestBody LojaRequest request, @PathVariable Integer id) {
		return lojaService.update(request, id);
	}
	
	@DeleteMapping("{id}")
	public SuccessResponse delete(@PathVariable Integer id){
		return lojaService.delete( id );
	}
	
	@GetMapping("{id}")
	public LojaResponse findById(@PathVariable Integer id){
		return lojaService.findByIdResponse(id);
	}
	
	@GetMapping
	public List<LojaResponse> findAll(){
		return lojaService.findAll();
	}
	
	@GetMapping("name/{name}")
	public List<LojaResponse> findByName(@PathVariable String name){
		return lojaService.findByName(name);
	}

}


