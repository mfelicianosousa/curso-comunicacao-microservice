package br.com.mfsdevsys.productapi.modules.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mfsdevsys.productapi.modules.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

}
