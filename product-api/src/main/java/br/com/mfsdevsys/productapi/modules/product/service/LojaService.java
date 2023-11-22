package br.com.mfsdevsys.productapi.modules.product.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mfsdevsys.productapi.modules.product.dto.LojaDTO;
import br.com.mfsdevsys.productapi.modules.product.dto.SupplierDTO;
import br.com.mfsdevsys.productapi.modules.product.model.Brand;
import br.com.mfsdevsys.productapi.modules.product.model.Loja;
import br.com.mfsdevsys.productapi.modules.product.model.Supplier;
import br.com.mfsdevsys.productapi.modules.product.repository.LojaRepository;
import br.com.mfsdevsys.productapi.modules.product.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class LojaService {

	@Autowired
	private LojaRepository repository;


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
}
