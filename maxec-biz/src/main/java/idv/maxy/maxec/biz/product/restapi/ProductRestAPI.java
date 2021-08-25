package idv.maxy.maxec.biz.product.restapi;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import idv.maxy.maxec.biz.product.vo.BrandVO;
import idv.maxy.maxec.biz.product.vo.CategoryVO;
import idv.maxy.maxec.biz.product.vo.ProductVO;
import idv.maxy.maxec.biz.product.vo.TagVO;

public interface ProductRestAPI {
	
	@GetMapping("/product/{id:[0-9a-f\\-]+}")
	public ProductVO findProductById(@PathVariable("id") String id);
	
	@GetMapping("/product")
	public List<ProductVO> findAllProduct();
	
	@GetMapping("/product/alias")
	public ProductVO findProductByAlias(@RequestParam("alias") String alias);
	
	@PostMapping("/products")
	public List<ProductVO> findProductByIds(@RequestBody List<String> ids);

	@GetMapping("/category")
	public List<CategoryVO> findAllCategory();
	
	@GetMapping("/brand")
	public List<BrandVO> findAllBrand();
	
	@GetMapping("/tag/types")
	public Map<String, List<TagVO>> listTagGroupByTypes(@RequestBody List<String> types);
}
