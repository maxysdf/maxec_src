package idv.maxy.maxec.biz.product.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import idv.maxy.maxec.biz.product.model.Product;

public interface ProductDao extends JpaRepository<Product, String> {

	/**
	 * 
	 * @param alias
	 * @return
	 */
	@Query(value="from Product p where p.alias = :alias")
	public Optional<Product> findByAlias(@Param("alias") String alias);
	
	
	@Query(value="from Product p "
			+ " left outer join fetch p.brand b"
			+ " left outer join fetch p.productCategoryMaps pcm "
			+ " left outer join fetch pcm.category c"
			+ " left outer join fetch p.productTagMaps ptm "
			+ " left outer join fetch ptm.tag t ")
	public List<Product> findAllWithRelated();
}
