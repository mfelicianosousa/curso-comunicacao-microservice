package br.com.mfsdevsys.productapi.modules.product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mfsdevsys.productapi.modules.product.dto.ProductDTO;
import br.com.mfsdevsys.productapi.modules.product.model.Product;
import br.com.mfsdevsys.productapi.modules.product.repository.ProductRepository;
import br.com.mfsdevsys.productapi.modules.product.service.exceptions.DatabaseException;
import br.com.mfsdevsys.productapi.modules.product.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
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
		
		//entity.setName( dto.getName());
		//entity.setMeta_link( dto.getMeta_link());
		//entity.setDescription( dto.getDescription());
		//entity.setActive( dto.getActive());

		entity = repository.save(entity);
		
		return new ProductDTO(entity);
	}

	// GetReferenceById
	@Transactional(readOnly = false)
	public ProductDTO update(Integer id, ProductDTO dto) {
		try {
			Product entity = repository.getReferenceById( id );
			
			//entity.setName( dto.getName());
			//entity.setDescription(dto.getDescription());
			//entity.setMeta_link(dto.getMeta_link());
			//entity.setActive(dto.getActive());
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

	
	
}
