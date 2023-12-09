package br.com.mfsdevsys.productapi.modules.loja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mfsdevsys.productapi.modules.loja.model.Loja;

public interface LojaRepository extends JpaRepository<Loja, Integer>{

	List<Loja> findByNameIgnoreCaseContaining(String name);
}
