package idv.maxy.maxec.biz.product.service;

import java.util.List;

import org.springframework.data.domain.Page;

import idv.maxy.maxec.biz.product.vo.ProductVO;

/**
 * 
 * @author Max Chen
 *
 */
public interface ProductService {
	
	public ProductVO findById(String id);
	
	public List<ProductVO> findAll();
	
	public ProductVO findByAlias(String alias);
	
	public String saveProduct(ProductVO v);
	
	public Page<ProductVO> pageProduct(int pageNo, int pageSize);

}
