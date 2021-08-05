package idv.maxy.maxec.app.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idv.maxy.maxec.biz.product.service.ProductService;
import idv.maxy.maxec.biz.product.vo.ProductVO;

@RestController
@RequestMapping("/product")
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ProductVO getProduct(@PathVariable("id") String id) {
		return productService.findById(id);
	}
	
}
