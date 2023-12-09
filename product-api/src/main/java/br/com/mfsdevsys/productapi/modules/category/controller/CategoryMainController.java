package br.com.mfsdevsys.productapi.modules.category.controller;

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
import br.com.mfsdevsys.productapi.modules.category.dto.CategoryMainRequest;
import br.com.mfsdevsys.productapi.modules.category.dto.CategoryMainResponse;
import br.com.mfsdevsys.productapi.modules.category.dto.CategoryRequest;
import br.com.mfsdevsys.productapi.modules.category.dto.CategoryResponse;
import br.com.mfsdevsys.productapi.modules.category.services.CategoryMainService;

@RestController
@RequestMapping(value = "/api/categorymain")
public class CategoryMainController {
	
	@Autowired
	private CategoryMainService categoryMainService;
	
	@PostMapping
	public CategoryMainResponse save(@RequestBody CategoryMainRequest request) {
		return categoryMainService.save(request);
	}
	

	@PutMapping("{id}")
	public CategoryMainResponse update(@RequestBody CategoryMainRequest request, @PathVariable Integer id){
		return categoryMainService.update(request, id );
	}

	@DeleteMapping("{id}")
	public SuccessResponse delete(@PathVariable Integer id){
		return categoryMainService.delete( id );
	}
	
	@GetMapping("{id}")
	public CategoryMainResponse findById(@PathVariable Integer id){
		return categoryMainService.findByIdResponse(id);
	}
	
	@GetMapping
	public List<CategoryMainResponse> findAll(){
		return categoryMainService.findAll();
	}
	
	@GetMapping("name/{name}")
	public List<CategoryMainResponse> findByName(@PathVariable String name){
		return categoryMainService.findByName(name);
	}
	
	
}
