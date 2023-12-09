package br.com.mfsdevsys.productapi.modules.product.controller;

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
import br.com.mfsdevsys.productapi.modules.product.dto.ProductRequest;
import br.com.mfsdevsys.productapi.modules.product.dto.ProductResponse;
import br.com.mfsdevsys.productapi.modules.product.service.ProductService;

@RestController
@RequestMapping("api/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@PostMapping
	public ProductResponse postProduct( @RequestBody ProductRequest request) {
				
		return productService.save(request) ;
	
	}
	
	@PutMapping("{id}")
	public ProductResponse update(@RequestBody ProductRequest request, @PathVariable Integer id) {
		
		return productService.update(request, id) ;
	
	}
	
	@DeleteMapping("{id}")
	public SuccessResponse delete(@PathVariable Integer id) {
	    return productService.delete(id);
	}
	
	
	@GetMapping("{id}")
    public ProductResponse findById(@PathVariable Integer id) {
		
        return productService.findByIdResponse(id);
    }
	
	@GetMapping
	public List<ProductResponse> getAllProducts(){
		
		//List<productResponse> productList = this.productService.findAll().stream().map(ProductResponse::new).toList();
		
		return productService.findAll();
	}
	
	
	@GetMapping("name/{name}")
	public List<ProductResponse> findByName(@PathVariable String name){
		return productService.findByName(name);
	}
	
	@GetMapping("category/{categoryId}")
	public List<ProductResponse> findByCategoryId(@PathVariable Integer categoryId){
		return productService.findByCategoryId(categoryId);
	}
	
	@GetMapping("supplier/{supplierId}")
	public List<ProductResponse> findBySupplierId(@PathVariable Integer supplierId){
		return productService.findBySupplierId(supplierId);
	}
	/*
	 * todo : Criar as associações de product com brand
	 * 
	@GetMapping("brand/{brandId}")
	public List<ProductResponse> findByBrandId(@PathVariable Integer brandId){
		return productService.findBySupplierId(brandId);
	}
	*/
	
	
}
