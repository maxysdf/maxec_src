package idv.maxy.maxec.app.backend.graphql.mutation;

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
import idv.maxy.maxec.biz.product.vo.ProductVO;
import idv.maxy.maxec.biz.search.vo.SearchProductParamVO;
import idv.maxy.maxec.biz.search.vo.SearchProductResultPage;
import idv.maxy.maxec.biz.vo.BasePage;

@Component
public class ProductMutationResolver extends MutationResolver {
	private static final Logger logger = LoggerFactory.getLogger(ProductMutationResolver.class);
	
	@Autowired
	private ProductApiClient productApiClient;
	
	// response ----------------------------------------
	public class ProductResponse extends ResponseWrapperVO {
		
	}
	
	// method ----------------------------------------
	/**
	 * 
	 * @param param
	 * @return
	 */
	public ProductResponse saveProduct(ProductVO product) {
		String code = ResponseVO.CODE_SUCCESS;
		String errMsg = null;
		try {
			productApiClient.saveProduct(product);
		} catch(Exception ex) {
			code = ResponseVO.CODE_UNKNOWN_ERROR;
			errMsg = ex.getMessage() != null ? ex.getMessage() : "unknown error";
			logger.error("save failed", ex);
		}
		
		ProductResponse resp = new ProductResponse();
		resp.setResult(code, errMsg);
		return resp;
	}
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	public ProductResponse deleteProduct(String id) {
		String code = ResponseVO.CODE_SUCCESS;
		String errMsg = null;
		try {
			productApiClient.deleteProduct(id);
		} catch(Exception ex) {
			code = ResponseVO.CODE_UNKNOWN_ERROR;
			errMsg = ex.getMessage() != null ? ex.getMessage() : "unknown error";
			logger.error("delete failed", ex);
		}
		
		ProductResponse resp = new ProductResponse();
		resp.setResult(code, errMsg);
		return resp;
	}
}
