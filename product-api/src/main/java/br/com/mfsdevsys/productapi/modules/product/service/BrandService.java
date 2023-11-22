package br.com.mfsdevsys.productapi.modules.product.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mfsdevsys.productapi.modules.product.dto.BrandDTO;
import br.com.mfsdevsys.productapi.modules.product.dto.CategoryMainDTO;
import br.com.mfsdevsys.productapi.modules.product.model.Brand;
import br.com.mfsdevsys.productapi.modules.product.model.CategoryMain;
import br.com.mfsdevsys.productapi.modules.product.repository.BrandRepository;
import br.com.mfsdevsys.productapi.modules.product.service.exceptions.ResourceNotFoundException;

@Service
public class BrandService {

	@Autowired
	private BrandRepository repository;


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
}
