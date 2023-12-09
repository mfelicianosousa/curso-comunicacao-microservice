package br.com.mfsdevsys.productapi.modules.brand.service;

import static org.springframework.util.ObjectUtils.isEmpty;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mfsdevsys.productapi.config.exception.SuccessResponse;
import br.com.mfsdevsys.productapi.config.exception.ValidationException;
import br.com.mfsdevsys.productapi.modules.brand.dto.BrandRequest;
import br.com.mfsdevsys.productapi.modules.brand.dto.BrandResponse;
import br.com.mfsdevsys.productapi.modules.brand.model.Brand;
import br.com.mfsdevsys.productapi.modules.brand.repository.BrandRepository;
import br.com.mfsdevsys.productapi.modules.category.dto.CategoryRequest;
import br.com.mfsdevsys.productapi.modules.category.dto.CategoryResponse;
import br.com.mfsdevsys.productapi.modules.category.model.Category;
import br.com.mfsdevsys.productapi.modules.product.service.ProductService;

@Service
public class BrandService {

	@Autowired
	private BrandRepository brandRepository;
	
//	@Autowired
//	private ProductService productService;
	
	public BrandResponse save(BrandRequest request) {
		validateBrandDataInformed(request);
		var brand = brandRepository.save( Brand.of(request));
		return BrandResponse.of(brand);
	}
	
	public BrandResponse update(BrandRequest request, Integer id) {
		
		validateBrandDataInformed(request);
		var brand =  Brand.of(request);
		brand.setId( id );
    	brandRepository.save(brand);
		
    	return BrandResponse.of(brand);
	}
	
	public SuccessResponse delete(Integer id) {
        validateInformedId(id);
        //
        // TODO: Voltar a Validar quando o brand estiver em produtos
        // if (productService.existsByBrand(id)) {
        //     throw new ValidationException("You cannot delete this brand because it's already defined by a product.");
        // }
        
        brandRepository.deleteById(id);
        return SuccessResponse.create("The category was deleted.");
	 }
	
	public BrandResponse findByIdResponse(Integer id) {
		return BrandResponse.of( findById(id) );
	}

	public Brand findById(Integer id) {
        validateInformedId(id);
        return brandRepository
            .findById(id)
            .orElseThrow(() -> new ValidationException("There's no brand for the given ID."));
    }
	
	public List<BrandResponse> findAll() {
	        return brandRepository
	            .findAll()
	            .stream()
	            .map(BrandResponse::of)
	            .collect(Collectors.toList());
	    }
	  
	public List<BrandResponse> findByName(String name){
		return brandRepository
				.findByNameIgnoreCaseContaining(name)
				.stream()
				.map( brand ->BrandResponse.of( brand ))
				.collect(Collectors.toList());
	}
	
	/***************
	 *  Validações 
	 ***************/
	
	
	private void validateBrandDataInformed(BrandRequest request) {
		if ( isEmpty(request.getName())) {
			throw new ValidationException("The supplier's name was not informed.");
		}
		
	}

	private void validateInformedId(Integer id) {
		if (isEmpty(id)) {
	       throw new ValidationException("The brand ID must be informed.");
	    }
	 }

	/*
	@Transactional(readOnly = true)
	public List<BrandDTO> findAll(){
		
		List<Brand> list = repository.findAll();
		
		// função lambda
		return list.stream().map( x -> new BrandDTO( x )).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public BrandDTO findById(Integer id) {
		
		Optional<Brand> obj = repository.findById( id );
		Brand entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
		
		return new BrandDTO( entity );
	}
	
	@Transactional(readOnly = false)
	public BrandDTO insert( BrandDTO dto) {
		
		Brand entity = new Brand();
		
		entity.setName( dto.getName());
		entity.setMeta_link( dto.getMeta_link());
		entity.setActive( dto.getActive());

		entity = repository.save(entity);
		
		return new BrandDTO(entity);
	}
	
	@Transactional(readOnly = false)
	public BrandDTO update(Integer id, BrandDTO dto) {
		try {
			Brand entity = repository.getReferenceById( id );
			
			entity.setName( dto.getName());
			entity.setMeta_link( dto.getMeta_link());
			entity.setActive( dto.getActive());
			entity = repository.save(entity);
			return new BrandDTO(entity);
			
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
}
