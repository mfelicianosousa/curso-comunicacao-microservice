package br.com.mfsdevsys.productapi.modules.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mfsdevsys.productapi.modules.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

	List<Product> findByNameIgnoreCaseContaining(String name);
	List<Product> findByCategoryId(Integer id);
	List<Product> findBySupplierId(Integer id);
//	List<Product> findByBrandId(Integer id);
	
	Boolean existsByCategoryId(Integer categoryId);
	Boolean existsBySupplierId(Integer supplierId);
//	Boolean existsByBrand(Integer brandId);
	
}
