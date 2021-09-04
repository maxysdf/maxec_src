package idv.maxy.maxec.app.backend.graphql.type;

import java.util.List;

import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLResolver;
import idv.maxy.maxec.biz.product.vo.BrandVO;
import idv.maxy.maxec.biz.product.vo.CategoryVO;
import idv.maxy.maxec.biz.product.vo.ProductVO;
import idv.maxy.maxec.biz.product.vo.TagVO;
import idv.maxy.maxec.biz.vo.BasePageable;

@Component
public class PageTypeResolver implements GraphQLResolver<BasePageable> {

	public List<ProductVO> pageProductResult(BasePageable page) {
		return page.getContent();
	}
	
	public List<CategoryVO> pageCategoryResult(BasePageable page) {
		return page.getContent();
	}
	
	public List<BrandVO> pageBrandResult(BasePageable page) {
		return page.getContent();
	}
	
	public List<TagVO> pageTagResult(BasePageable page) {
		return page.getContent();
	}
}
