package idv.maxy.maxec.app.frontend.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
import idv.maxy.maxec.biz.search.model.SearchProduct;
import idv.maxy.maxec.biz.search.service.SearchService;
import idv.maxy.maxec.biz.search.vo.SearchProductParam;
import idv.maxy.maxec.core.util.StringUtil;

@RestController
@RequestMapping(value="/product", produces="application/json")
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private SearchService searchService;
	
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
	
	public static class PageProductParam {
		private String category;
		private String[] brandIds;
		private Integer minPrice;
		private Integer maxPrice;
		private List<PageProductTagParam> tags;
		private String sort;
		private Boolean sortAsc;
		private Integer pageNo;
		private Integer pageSize;
		
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String[] getBrandIds() {
			return brandIds;
		}
		public void setBrandIds(String[] brandIds) {
			this.brandIds = brandIds;
		}
		public Integer getMinPrice() {
			return minPrice;
		}
		public void setMinPrice(Integer minPrice) {
			this.minPrice = minPrice;
		}
		public Integer getMaxPrice() {
			return maxPrice;
		}
		public void setMaxPrice(Integer maxPrice) {
			this.maxPrice = maxPrice;
		}
		public List<PageProductTagParam> getTags() {
			return tags;
		}
		public void setTags(List<PageProductTagParam> tags) {
			this.tags = tags;
		}
		public String getSort() {
			return sort;
		}
		public void setSort(String sort) {
			this.sort = sort;
		}
		public Boolean getSortAsc() {
			return sortAsc;
		}
		public void setSortAsc(Boolean sortAsc) {
			this.sortAsc = sortAsc;
		}
		public Integer getPageNo() {
			return pageNo;
		}
		public void setPageNo(Integer pageNo) {
			this.pageNo = pageNo;
		}
		public Integer getPageSize() {
			return pageSize;
		}
		public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
		}
	}

	public static class PageProductTagParam {
		private String type;
		private String id;
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
	}
	

	
	
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id:[0-9\\-]+}")
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
	
	
	@PostMapping("/search")
	public SearchPage<SearchProduct> pageProduct(@RequestBody PageProductParam in) throws Exception {
		Integer minPrice = in.getMinPrice();
		Integer maxPrice = in.getMaxPrice();
		Integer pageNo = in.getPageNo();
		Integer pageSize = in.getPageSize();
		String sort = in.getSort();
		boolean sortAsc = Boolean.TRUE.equals(in.getSortAsc());
		
		if(pageNo == null) { throw new Exception("no page no"); }
		if(pageSize == null) { throw new Exception("no page size"); }
		
		Map<String, List<String>> tagTypeCodes = new LinkedHashMap<String, List<String>>();
		List<PageProductTagParam> inTags = in.getTags();
		if(inTags != null) {
			for(PageProductTagParam inTag : inTags) {
				tagTypeCodes.putIfAbsent(inTag.getType(), new ArrayList<>());
				tagTypeCodes.get(inTag.getType()).add(String.format("%s::%s", inTag.getType(), inTag.getId()));
			}
		}
		
		
		SearchPage<SearchProduct> page = searchService.searchProductForList(
				null, minPrice, maxPrice, tagTypeCodes, 
				pageNo, pageSize, sort, sortAsc);

		return page;
	}
	
	
}
