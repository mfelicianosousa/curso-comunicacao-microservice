package br.com.mfsdevsys.productapi.modules.supplier.service;

import static org.springframework.util.ObjectUtils.isEmpty;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import br.com.mfsdevsys.productapi.config.exception.SuccessResponse;
import br.com.mfsdevsys.productapi.config.exception.ValidationException;
import br.com.mfsdevsys.productapi.modules.product.service.ProductService;
import br.com.mfsdevsys.productapi.modules.supplier.dto.SupplierDTO;
import br.com.mfsdevsys.productapi.modules.supplier.dto.SupplierRequest;
import br.com.mfsdevsys.productapi.modules.supplier.dto.SupplierResponse;
import br.com.mfsdevsys.productapi.modules.supplier.model.Supplier;
import br.com.mfsdevsys.productapi.modules.supplier.repository.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	@Lazy
	private ProductService productService;
	
	
	public SupplierResponse save(SupplierRequest request) {
		validateSupplierNameInformed(request);
		
		var supplier = supplierRepository.save(Supplier.of(request));
		return SupplierResponse.of(supplier);
	}
	
	public SupplierResponse update(SupplierRequest request, Integer id) {
		validateSupplierNameInformed(request);
	
		var supplier = Supplier.of(request);
		supplier.setId(id);
		supplierRepository.save(supplier);
		return SupplierResponse.of(supplier);
	}
	
	public SuccessResponse delete(Integer id) {
		validateInformedId( id );
		if (productService.existsBySupplierId( id )) {
		   // Você não pode excluir este fornecedor porque ele já está definido por um produto.
		   throw new ValidationException("You cannot delete this supplier because it's already defined by a product.");
		}
		supplierRepository.deleteById( id );
		return SuccessResponse.create("The supplier was deleted");
	}
	
	public SupplierResponse findByIdResponse(Integer id) {
		return SupplierResponse.of( findById(id) );
	}
	
	public Supplier findById(Integer id) {
        validateInformedId(id);
        return supplierRepository
            .findById(id)
            .orElseThrow(() -> new ValidationException("There's no supplier for the given ID."));
    }
	
	public List<SupplierResponse> findAll() {
	        return supplierRepository
	            .findAll()
	            .stream()
	            .map(SupplierResponse::of)
	            .collect(Collectors.toList());
	}
	
	public List<SupplierResponse> findByName(String name){
		return supplierRepository
				.findByNameIgnoreCaseContaining(name)
				.stream()
				.map(Supplier ->SupplierResponse.of(Supplier))
				.collect(Collectors.toList());
	}
	
	private void validateSupplierNameInformed(SupplierRequest request) {
		if ( isEmpty(request.getName())) {
			throw new ValidationException("The supplier's name was not informed.");
		}
		
	}
	
	private void validateInformedId(Integer id) {
	    if (isEmpty( id )) {
	        throw new ValidationException("The supplier ID must be informed.");
	    }
	}

	
	 
	 
	/*

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
	public Supplier ToEntity(SupplierDTO dto ) {
		
		Supplier entity = new Supplier();
		
		entity.setName( dto.getName());
		entity.setActive(dto.getActive());
		
		return entity;
	}
}
