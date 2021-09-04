package idv.maxy.maxec.biz.product.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import idv.maxy.maxec.biz.product.restapi.ProductRestAPI;
import idv.maxy.maxec.biz.product.service.ProductService;
import idv.maxy.maxec.biz.product.vo.BrandPageParamVO;
import idv.maxy.maxec.biz.product.vo.BrandPageResultVO;
import idv.maxy.maxec.biz.product.vo.BrandVO;
import idv.maxy.maxec.biz.product.vo.CategoryPageParamVO;
import idv.maxy.maxec.biz.product.vo.CategoryPageResultVO;
import idv.maxy.maxec.biz.product.vo.CategoryVO;
import idv.maxy.maxec.biz.product.vo.FindProductListParam;
import idv.maxy.maxec.biz.product.vo.ProductPageParamVO;
import idv.maxy.maxec.biz.product.vo.ProductPageResultVO;
import idv.maxy.maxec.biz.product.vo.ProductVO;
import idv.maxy.maxec.biz.product.vo.TagPageParamVO;
import idv.maxy.maxec.biz.product.vo.TagPageResultVO;
import idv.maxy.maxec.biz.product.vo.TagVO;
import idv.maxy.maxec.core.util.StringUtil;

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
	
	@Override
	public void deleteProduct(String id) throws Exception {
		productService.deleteProduct(id);
	}

	@Override
	public ProductPageResultVO pageProduct(ProductPageParamVO in) {
		Page<ProductVO> vpage = productService.pageProduct(
				in.getKeywords(), in.getPageNo(), in.getPageSize());
		
		ProductPageResultVO v = new ProductPageResultVO(vpage.getContent(), 
				in.getPageSize(), in.getPageNo(), 
				vpage.getTotalElements());
		List<ProductVO> l = v.getContent();
		
		return v;
	}
	
	@Override
	public BrandPageResultVO pageBrand(BrandPageParamVO in) {
		Page<BrandVO> vpage =  productService.pageBrand(
				in.getKeywords(), in.getPageNo(), in.getPageSize());
		
		return new BrandPageResultVO(vpage.getContent(), 
				in.getPageSize(), in.getPageNo(), 
				vpage.getTotalElements());
	}
	
	
	@Override
	public CategoryPageResultVO pageCategory(CategoryPageParamVO in) {
		Page<CategoryVO> vpage =  productService.pageCategory(
				in.getKeywords(), in.getPageNo(), in.getPageSize());
		
		return new CategoryPageResultVO(vpage.getContent(), 
				in.getPageSize(), in.getPageNo(), 
				vpage.getTotalElements());
	}
	@Override
	public TagPageResultVO pageTag(TagPageParamVO in) {
		Page<TagVO> vpage =  productService.pageTag(
				in.getKeywords(), in.getPageNo(), in.getPageSize());
		
		return new TagPageResultVO(vpage.getContent(), 
				in.getPageSize(), in.getPageNo(), 
				vpage.getTotalElements());
	}
	
	
}
