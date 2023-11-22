package br.com.mfsdevsys.productapi.modules.product.service;

import static org.springframework.util.ObjectUtils.isEmpty;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mfsdevsys.productapi.config.exception.ValidationException;
import br.com.mfsdevsys.productapi.modules.product.dto.CategoryDTO;
import br.com.mfsdevsys.productapi.modules.product.dto.CategoryDtoRequest;
import br.com.mfsdevsys.productapi.modules.product.dto.CategoryDtoResponse;
import br.com.mfsdevsys.productapi.modules.product.model.Category;
import br.com.mfsdevsys.productapi.modules.product.repository.CategoryRepository;
import br.com.mfsdevsys.productapi.modules.product.service.exceptions.DatabaseException;
import br.com.mfsdevsys.productapi.modules.product.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;


@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public Page<CategoryDTO> findAllPaged(PageRequest pageRequest){
		
		Page<Category> list = repository.findAll(pageRequest);

		return list.map( x -> new CategoryDTO( x ));
	}
	
	public CategoryDtoResponse save( CategoryDtoRequest request) {
		
		validateCategoryNameInformed( request );
		
		var category = repository.save(Category.of(request));
		
		return CategoryDtoResponse.of( category );
	}
	
	private void validateCategoryNameInformed(CategoryDtoRequest request) {
		
		if (isEmpty(request.getName())) {
			// The category description/name was not informed.
			throw new ValidationException("A categoria name não foi informada.") ;
		}
		
	}

	@Transactional(readOnly = true)
	public CategoryDTO findById(Integer id) {
		
		Optional<Category> obj = repository.findById( id );
		Category entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
		
		return new CategoryDTO( entity );
	}
	
	@Transactional(readOnly = false)
	public CategoryDTO insert( CategoryDTO dto) {
		
		Category entity = new Category();
		
		entity.setName( dto.getName());
		entity.setMeta_link( dto.getMeta_link());
		entity.setDescription( dto.getDescription());
		entity.setActive( dto.getActive());

		entity = repository.save(entity);
		
		return new CategoryDTO(entity);
	}

	// GetReferenceById
	@Transactional(readOnly = false)
	public CategoryDTO update(Integer id, CategoryDTO dto) {
		try {
			Category entity = repository.getReferenceById( id );
			
			entity.setName( dto.getName());
			entity.setDescription(dto.getDescription());
			entity.setMeta_link(dto.getMeta_link());
			entity.setActive(dto.getActive());
			entity = repository.save(entity);
			return new CategoryDTO(entity);
			
		} catch (EntityNotFoundException e) {
			// Id not found 
			throw new ResourceNotFoundException("Id não encontrado "+ id);
			
		}

	}
	
	public void delete(Integer id) {
		
		try {
		
		   repository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			// id not found
			throw new ResourceNotFoundException("Id não encontrado "+id);
			
		} catch (DataIntegrityViolationException e) {
			// Integrity violation
			throw new DatabaseException("Violação de Integridade");
		}
		
	}

	
	
}
