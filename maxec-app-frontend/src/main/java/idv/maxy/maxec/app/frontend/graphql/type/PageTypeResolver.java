package idv.maxy.maxec.app.frontend.graphql.type;

import java.util.List;

import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLResolver;
import idv.maxy.maxec.biz.product.vo.ProductVO;
import idv.maxy.maxec.biz.vo.BasePageable;

@Component
public class PageTypeResolver implements GraphQLResolver<BasePageable> {

	public List<ProductVO> searchProductResult(BasePageable page) {
		return page.getContent();
	}
}
