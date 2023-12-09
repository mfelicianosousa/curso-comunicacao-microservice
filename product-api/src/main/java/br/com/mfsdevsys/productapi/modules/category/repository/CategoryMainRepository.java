package br.com.mfsdevsys.productapi.modules.category.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mfsdevsys.productapi.modules.category.model.CategoryMain;

public interface CategoryMainRepository extends JpaRepository<CategoryMain,Integer> {

	List<CategoryMain> findByNameIgnoreCaseContaining(String name);
}
