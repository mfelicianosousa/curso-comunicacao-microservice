package br.com.mfsdevsys.productapi.modules.product.service;

import static org.springframework.util.ObjectUtils.isEmpty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mfsdevsys.productapi.config.exception.ValidationException;
import br.com.mfsdevsys.productapi.modules.product.dto.CategoryDTO;
import br.com.mfsdevsys.productapi.modules.product.dto.CategoryDtoRequest;
import br.com.mfsdevsys.productapi.modules.product.dto.CategoryDtoResponse;
import br.com.mfsdevsys.productapi.modules.product.model.Category;
import br.com.mfsdevsys.productapi.modules.product.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll(){
		List<Category> list = categoryRepository.findAll();
		
		
		/* Retornando uma lista
		 * List<CategoryDTO> listDto = new ArrayList<>();
		for (Category category : list) {
			listDto.add(new CategoryDTO(category));
		}
		
		return listDto;
		*/
		
		// função lambada
		return list.stream().map( x -> new CategoryDTO( x )).collect(Collectors.toList());
	}
	
	public CategoryDtoResponse save( CategoryDtoRequest request) {
		
		validateCategoryNameInformed( request );
		
		var category = categoryRepository.save(Category.of(request));
		
		return CategoryDtoResponse.of( category );
	}
	
	private void validateCategoryNameInformed(CategoryDtoRequest request) {
		
		if (isEmpty(request.getName())) {
			// The category description/name was not informed.
			throw new ValidationException("A categoria name não foi informada.") ;
		}
		
	}

}
