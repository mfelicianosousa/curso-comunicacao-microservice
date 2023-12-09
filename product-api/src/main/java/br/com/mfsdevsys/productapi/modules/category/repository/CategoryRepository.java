package br.com.mfsdevsys.productapi.modules.category.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mfsdevsys.productapi.modules.category.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>{

	List<Category> findByNameIgnoreCaseContaining(String name);
	List<Category> findByCategoryMainId(Integer categoryMainId );
	Boolean existsByCategoryMainId(Integer id);
}
