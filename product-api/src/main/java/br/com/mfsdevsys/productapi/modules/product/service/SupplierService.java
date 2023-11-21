package br.com.mfsdevsys.productapi.modules.product.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mfsdevsys.productapi.modules.product.dto.SupplierDTO;
import br.com.mfsdevsys.productapi.modules.product.model.Supplier;
import br.com.mfsdevsys.productapi.modules.product.repository.SupplierRepository;

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

}
