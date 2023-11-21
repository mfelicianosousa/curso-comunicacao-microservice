package br.com.mfsdevsys.productapi.modules.product.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mfsdevsys.productapi.modules.product.dto.LojaDTO;
import br.com.mfsdevsys.productapi.modules.product.model.Loja;
import br.com.mfsdevsys.productapi.modules.product.repository.LojaRepository;

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
}
