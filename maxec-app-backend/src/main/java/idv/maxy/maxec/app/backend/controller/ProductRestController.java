package idv.maxy.maxec.app.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import idv.maxy.maxec.biz.product.service.ProductService;
import idv.maxy.maxec.biz.product.vo.ProductVO;
import idv.maxy.maxec.core.util.StringUtil;

@RestController
@RequestMapping(value="/product",produces="application/json")
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	
	public static class SaveProductResponse {
		private String id;
		public static SaveProductResponse create(String id) {
			SaveProductResponse r = new SaveProductResponse();
			r.id = id;
			return r;
		}
		public String getId() {
			return id;
		}
	}
	
	public static class ProductResponse {
		private ProductVO product;
		public static ProductResponse create(ProductVO product) {
			ProductResponse r = new ProductResponse();
			r.product = product;
			return r;
		}
		public ProductVO getProduct() {
			return product;
		}
	}
	
	public static class PageProductResponse {
		private Page<ProductVO> page;
		public static PageProductResponse create(Page<ProductVO> page) {
			PageProductResponse r = new PageProductResponse();
			r.page = page;
			return r;
		}
		public Page<ProductVO> getPage() {
			return page;
		}
	}
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ProductResponse getProduct(@PathVariable("id") String id) {
		return ProductResponse.create(productService.findById(id));
	}
	
	@GetMapping("")
	public PageProductResponse pageProduct(
			@RequestParam(name="pn") Integer pageNo,
			@RequestParam(name="ps") Integer pageSize) {
		
		Page<ProductVO> page = productService.pageProduct(pageNo, pageSize);
		
		return PageProductResponse.create(page);
	}
	
	
	@PostMapping("")
	public SaveProductResponse saveProduct(@RequestBody ProductVO v) throws Exception {
		if(StringUtil.isNotEmptyOrNull(v.getId())) { throw new Exception("id is not empty"); }
		String id = productService.saveProduct(v);
		return SaveProductResponse.create(id);
	}
	
	@PutMapping("")
	public SaveProductResponse updateProduct(@RequestBody ProductVO v) throws Exception {
		if(StringUtil.isEmptyOrNull(v.getId())) { throw new Exception("id is empty"); }
		String id = productService.saveProduct(v);
		return SaveProductResponse.create(id);
	}
	
	
	
	
	
	
	
}
