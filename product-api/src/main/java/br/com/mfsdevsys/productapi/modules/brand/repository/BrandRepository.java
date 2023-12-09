package br.com.mfsdevsys.productapi.modules.brand.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mfsdevsys.productapi.modules.brand.model.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer>{

	List<Brand> findByNameIgnoreCaseContaining(String name);
}
