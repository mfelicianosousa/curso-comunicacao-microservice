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
import br.com.mfsdevsys.productapi.modules.category.dto.CategoryRequest;
import br.com.mfsdevsys.productapi.modules.category.dto.CategoryResponse;
import br.com.mfsdevsys.productapi.modules.category.services.CategoryService;

@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public CategoryResponse save(@RequestBody CategoryRequest request) {
		return categoryService.save(request);
	}
	
	@PutMapping("{id}")
	public CategoryResponse update(@RequestBody CategoryRequest request, @PathVariable Integer id){
		return categoryService.update(request, id );
	}
	
	@DeleteMapping("{id}")
	public SuccessResponse delete(@PathVariable Integer id){
		return categoryService.delete( id );
	}
	
	@GetMapping("{id}")
	public CategoryResponse findById(@PathVariable Integer id){
		return categoryService.findByIdResponse(id);
	}
	
	
	@GetMapping
	public List<CategoryResponse> findAll(){
		return categoryService.findAll();
	}
	
	@GetMapping("name/{name}")
	public List<CategoryResponse> findByName(@PathVariable String name){
		return categoryService.findByName(name);
	}
	
	@GetMapping("categoryMain/{categoryMaiId}")
	public List<CategoryResponse> findByCategoryMainId(@PathVariable Integer categoryMainId){
		return categoryService.findByCategoryMainId(categoryMainId);
	}
	
	
	
	
}
