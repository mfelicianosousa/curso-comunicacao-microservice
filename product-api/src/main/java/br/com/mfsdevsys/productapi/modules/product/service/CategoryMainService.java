package br.com.mfsdevsys.productapi.modules.product.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mfsdevsys.productapi.modules.product.dto.CategoryMainDTO;
import br.com.mfsdevsys.productapi.modules.product.model.CategoryMain;
import br.com.mfsdevsys.productapi.modules.product.repository.CategoryMainRepository;
import br.com.mfsdevsys.productapi.modules.product.service.exceptions.DatabaseException;
import br.com.mfsdevsys.productapi.modules.product.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryMainService {

	@Autowired
	private CategoryMainRepository repository;


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
		entity.setName( dto.getName());
		entity.setMeta_link( dto.getMeta_link());
		entity.setActive( dto.getActive());
		entity.setDescription( dto.getDescription());
		entity = repository.save(entity);
		
		return new CategoryMainDTO(entity);
	}
	
	@Transactional(readOnly = false)
	public CategoryMainDTO update(Integer id, CategoryMainDTO dto) {
		try {
			CategoryMain entity = repository.getReferenceById( id );
			//
			entity.setName( dto.getName());
			entity.setMeta_link(dto.getMeta_link());
			entity.setDescription(dto.getDescription());
			entity.setActive(dto.getActive());
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
}
