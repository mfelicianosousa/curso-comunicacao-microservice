package br.com.mfsdevsys.productapi.modules.product.service;

import static org.springframework.util.ObjectUtils.isEmpty;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mfsdevsys.productapi.config.exception.SuccessResponse;
import br.com.mfsdevsys.productapi.config.exception.ValidationException;
import br.com.mfsdevsys.productapi.modules.category.dto.CategoryDTO;
import br.com.mfsdevsys.productapi.modules.category.model.Category;
import br.com.mfsdevsys.productapi.modules.category.repository.CategoryRepository;
import br.com.mfsdevsys.productapi.modules.category.services.CategoryService;
import br.com.mfsdevsys.productapi.modules.product.dto.ProductDTO;
import br.com.mfsdevsys.productapi.modules.product.dto.ProductRequest;
import br.com.mfsdevsys.productapi.modules.product.dto.ProductResponse;
import br.com.mfsdevsys.productapi.modules.product.model.Product;
import br.com.mfsdevsys.productapi.modules.product.repository.ProductRepository;
import br.com.mfsdevsys.productapi.modules.supplier.service.SupplierService;


@Service
public class ProductService {
	
	private static final Integer ZERO = 0;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private CategoryService categoryService;
	
	
	public ProductResponse save( ProductRequest request) {
		
		validateProductDataInformed(request);
		validateCategoryAndSupplierIdInformed(request);
		
					
		var category = categoryService.findById(request.getCategoryId());
		
		var supplier = supplierService.findById(request.getSupplierId());
		
		var product = productRepository.save( Product.of(request, supplier, category));
		
		return ProductResponse.of( product );
	}
	
	public ProductResponse update( ProductRequest request, Integer id) {
		
		validateProductDataInformed(request);
		validateInformedId( id );
		validateCategoryAndSupplierIdInformed(request);
							
		var category = categoryService.findById(request.getCategoryId());
		
		var supplier = supplierService.findById(request.getSupplierId());
		
		var product = Product.of(request, supplier, category);
		
		product.setId(id);
		
		productRepository.save( product );
		
		return ProductResponse.of( product );
	}
	
	public SuccessResponse delete(Integer id) {
		validateInformedId( id );
		productRepository.deleteById( id );
		return SuccessResponse.create("The product was deleted");
	}
	
	public ProductResponse findByIdResponse(Integer id) {
        return ProductResponse.of(findById(id));
    }
    
    public Product findById(Integer id) {
    	if (isEmpty(id)) {
			throw new ValidationException("The product id must be informed.");
		}
        return productRepository
            .findById(id)
            .orElseThrow(() -> new ValidationException("There's no product for the given ID."));
    }
	
    
	public List<ProductResponse> findAll(){
		return productRepository
				.findAll()
				.stream()
				.map(Product ->ProductResponse.of(Product))
				.collect(Collectors.toList());
	}
	
	
	public List<ProductResponse> findByName(String name){
		if (isEmpty(name)) {
			throw new ValidationException("The product name must be informed.");
		}
		
		return productRepository
				.findByNameIgnoreCaseContaining(name)
				.stream()
				.map(Product ->ProductResponse.of(Product))
				.collect(Collectors.toList());
	}

	public List<ProductResponse> findBySupplierId(Integer supplierId){
		if (isEmpty(supplierId)) {
			throw new ValidationException("The product supplier id must be informed.");
		}
		
		return productRepository
				.findBySupplierId(supplierId)
				.stream()
				.map(Product ->ProductResponse.of(Product))
				.collect(Collectors.toList());
	}
	
	public List<ProductResponse> findByCategoryId(Integer categoryId){
		if (isEmpty(categoryId)) {
			throw new ValidationException("The product category id must be informed.");
		}
		
		return productRepository
				.findByCategoryId(categoryId)
				.stream()
				.map(Product ->ProductResponse.of(Product))
				.collect(Collectors.toList());
	}
	
	public boolean existsByCategoryId(Integer categoryId) {
		
		return productRepository.existsByCategoryId(categoryId);
		
	}
	 

    public boolean existsBySupplierId(Integer supplierId) {
		
		return productRepository.existsBySupplierId(supplierId);
		
    }
    
    /******************
     *  Validações 
     * 
     ******************/
    private void validateInformedId(Integer id) {
        if (isEmpty(id)) {
            throw new ValidationException("The Product ID must be informed.");
        }
    }
    
	
	private void validateProductDataInformed(ProductRequest request) {
		
		if (isEmpty(request.getName())) {
			// The category description/name was not informed.
			throw new ValidationException("O produto nome não foi informada.") ;
		}
		
		if (isEmpty(request.getQuantityAvailable())) {
			// The category description/name was not informed.
			throw new ValidationException("The quantity should not be less or equal to zero.") ;
		}
		
		if (isEmpty(request.getQuantityAvailable() <= ZERO )) {
			// The category description/name was not informed.
			throw new ValidationException("The quantity should not be less or equal to zero.") ;
		}
			
	}
	
    private void validateCategoryAndSupplierIdInformed(ProductRequest request) {
		
		if (isEmpty(request.getCategoryId())) {
			// The category description/name was not informed.
			throw new ValidationException("A categoria não foi informada.") ;
		}
		
		if (isEmpty(request.getSupplierId())) {
			// The category description/name was not informed.
			throw new ValidationException("O fornecedor não foi informado.") ;
		}
		
	}
    
    
	
	
	/* TODO: Validar os BRANDS em product
	 *  
	public List<ProductResponse> findByBrandId(Integer brandId){
		if (isEmpty(brandId)) {
			throw new ValidationException("The product brand id must be informed.");
		}
		
		return productRepository
				.findByBrandId( brandId )
				.stream()
				.map(Product ->ProductResponse.of(Product))
				.collect(Collectors.toList());
	}
	
	
    
    public boolean existsByBrand(Integer brandId) {
		
		return productRepository.existsByBrand(brandId);
		
	}
    
    */
	


  
	
	/*
	
	@Transactional(readOnly = true)
	public Page<ProductDTO> findAllPaged(PageRequest pageRequest){
		
		Page<Product> list = repository.findAll(pageRequest);

		return list.map( x -> new ProductDTO( x ));
	}
	
	

	@Transactional(readOnly = true)
	public ProductDTO findById(Integer id) {
		
		Optional<Product> obj = repository.findById( id );
		Product entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
		
		return new ProductDTO( entity, entity.getCategories() );
	}
	
	@Transactional(readOnly = false)
	public ProductDTO insert( ProductDTO dto) {
		
		Product entity = new Product();
		copyDtoToEntity(dto, entity);

		entity = repository.save(entity);
		
		return new ProductDTO(entity);
	}

	// GetReferenceById
	@Transactional(readOnly = false)
	public ProductDTO update(Integer id, ProductDTO dto) {
		try {
			Product entity = repository.getReferenceById( id );
			copyDtoToEntity(dto, entity);

			entity = repository.save(entity);
			return new ProductDTO(entity);
			
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
	*/
	
	private void copyDtoToEntity(ProductDTO dto, Product entity) {
		
		entity.setName( dto.getName());
		entity.setMetaLink( dto.getMetaLink());
		entity.setDescription( dto.getDescription());
		entity.setCode( dto.getCode());
		entity.setEmphasis(dto.getEmphasis());
		entity.setControlStock(dto.getControlStock());
		entity.setSalePrice(dto.getSalePrice());
		entity.setQuantityAvailable( dto.getQuantityAvailable());
		entity.setImgURL(dto.getImgURL());
		entity.setActive( dto.getActive());
		
		entity.getCategories().clear();
		for (CategoryDTO categoryDTO: dto.getCategories()) {
			
			Category category = categoryRepository.getReferenceById(categoryDTO.getId());
			
			entity.getCategories().add(category);
		}
	}


	
	
}
