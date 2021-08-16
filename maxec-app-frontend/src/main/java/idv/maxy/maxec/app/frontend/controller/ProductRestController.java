package idv.maxy.maxec.app.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import idv.maxy.maxec.biz.product.service.ProductService;
import idv.maxy.maxec.biz.product.vo.ProductVO;

@RestController
@RequestMapping(value="/product",produces="application/json")
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	
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
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ProductResponse getProduct(@PathVariable("id") String id) {
		return ProductResponse.create(productService.findById(id));
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/alias")
	public ProductResponse getProductByAlias(@RequestParam("alias") String alias) {
		ProductVO v = productService.findByAlias(alias);
		return ProductResponse.create(v);
	}
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("")
	public List<ProductVO> listProduct() {
		return productService.findAll();
	}
	
}
