package idv.maxy.maxec.biz.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import idv.maxy.maxec.biz.product.model.Product;

public interface ProductDao extends JpaRepository<Product, String> {

	
	
}
