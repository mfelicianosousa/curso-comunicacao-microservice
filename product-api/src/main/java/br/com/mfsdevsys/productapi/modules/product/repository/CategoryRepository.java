package br.com.mfsdevsys.productapi.modules.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mfsdevsys.productapi.modules.product.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
