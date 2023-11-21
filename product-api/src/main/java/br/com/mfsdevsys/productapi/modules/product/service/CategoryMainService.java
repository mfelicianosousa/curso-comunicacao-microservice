package br.com.mfsdevsys.productapi.modules.product.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mfsdevsys.productapi.modules.product.dto.CategoryMainDTO;
import br.com.mfsdevsys.productapi.modules.product.model.CategoryMain;
import br.com.mfsdevsys.productapi.modules.product.repository.CategoryMainRepository;

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

}
