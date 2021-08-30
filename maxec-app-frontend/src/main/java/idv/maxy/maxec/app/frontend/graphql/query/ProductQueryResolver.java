package idv.maxy.maxec.app.frontend.graphql.query;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import idv.maxy.maxec.app.frontend.apiclient.ProductApiClient;
import idv.maxy.maxec.app.frontend.apiclient.SearchApiClient;
import idv.maxy.maxec.app.frontend.graphql.vo.ResponseVO;
import idv.maxy.maxec.app.frontend.graphql.vo.ResponseWrapperVO;
import idv.maxy.maxec.biz.product.vo.BrandVO;
import idv.maxy.maxec.biz.product.vo.CategoryVO;
import idv.maxy.maxec.biz.product.vo.ProductVO;
import idv.maxy.maxec.biz.product.vo.TagVO;
import idv.maxy.maxec.biz.search.vo.SearchProductParamVO;
import idv.maxy.maxec.biz.search.vo.SearchProductResultPage;
import idv.maxy.maxec.biz.vo.BasePage;
import idv.maxy.maxec.biz.vo.BasePageable;

@Component
public class ProductQueryResolver extends QueryResolver {
	private static final Logger logger = LoggerFactory.getLogger(ProductQueryResolver.class);
	
	@Autowired
	private ProductApiClient productApiClient;
	
	@Autowired
	private SearchApiClient searchApiClient;
	
	// response types ----------------------------------------------------------------
	public static class ProductResponse extends ResponseWrapperVO {
		private ProductVO product;
		public void setProduct(ProductVO product) {
			this.product = product;
		}
		public ProductVO getProduct() {
			return product;
		}
	}
	
	public static class TagGroup {
		private String type;
		private List<TagVO> tags;
		public List<TagVO> getTags() {
			return tags;
		}
		public String getType() {
			return type;
		}
		public void setTags(List<TagVO> tags) {
			this.tags = tags;
		}
		public void setType(String type) {
			this.type = type;
		}
	}
	
	public static class ListTagGroupResponse extends ResponseWrapperVO {
		private List<TagGroup> tagGroups;
		public List<TagGroup> getTagGroups() {
			return tagGroups;
		}
		public void setTagGroups(List<TagGroup> tagGroups) {
			this.tagGroups = tagGroups;
		}
	}
	
	public static class ListBrandResponse extends ResponseWrapperVO {
		private List<BrandVO> brands;
		public List<BrandVO> getBrands() {
			return brands;
		}
		public void setBrands(List<BrandVO> brands) {
			this.brands = brands;
		}
	}
	
	public static class ListCategoryResponse extends ResponseWrapperVO {
		private List<CategoryVO> categories;
		public List<CategoryVO> getCategories() {
			return categories;
		}
		public void setCategories(List<CategoryVO> categories) {
			this.categories = categories;
		}
	}
	
	public static class SearchProductResponse extends ResponseWrapperVO {
		private BasePageable page;
		public BasePageable getPage() {
			return page;
		}
		public void setPage(BasePageable page) {
			this.page = page;
		}
	}
	
	// methods --------------------------------------------------------------
	public ProductResponse findProductById(String id) {
		String code = ResponseVO.CODE_SUCCESS;
		String errMsg = null;
		ProductVO v = null;
		try {
			v = productApiClient.findProductById(id);
		} catch(Exception ex) {
			code = ResponseVO.CODE_UNKNOWN_ERROR;
			errMsg = ex.getMessage() != null ? ex.getMessage() : "unknown error";
		}
		
		ProductResponse resp = new ProductResponse();
		resp.setProduct(v);
		resp.setResult(code, errMsg);
		return resp;
	}
	
	public ProductResponse findProductByAlias(String alias) {
		String code = ResponseVO.CODE_SUCCESS;
		String errMsg = null;
		ProductVO v = null;
		try {
			v = productApiClient.findProductByAlias(alias);
		} catch(Exception ex) {
			code = ResponseVO.CODE_UNKNOWN_ERROR;
			errMsg = ex.getMessage() != null ? ex.getMessage() : "unknown error";
		}
		
		ProductResponse resp = new ProductResponse();
		resp.setProduct(v);
		resp.setResult(code, errMsg);
		return resp;
	}
	
	public ListTagGroupResponse listTagGroupByTypes(ArrayList<String> types) {
		String code = ResponseVO.CODE_SUCCESS;
		String errMsg = null;
		List<TagGroup> tagGroups = new ArrayList<>();
		try {
			Map<String, List<TagVO>> map = productApiClient.listTagGroupByTypes(types);
			map.forEach((t,l) -> {
				TagGroup g = new TagGroup();
				g.setType(t);
				g.setTags(l);
				tagGroups.add(g);
			}); 
			
		} catch(Exception ex) {
			code = ResponseVO.CODE_UNKNOWN_ERROR;
			errMsg = ex.getMessage() != null ? ex.getMessage() : "unknown error";
		}
		
		ListTagGroupResponse resp = new ListTagGroupResponse();
		resp.setTagGroups(tagGroups);
		resp.setResult(code, errMsg);
		return resp;
	}
	
	/**
	 * 
	 * @return
	 */
	public ListBrandResponse listBrands() {
		String code = ResponseVO.CODE_SUCCESS;
		String errMsg = null;
		List<BrandVO> brands = null;
		try {
			brands = productApiClient.findAllBrand();
		} catch(Exception ex) {
			code = ResponseVO.CODE_UNKNOWN_ERROR;
			errMsg = ex.getMessage() != null ? ex.getMessage() : "unknown error";
		}
		
		ListBrandResponse resp = new ListBrandResponse();
		resp.setBrands(brands);
		resp.setResult(code, errMsg);
		return resp;
	}
	
	/**
	 * 
	 * @return
	 */
	public ListCategoryResponse listCategories() {
		String code = ResponseVO.CODE_SUCCESS;
		String errMsg = null;
		List<CategoryVO> cats = null;
		try {
			cats = productApiClient.findAllCategory();
		} catch(Exception ex) {
			code = ResponseVO.CODE_UNKNOWN_ERROR;
			errMsg = ex.getMessage() != null ? ex.getMessage() : "unknown error";
		}
		
		ListCategoryResponse resp = new ListCategoryResponse();
		resp.setCategories(cats);
		resp.setResult(code, errMsg);
		return resp;
	}
	
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	public SearchProductResponse searchProduct(SearchProductParamVO param) {
		String code = ResponseVO.CODE_SUCCESS;
		String errMsg = null;
		BasePage<ProductVO> vpage = null;
		try {
			SearchProductResultPage spage = searchApiClient.searchProductForList(param);
			
			// get product ids from page
			List<String> productIds = spage.getContent().stream().map(sh->sh.getId()).collect(toList());
			Map<String, ProductVO> vmap = productApiClient.findProductByIds(productIds).stream().collect(Collectors.toMap(ProductVO::getId, p->p));
			List<ProductVO> list = spage.getContent().stream().map((sh) -> vmap.get(sh.getId())).collect(toList());
			
			// construct
			vpage = new BasePage<>(list, spage.getSize(), spage.getNumber(), spage.getTotalElements());
		} catch(Exception ex) {
			code = ResponseVO.CODE_UNKNOWN_ERROR;
			errMsg = ex.getMessage() != null ? ex.getMessage() : "unknown error";
			logger.error("search failed", ex);
		}
		
		SearchProductResponse resp = new SearchProductResponse();
		resp.setPage(vpage);
		resp.setResult(code, errMsg);
		return resp;
	}
	
}
