package idv.maxy.maxec.app.frontend.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import idv.maxy.maxec.app.frontend.vo.ResponseVO;
import idv.maxy.maxec.biz.product.service.ProductService;
import idv.maxy.maxec.biz.product.vo.BrandVO;
import idv.maxy.maxec.biz.product.vo.CategoryVO;
import idv.maxy.maxec.biz.product.vo.ProductVO;
import idv.maxy.maxec.biz.product.vo.TagVO;
import idv.maxy.maxec.biz.search.model.SearchProduct;
import idv.maxy.maxec.biz.search.service.SearchService;
import idv.maxy.maxec.core.util.StringUtil;

@RestController
@RequestMapping(value="/product", produces="application/json")
public class ProductRestController extends BaseRestController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private SearchService searchService;
	
	
	// product response ------------------------------------------------------------------------
	public static class ProductResponse extends ResponseVO {
		private ProductResult result;
		public ProductResponse(ProductResult result) { this.result = result; }
		public ProductResult getResult() {
			return result;
		}
	}
	
	public static class ProductResult {
		private ProductVO product;
		public ProductResult(ProductVO product) { this.product = product; }
		public ProductVO getProduct() {
			return product;
		}
	}
	
	// product list response ------------------------------------------------------------------------
	public static class ProductListResponse extends ResponseVO {
		private ProductListResult result;
		public ProductListResponse(ProductListResult result) { this.result = result; }
		public ProductListResult getResult() {
			return result;
		}
	}
	
	public static class ProductListResult {
		private List<ProductVO> list;
		public ProductListResult(List<ProductVO> list) { this.list = list; }
		public List<ProductVO> getList() {
			return list;
		}
	}
	
	// listCategory response ------------------------------------------------------------------------
	public static class ListCategoryResponse extends ResponseVO {
		private ListCategoryResult result;
		public ListCategoryResponse(ListCategoryResult result) {
			this.result = result;
		}
		public ListCategoryResult getResult() {
			return result;
		}
	}
	
	public static class ListCategoryResult {
		private List<CategoryVO> categories;
		public ListCategoryResult(List<CategoryVO> categories) { this.categories = categories; }
		public List<CategoryVO> getCategories() {
			return categories;
		}
	}
	
	// listBrand response ------------------------------------------------------------------------
	public static class ListBrandResponse extends ResponseVO {
		private ListBrandResult result;
		public ListBrandResponse(ListBrandResult result) {
			this.result = result;
		}
		public ListBrandResult getResult() {
			return result;
		}
	}
	
	public static class ListBrandResult {
		private List<BrandVO> brands;
		public ListBrandResult(List<BrandVO> brands) { this.brands = brands; }
		public List<BrandVO> getBrands() {
			return brands;
		}
	}
	
	// listTagByAllTypes response ------------------------------------------------------------------------
	public static class ListTagByAllTypesResponse extends ResponseVO {
		private ListTagByAllTypesResult result;
		
		public ListTagByAllTypesResult getResult() {
			return result;
		}
		public void setResult(ListTagByAllTypesResult result) {
			this.result = result;
		}
	}
	
	public static class ListTagByAllTypesResult {
		private List<ListTagByAllTypesResultTagType> types = new ArrayList<>();
		public List<ListTagByAllTypesResultTagType> getTypes() {
			return types;
		}
		public void setTypes(List<ListTagByAllTypesResultTagType> types) {
			this.types = types;
		}
	}
	
	public static class ListTagByAllTypesResultTagType {
		private String type;
		private List<TagVO> tags = new ArrayList<>();
		
		public List<TagVO> getTags() {
			return tags;
		}
		public void setTags(List<TagVO> tags) {
			this.tags = tags;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
	}
	
	// pageProduct param ------------------------------------------------------------------------
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
		ProductVO v = productService.findById(id);
		
		ProductResponse resp = new ProductResponse(new ProductResult(v));
		resp.success();
		return resp;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/alias")
	public ProductResponse getProductByAlias(@RequestParam("alias") String alias) {
		ProductVO v = productService.findByAlias(alias);
		
		ProductResponse resp = new ProductResponse(new ProductResult(v));
		resp.success();
		return resp;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("")
	public ProductListResponse listProduct() {
		List<ProductVO> list = productService.findAll();
		
		ProductListResponse resp = new ProductListResponse(new ProductListResult(list));
		resp.success();
		return resp;
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/category")
	public ListCategoryResponse listCategories() throws Exception {
		List<CategoryVO> cats = productService.findAllCategories();
		ListCategoryResponse resp = new ListCategoryResponse(new ListCategoryResult(cats));
		resp.success();
		return resp;
	}
	
	@GetMapping("/brand")
	public ListBrandResponse listBrands() throws Exception {
		List<BrandVO> brands = productService.findAllBrands();
		
		ListBrandResponse resp = new ListBrandResponse(new ListBrandResult(brands));
		resp.success();
		return resp;
	}
	
	@GetMapping("/tag/types")
	public ListTagByAllTypesResponse listTagByAllTypes(@RequestParam("types") String inTypes) {
		String[] types = StringUtil.parseArray(inTypes, ",");
		List<ListTagByAllTypesResultTagType> tagTypes = new ArrayList<>();
		Map<String, List<TagVO>> tagTypeMap = productService.listTagGroupByTypes(Arrays.asList(types));
		for(Entry<String, List<TagVO>> e : tagTypeMap.entrySet()) {
			ListTagByAllTypesResultTagType tType = new ListTagByAllTypesResultTagType();	
			tType.type = e.getKey();
			for(TagVO tTag : e.getValue()) {
				tType.getTags().add(tTag);
			}
			tagTypes.add(tType);
		}
		
		ListTagByAllTypesResponse resp = new ListTagByAllTypesResponse();
		resp.success();
		return resp;
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
