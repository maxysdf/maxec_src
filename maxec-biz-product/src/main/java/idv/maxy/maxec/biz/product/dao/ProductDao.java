package idv.maxy.maxec.biz.product.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import idv.maxy.maxec.biz.product.model.Product;

public interface ProductDao extends JpaRepository<Product, String> {

	/**
	 * 
	 * @param alias
	 * @return
	 */
	@Query(name="from Product p where p.alias = ?1 limit 1")
	public Optional<Product> findByAlias(String alias);
}
