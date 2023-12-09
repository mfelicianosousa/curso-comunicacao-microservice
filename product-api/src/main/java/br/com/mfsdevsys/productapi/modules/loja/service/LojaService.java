package br.com.mfsdevsys.productapi.modules.loja.service;

import static org.springframework.util.ObjectUtils.isEmpty;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mfsdevsys.productapi.config.exception.SuccessResponse;
import br.com.mfsdevsys.productapi.config.exception.ValidationException;
import br.com.mfsdevsys.productapi.modules.loja.dto.LojaRequest;
import br.com.mfsdevsys.productapi.modules.loja.dto.LojaResponse;
import br.com.mfsdevsys.productapi.modules.loja.model.Loja;
import br.com.mfsdevsys.productapi.modules.loja.repository.LojaRepository;

@Service
public class LojaService {

	@Autowired
	private LojaRepository lojaRepository;
	
	
	public LojaResponse findByIdResponse(Integer id) {
		return LojaResponse.of( findById(id));
	}
	
	public LojaResponse save(LojaRequest request) {
		validateLojaDataInformed(request);
		var loja = lojaRepository.save(Loja.of(request));
		return LojaResponse.of(loja);
	}
	
	public LojaResponse update(LojaRequest request, Integer id) {
		validateLojaDataInformed(request);
		var loja = Loja.of(request);
		loja.setId(id);
		lojaRepository.save(loja);
		return LojaResponse.of(loja);
	}
	public SuccessResponse delete(Integer id) {
		validateInformedId( id );
		
		lojaRepository.deleteById( id );
		return SuccessResponse.create("The Loja was deleted");
	}
	
	
	public Loja findById(Integer id) {
        validateInformedId(id);
        return lojaRepository
            .findById(id)
            .orElseThrow(() -> new ValidationException("There's no supplier for the given ID."));
    }
	
	public List<LojaResponse> findAll() {
		return lojaRepository
	          .findAll()
	          .stream()
	          .map(LojaResponse::of)
	          .collect(Collectors.toList());
	}

	public List<LojaResponse> findByName(String name){
		return lojaRepository
				.findByNameIgnoreCaseContaining(name)
				.stream()
				.map( loja ->LojaResponse.of( loja ))
				.collect(Collectors.toList());
	}
	
	private void validateInformedId(Integer id) {
		if (isEmpty(id)) {
	       throw new ValidationException("The Loja ID must be informed.");
	    }
	}
	
	private void validateLojaDataInformed(LojaRequest request) {
		if ( isEmpty(request.getName())) {
			throw new ValidationException("The loja name was not informed.");
		}
		
	}
	
	/*
	@Transactional(readOnly = true)
	public List<LojaDTO> findAll(){
		
		List<Loja> list = repository.findAll();
		
		// função lambda
		return list.stream().map( x -> new LojaDTO( x )).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public LojaDTO findById(Integer id) {
		
		Optional<Loja> obj = repository.findById( id );
		Loja entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
		
		return new LojaDTO( entity );
	}
	
	
	@Transactional(readOnly = false)
	public LojaDTO insert( LojaDTO dto) {
		
		Loja entity = new Loja();
		//
		entity.setName( dto.getName());
		entity.setFantasy( dto.getFantasy());
		entity.setCnpj( dto.getCnpj());
		entity.setInsc_estadual( dto.getInsc_estadual());
		entity.setEmail( dto.getEmail());
		entity.setPhone( dto.getPhone());
		entity.setPhone_celular( dto.getPhone_celular());
		entity.setCep( dto.getCep());
		entity.setBairro( dto.getBairro());
		entity.setMunicipio( dto.getMunicipio());
		entity.setLogradouro( dto.getLogradouro());
		entity.setNumero( dto.getNumero());
		entity.setComplemento( dto.getComplemento());
		entity.setEstado( dto.getEstado());
		entity.setActive( dto.getActive());
		//
		entity = repository.save(entity);
		//
		return new LojaDTO(entity);
	}
	
	@Transactional(readOnly = false)
	public LojaDTO update(Integer id, LojaDTO dto) {
		try {
			
			Loja entity = repository.getReferenceById( id );
			//
			entity.setName( dto.getName());
			entity.setFantasy( dto.getFantasy());
			entity.setCnpj( dto.getCnpj());
			entity.setInsc_estadual( dto.getInsc_estadual());
			entity.setEmail( dto.getEmail());
			entity.setPhone( dto.getPhone());
			entity.setPhone_celular( dto.getPhone_celular());
			entity.setCep( dto.getCep());
			entity.setBairro( dto.getBairro());
			entity.setMunicipio( dto.getMunicipio());
			entity.setLogradouro( dto.getLogradouro());
			entity.setNumero( dto.getNumero());
			entity.setComplemento( dto.getComplemento());
			entity.setEstado( dto.getEstado());
			entity.setActive(dto.getActive());
			//
			entity = repository.save(entity);
			//
			return new LojaDTO(entity);
			
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
