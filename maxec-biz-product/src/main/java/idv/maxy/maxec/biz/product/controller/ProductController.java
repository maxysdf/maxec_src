package idv.maxy.maxec.biz.product.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import idv.maxy.maxec.biz.product.restapi.ProductRestAPI;
import idv.maxy.maxec.biz.product.service.ProductService;
import idv.maxy.maxec.biz.product.vo.BrandVO;
import idv.maxy.maxec.biz.product.vo.CategoryVO;
import idv.maxy.maxec.biz.product.vo.FindProductListParam;
import idv.maxy.maxec.biz.product.vo.ProductVO;
import idv.maxy.maxec.biz.product.vo.TagVO;

@RestController
public class ProductController implements ProductRestAPI {

	@Autowired
	private ProductService productService;

	@Override
	public ProductVO findProductById(String id) {
		return productService.findById(id);
	}

	@Override
	public List<ProductVO> findAllProduct() {
		return productService.findAll();
	}

	@Override
	public ProductVO findProductByAlias(String alias) {
		return productService.findByAlias(alias);
	}

	@Override
	public List<ProductVO> findProductByIds(List<String> ids) {
		return productService.findByIds(ids);
	}

	@Override
	public List<CategoryVO> findAllCategory() {
		return productService.findAllCategories();
	}

	@Override
	public List<BrandVO> findAllBrand() {
		return productService.findAllBrands();
	}

	@Override
	public Map<String, List<TagVO>> listTagGroupByTypes(List<String> types) {
		return productService.listTagGroupByTypes(types);
	}
	
	@Override
	public String saveProduct(ProductVO v) throws Exception {
		return productService.saveProduct(v);
	}
	
	@Override
	public List<ProductVO> findAllWithRelated() {
		return productService.findAllWithRelated();
	}
}
