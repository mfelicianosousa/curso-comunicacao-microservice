package br.com.mfsdevsys.productapi.modules.brand.controller;

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
import br.com.mfsdevsys.productapi.modules.brand.dto.BrandRequest;
import br.com.mfsdevsys.productapi.modules.brand.dto.BrandResponse;
import br.com.mfsdevsys.productapi.modules.brand.service.BrandService;
import br.com.mfsdevsys.productapi.modules.category.dto.CategoryRequest;
import br.com.mfsdevsys.productapi.modules.category.dto.CategoryResponse;
import br.com.mfsdevsys.productapi.modules.loja.dto.LojaResponse;

@RestController
@RequestMapping(value = "/api/brands")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@PostMapping
	public BrandResponse save(@RequestBody BrandRequest request) {
		return brandService.save(request);
	}
	
	@PutMapping("{id}")
	public BrandResponse update(@RequestBody BrandRequest request, @PathVariable Integer id){
		return brandService.update(request, id );
	}
	
	@GetMapping
	public List<BrandResponse> findAll(){
		return brandService.findAll();
	}
	
	@GetMapping("{id}")
	public BrandResponse findById(@PathVariable Integer id){
		return brandService.findByIdResponse(id);
	}
	
	@GetMapping("name/{name}")
	public List<BrandResponse> findByName(@PathVariable String name){
		return brandService.findByName(name);
	}
	
	@DeleteMapping("{id}")
	public SuccessResponse delete(@PathVariable Integer id){
		return brandService.delete( id );
	}

}


