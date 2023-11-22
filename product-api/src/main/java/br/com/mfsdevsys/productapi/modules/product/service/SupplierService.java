package br.com.mfsdevsys.productapi.modules.product.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mfsdevsys.productapi.modules.product.dto.BrandDTO;
import br.com.mfsdevsys.productapi.modules.product.dto.CategoryDTO;
import br.com.mfsdevsys.productapi.modules.product.dto.SupplierDTO;
import br.com.mfsdevsys.productapi.modules.product.model.Brand;
import br.com.mfsdevsys.productapi.modules.product.model.Category;
import br.com.mfsdevsys.productapi.modules.product.model.Supplier;
import br.com.mfsdevsys.productapi.modules.product.repository.SupplierRepository;
import br.com.mfsdevsys.productapi.modules.product.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierRepository repository;


	@Transactional(readOnly = true)
	public List<SupplierDTO> findAll(){
		
		List<Supplier> list = repository.findAll();
		
		// função lambda
		return list.stream().map( x -> new SupplierDTO( x )).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public SupplierDTO findById(Integer id) {
		
		Optional<Supplier> obj = repository.findById( id );
		Supplier entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
		
		return new SupplierDTO( entity );
	}
	
	@Transactional(readOnly = false)
	public SupplierDTO insert( SupplierDTO dto) {
		
		Supplier entity = new Supplier();
		
		entity.setName( dto.getName());
		entity.setActive( dto.getActive());

		entity = repository.save(entity);
		
		return new SupplierDTO(entity);
	}
	
	// GetReferenceById
		@Transactional(readOnly = false)
		public SupplierDTO update(Integer id, SupplierDTO dto) {
			try {
				Supplier entity = repository.getReferenceById( id );
				
				entity.setName( dto.getName());
				entity.setActive(dto.getActive());
				entity = repository.save(entity);
				return new SupplierDTO(entity);
				
			} catch (EntityNotFoundException e) {
				// Id not found 
				throw new ResourceNotFoundException("Id não encontrado "+ id);
				
			}

		}
}
