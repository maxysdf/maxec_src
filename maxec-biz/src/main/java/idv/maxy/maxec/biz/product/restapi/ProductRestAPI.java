package idv.maxy.maxec.biz.product.restapi;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import idv.maxy.maxec.biz.product.vo.BrandVO;
import idv.maxy.maxec.biz.product.vo.CategoryVO;
import idv.maxy.maxec.biz.product.vo.ProductPageParamVO;
import idv.maxy.maxec.biz.product.vo.ProductPageResultVO;
import idv.maxy.maxec.biz.product.vo.ProductVO;
import idv.maxy.maxec.biz.product.vo.TagVO;

public interface ProductRestAPI {
	
	@GetMapping("/product/{id}")
	public ProductVO findProductById(@PathVariable("id") String id);
	
	@GetMapping("/product/all")
	public List<ProductVO> findAllProduct();
	
	@GetMapping("/product/alias")
	public ProductVO findProductByAlias(@RequestParam("alias") String alias);
	
	@PostMapping("/products")
	public List<ProductVO> findProductByIds(@RequestBody List<String> ids);
	
	@PostMapping("/product/page")
	public ProductPageResultVO pageProduct(@RequestBody ProductPageParamVO in);

	@GetMapping("/category")
	public List<CategoryVO> findAllCategory();
	
	@GetMapping("/brand")
	public List<BrandVO> findAllBrand();
	
	@GetMapping("/tag/types")
	public Map<String, List<TagVO>> listTagGroupByTypes(@RequestParam("types") List<String> types);
	
	@PutMapping("/product")
	public String saveProduct(@RequestBody ProductVO v) throws Exception;
	
	@DeleteMapping("/product")
	public void deleteProduct(@RequestParam("id") String id) throws Exception;
	
	@GetMapping("/product-related")
	public List<ProductVO> findAllWithRelated();
	
}
