package br.com.mfsdevsys.productapi.modules.product.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mfsdevsys.productapi.modules.product.dto.BrandDTO;
import br.com.mfsdevsys.productapi.modules.product.model.Brand;
import br.com.mfsdevsys.productapi.modules.product.repository.BrandRepository;

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
}
