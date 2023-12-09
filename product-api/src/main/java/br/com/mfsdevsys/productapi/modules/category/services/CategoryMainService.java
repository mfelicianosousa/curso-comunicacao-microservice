package br.com.mfsdevsys.productapi.modules.category.services;

import static org.springframework.util.ObjectUtils.isEmpty;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import br.com.mfsdevsys.productapi.config.exception.SuccessResponse;
import br.com.mfsdevsys.productapi.config.exception.ValidationException;
import br.com.mfsdevsys.productapi.modules.category.dto.CategoryMainRequest;
import br.com.mfsdevsys.productapi.modules.category.dto.CategoryMainResponse;
import br.com.mfsdevsys.productapi.modules.category.model.CategoryMain;
import br.com.mfsdevsys.productapi.modules.category.repository.CategoryMainRepository;

@Service
public class CategoryMainService {

	@Autowired
	private CategoryMainRepository categoryMainRepository;
	
	
	@Lazy
	private CategoryService categoryService;
	
	
	public CategoryMainResponse save( CategoryMainRequest request) {
		
		validateCategoryMainNameInformed( request );
		
		var categoryMain = categoryMainRepository.save(CategoryMain.of(request));
		
		return CategoryMainResponse.of( categoryMain );
	}
	
    public CategoryMainResponse update( CategoryMainRequest request, Integer id) {
		
		validateCategoryMainNameInformed( request );
		validateInformedId( id );
			
		var categoryMain = CategoryMain.of(request);
		categoryMain.setId(id);
		
		categoryMainRepository.save(categoryMain);
		
		return CategoryMainResponse.of( categoryMain );
	}
	
	
	public CategoryMainResponse findByIdResponse(Integer id) {
		return CategoryMainResponse.of( findById(id));
	}
	
	public CategoryMain findById(Integer id) {
	        validateInformedId(id);
	        return categoryMainRepository
	            .findById(id)
	            .orElseThrow(() -> new ValidationException("There's no category for the given ID."));
	}
	 
	public SuccessResponse delete(Integer id) {
	 	validateInformedId( id );
			if (categoryService.existsByCategoryMainId( id )) {
				// Você não pode excluir esta categoriaPrincipal porque ela já está definida por uma categoria
			   throw new ValidationException("You cannot delete this categoryMain because it's already defined by a category.");
		}
		
		categoryMainRepository.deleteById( id );
		return SuccessResponse.create("The categoryMain was deleted");
	}

	
    public List<CategoryMainResponse> findAll() {
    	return categoryMainRepository
	            .findAll()
	            .stream()
	            .map(CategoryMainResponse::of)
	            .collect(Collectors.toList());
	}
	
	public List<CategoryMainResponse> findByName(String name){
		return categoryMainRepository
				.findByNameIgnoreCaseContaining(name)
				.stream()
				.map(CategoryMain ->CategoryMainResponse.of(CategoryMain))
				.collect(Collectors.toList());
	}
	
	
	private void validateCategoryMainNameInformed(CategoryMainRequest request) {
		
		if (isEmpty(request.getName())) {
			// The category description/name was not informed.
			throw new ValidationException("A categoria principal nome não foi informada.") ;
		}
		
	}
	 
   private void validateInformedId(Integer id) {
        if (isEmpty(id)) {
            throw new ValidationException("The categoryMain ID must be informed.");
        }
    }

/*
	@Transactional(readOnly = true)
	public List<CategoryMainDTO> findAll(){
		
		List<CategoryMain> list = repository.findAll();
		
		// função lambda
		return list.stream().map( x -> new CategoryMainDTO( x )).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public CategoryMainDTO findById(Integer id) {
		
		Optional<CategoryMain> obj = repository.findById( id );
		CategoryMain entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
		
		return new CategoryMainDTO( entity );
	}

	@Transactional(readOnly = false)
	public CategoryMainDTO insert(CategoryMainDTO dto) {
		
		CategoryMain entity = new CategoryMain();
		
		copyDtoToEntity( dto, entity );
		
		entity = repository.save(entity);
		
		return new CategoryMainDTO(entity);
	}
			
	@Transactional(readOnly = false)
	public CategoryMainDTO update(Integer id, CategoryMainDTO dto) {
		try {
			CategoryMain entity = repository.getReferenceById( id );
			//
			copyDtoToEntity( dto, entity );
		;
			entity = repository.save(entity);
			//
			return new CategoryMainDTO(entity);
			
		} catch (EntityNotFoundException e) {
			// Id not found 
			throw new ResourceNotFoundException("Id não encontrado "+ id);
			
		}

	}

	public void delete(Integer id) {
		
		try {
		
		   repository.deleteById(id);
		
		}  catch (EntityNotFoundException e) {
			// Id not found 
			throw new ResourceNotFoundException("Id não encontrado "+ id);
			
		} catch (EmptyResultDataAccessException e) {
			// id not found
			throw new ResourceNotFoundException("Id não encontrado "+id);
			
		} catch (DataIntegrityViolationException e) {
			// Integrity violation
			throw new DatabaseException("Violação de Integridade");
		}
		
	}
	
	private void copyDtoToEntity(CategoryMainDTO dto, CategoryMain entity) {
		
		entity.setName( dto.getName());
		entity.setMetaLink( dto.getMetaLink());
		entity.setActive( dto.getActive());
		entity.setDescription( dto.getDescription());
		entity.setCreatedAt( dto.getCreatedAt());
		entity.setModifiedAt( dto.getModifiedAt());
			
	}
	
	*/
}
