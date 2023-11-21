package br.com.mfsdevsys.productapi.modules.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mfsdevsys.productapi.modules.product.model.CategoryMain;

public interface CategoryMainRepository extends JpaRepository<CategoryMain,Integer> {

}
