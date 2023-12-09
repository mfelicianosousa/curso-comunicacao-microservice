package br.com.mfsdevsys.productapi.modules.supplier.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mfsdevsys.productapi.modules.supplier.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier,Integer>{

	List<Supplier> findByNameIgnoreCaseContaining(String name);
	
}
