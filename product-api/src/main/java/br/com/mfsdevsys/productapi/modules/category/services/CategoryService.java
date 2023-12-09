package br.com.mfsdevsys.productapi.modules.category.services;

import static org.springframework.util.ObjectUtils.isEmpty;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import br.com.mfsdevsys.productapi.config.exception.SuccessResponse;
import br.com.mfsdevsys.productapi.config.exception.ValidationException;
import br.com.mfsdevsys.productapi.modules.category.dto.CategoryDTO;
import br.com.mfsdevsys.productapi.modules.category.dto.CategoryRequest;
import br.com.mfsdevsys.productapi.modules.category.dto.CategoryResponse;
import br.com.mfsdevsys.productapi.modules.category.model.Category;
import br.com.mfsdevsys.productapi.modules.category.repository.CategoryRepository;
import br.com.mfsdevsys.productapi.modules.product.service.ProductService;


@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Lazy
	private ProductService productService;
	
	@Autowired
	private CategoryMainService categoryMainService;

	public CategoryResponse save( CategoryRequest request) {
		
		validateCategoryDataInformed( request );
		validateCategoryMainInformed( request );
		
		var categoryMain = categoryMainService.findById( request.getMainId());
		
		var category = categoryRepository.save(Category.of(request, categoryMain));
		
		return CategoryResponse.of( category );
	}
	
	
	public CategoryResponse update(CategoryRequest request, Integer id) {
		
		validateCategoryDataInformed(request);
		validateInformedId( id );
	   
		var categoryMain = categoryMainService.findById( request.getMainId());
		var category = Category.of(request, categoryMain);
		category.setId(id);
		categoryRepository.save(category);
		return CategoryResponse.of(category);
	}
	
	
	public SuccessResponse delete(Integer id) {
		validateInformedId( id );
		if (productService.existsByCategoryId( id )) {
		   throw new ValidationException("You cannot delete this category because it's already defined by a product.");
		}
		categoryRepository.deleteById( id );
		return SuccessResponse.create("The category was deleted");
	}
	
	public CategoryResponse findByIdResponse(Integer id) {
		return CategoryResponse.of( findById(id));
	}
	
	 public Category findById(Integer id) {
	        validateInformedId(id);
	        return categoryRepository
	            .findById(id)
	            .orElseThrow(() -> new ValidationException("There's no category for the given ID."));
	    }	
	
	public List<CategoryResponse> findAll(){
		return categoryRepository
				.findAll()
				.stream()
				.map(Category ->CategoryResponse.of(Category))
				.collect(Collectors.toList());
	}
	
	public List<CategoryResponse> findByName(String name){
		
		if (isEmpty(name)) {
			throw new ValidationException("The category name must be informed");	
		}
		
		return categoryRepository
				.findByNameIgnoreCaseContaining(name)
				.stream()
				.map(Category ->CategoryResponse.of(Category))
				.collect(Collectors.toList());
	}
	
	
	private void validateCategoryDataInformed(CategoryRequest request) {
		
		if (isEmpty(request.getName())) {
			// The category description/name was not informed.
			throw new ValidationException("A categoria nome não foi informada.") ;
		}
		
		if (isEmpty(request.getMetaLink())) {
			// The category description/name was not informed.
			throw new ValidationException("A categoria meta_link não foi informada.") ;
		}
		
	}
	
    private void validateCategoryMainInformed(CategoryRequest request) {
		
		if (isEmpty(request.getMainId())) {
			// The category description/name was not informed.
			throw new ValidationException("A categoria main não foi informada.") ;
		}
		
	}
	
   
    
    public List<CategoryResponse> findByCategoryMainId(Integer categoryMainId) {
        if (isEmpty(categoryMainId)) {
            throw new ValidationException("The product' categoryMain ID name must be informed.");
        }
        return categoryRepository
            .findByCategoryMainId(categoryMainId)
            .stream()
            .map(CategoryResponse::of)
            .collect(Collectors.toList());
    }
    
    


    private void validateInformedId(Integer id) {
        if (isEmpty(id)) {
            throw new ValidationException("The category ID must be informed.");
        }
    }
    
    public Boolean existsByCategoryMainId(Integer categoryMainId) {
        return categoryRepository.existsByCategoryMainId(categoryMainId);
    }

	/*
	
	@Transactional(readOnly = true)
	public Page<CategoryDTO> findAllPaged(PageRequest pageRequest){
		
		Page<Category> list = repository.findAll(pageRequest);

		return list.map( x -> new CategoryDTO( x ));
	}

	@Transactional(readOnly = true)
	public List<CategoryResponse> findByName(String name){
		
		if (isEmpty(name)) {
			throw new ValidationException("The category description must be informed.");
			
		}
		return repository.findByNameIgnoreCaseContaining( name )
				.stream()
				.map( category -> CategoryResponse.of(category))
                .collect(Collectors.toList());	
		
		
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
		
		CopyDtoToEntity(dto, entity);
		
		entity = repository.save(entity);
		
		return new CategoryDTO(entity);
	}

	

	// GetReferenceById
	@Transactional(readOnly = false)
	public CategoryDTO update(Integer id, CategoryDTO dto) {
		try {
			Category entity = repository.getReferenceById( id );
			CopyDtoToEntity(dto, entity);
			
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
	
	private void CopyDtoToEntity(CategoryDTO dto, Category entity) {
		
		entity.setName( dto.getName());
		entity.setMetaLink( dto.getMetaLink());
		entity.setDescription( dto.getDescription());
		entity.setActive( dto.getActive());
		entity.setCreatedAt(dto.getCreatedAt());
		entity.setModifiedAt( dto.getModifiedAt());

	}
	*/
    
	public Category ToEntity(CategoryDTO dto) {
		
		Category entity = new Category();
		
		entity.setId(dto.getId());
		entity.setName( dto.getName());
		entity.setMetaLink( dto.getMetaLink());
		entity.setDescription( dto.getDescription());
		entity.setActive( dto.getActive());
		entity.setCreatedAt(dto.getCreatedAt());
		entity.setModifiedAt( dto.getModifiedAt());
		
		return entity;
	}

	


	
}
