package idv.maxy.maxec.app.frontend.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import idv.maxy.maxec.app.frontend.controller.ProductRestController.ListTagByAllTypesResponse.TagType;
import idv.maxy.maxec.app.frontend.vo.ResponseVO;
import idv.maxy.maxec.biz.product.service.ProductService;
import idv.maxy.maxec.biz.product.vo.BrandVO;
import idv.maxy.maxec.biz.product.vo.CategoryVO;
import idv.maxy.maxec.biz.product.vo.ProductVO;
import idv.maxy.maxec.biz.product.vo.TagVO;
import idv.maxy.maxec.core.util.StringUtil;

@RestController
@RequestMapping(value="/product", produces="application/json")
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
	
	public static class ListCategoryResponse extends ResponseVO {
		private Result result;
		
		public static ListCategoryResponse create(List<CategoryVO> categories) {
			ListCategoryResponse r = new ListCategoryResponse();
			r.result = r.new Result();
			r.result.categories = categories;
			r.success();
			return r;
		}
		
		@Override 
		public Result getResult() { return result; }
		
		class Result {
			private List<CategoryVO> categories;
			public List<CategoryVO> getCategories() {
				return categories;
			}
		}
	}
	
	public static class ListBrandResponse extends ResponseVO {
		private Result result;
		
		public static ListBrandResponse create(List<BrandVO> brands) {
			ListBrandResponse r = new ListBrandResponse();
			r.result = r.new Result();
			r.result.brands = brands;
			r.success();
			return r;
		}
		
		@Override 
		public Result getResult() { return result; }
		
		class Result {
			private List<BrandVO> brands;
			public List<BrandVO> getBrands() {
				return brands;
			}
		}
	}
	
	public static class ListTagByAllTypesResponse extends ResponseVO {
		private Result result;
		
		public static ListTagByAllTypesResponse create(List<TagType> tagTypes) {
			ListTagByAllTypesResponse r = new ListTagByAllTypesResponse();
			r.result = new ListTagByAllTypesResponse.Result();
			r.result.types = tagTypes;
			r.success();
			return r;
		}
		
		@Override 
		public Result getResult() { return result; }
		
		static class Result {
			private List<TagType> types;
			public List<TagType> getTypes() {
				return types;
			}
		}
		
		static class TagType {
			private String type;
			private List<TagVO> tags = new ArrayList<>();
			public List<TagVO> getTags() {
				return tags;
			}
			public String getType() {
				return type;
			}
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
	
	@GetMapping("/category")
	public ListCategoryResponse listCategories() throws Exception {
		List<CategoryVO> cats = productService.findAllCategories();
		return ListCategoryResponse.create(cats);
	}
	
	@GetMapping("/brand")
	public ListBrandResponse listBrands() throws Exception {
		List<BrandVO> brands = productService.findAllBrands();
		return ListBrandResponse.create(brands);
	}
	
	
	@GetMapping("/tag/types")
	public ListTagByAllTypesResponse listTagByAllTypes(@RequestParam("types") String inTypes) {
		
		String[] types = StringUtil.parseArray(inTypes, ",");
		
		List<TagType> tagTypes = new ArrayList<>();
		Map<String, List<TagVO>> tagTypeMap = productService.listTagGroupByTypes(Arrays.asList(types));
		for(Entry<String, List<TagVO>> e : tagTypeMap.entrySet()) {
			ListTagByAllTypesResponse.TagType tType = new ListTagByAllTypesResponse.TagType();	
			tType.type = e.getKey();
			for(TagVO tTag : e.getValue()) {
				tType.getTags().add(tTag);
			}
			tagTypes.add(tType);
		}
		
		return ListTagByAllTypesResponse.create(tagTypes);
	}
	
}
