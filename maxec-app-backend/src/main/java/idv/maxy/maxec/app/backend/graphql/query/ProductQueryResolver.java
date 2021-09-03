package idv.maxy.maxec.app.backend.graphql.query;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import idv.maxy.maxec.app.backend.apiclient.ProductApiClient;
import idv.maxy.maxec.app.backend.apiclient.SearchApiClient;
import idv.maxy.maxec.app.backend.graphql.vo.ResponseVO;
import idv.maxy.maxec.app.backend.graphql.vo.ResponseWrapperVO;
import idv.maxy.maxec.biz.product.vo.ProductPageParamVO;
import idv.maxy.maxec.biz.product.vo.ProductPageResultVO;
import idv.maxy.maxec.biz.product.vo.ProductVO;
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
	public static class PageProductResponse extends ResponseWrapperVO {
		private ProductPageResultVO page;
		public ProductPageResultVO getPage() {
			return page;
		}
		public void setPage(ProductPageResultVO page) {
			this.page = page;
		}
	}
	
	public static class ProductResponse extends ResponseWrapperVO {
		private ProductVO product;
		public ProductVO getProduct() {
			return product;
		}
		public void setProduct(ProductVO product) {
			this.product = product;
		}
	}
	
	// methods --------------------------------------------------------------
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	public PageProductResponse pageProduct(ProductPageParamVO param) {
		String code = ResponseVO.CODE_SUCCESS;
		String errMsg = null;
		ProductPageResultVO result = null;
		try {
			result = productApiClient.pageProduct(param);
		} catch(Exception ex) {
			code = ResponseVO.CODE_UNKNOWN_ERROR;
			errMsg = ex.getMessage() != null ? ex.getMessage() : "unknown error";
			logger.error("search failed", ex);
		}
		
		PageProductResponse resp = new PageProductResponse();
		resp.setPage(result);
		resp.setResult(code, errMsg);
		return resp;
	}
	
	public ProductResponse findProductById(String id) {
		String code = ResponseVO.CODE_SUCCESS;
		String errMsg = null;
		ProductVO v = null;
		try {
			v = productApiClient.findProductById(id);
		} catch(Exception ex) {
			code = ResponseVO.CODE_UNKNOWN_ERROR;
			errMsg = ex.getMessage() != null ? ex.getMessage() : "unknown error";
			logger.error("search failed", ex);
		}
		
		ProductResponse resp = new ProductResponse();
		resp.setProduct(v);
		resp.setResult(code, errMsg);
		return resp;
	}
	
}
