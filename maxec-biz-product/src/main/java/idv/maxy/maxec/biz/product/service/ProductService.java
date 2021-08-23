package idv.maxy.maxec.biz.product.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import idv.maxy.maxec.biz.product.vo.BrandVO;
import idv.maxy.maxec.biz.product.vo.CategoryVO;
import idv.maxy.maxec.biz.product.vo.ProductVO;
import idv.maxy.maxec.biz.product.vo.TagVO;

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
	
	public List<CategoryVO> findAllCategories();
	
	public List<BrandVO> findAllBrands();

	public Map<String, List<TagVO>> listTagGroupByTypes(List<String> types);
	
	public List<ProductVO> findByIds(List<String> ids);
	
}
