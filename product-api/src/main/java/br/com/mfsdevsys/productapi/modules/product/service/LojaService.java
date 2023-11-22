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
		
		entity.setName( dto.getName());
		entity.setFantasy( dto.getFantasy());
		entity.setCnpj(dto.getCnpj());
		entity.setActive( dto.getActive());

		entity = repository.save(entity);
		
		return new LojaDTO(entity);
	}
}
