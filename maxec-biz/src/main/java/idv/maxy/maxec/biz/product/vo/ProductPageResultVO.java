package idv.maxy.maxec.biz.product.vo;

import java.util.List;

import idv.maxy.maxec.biz.vo.BasePage;

public class ProductPageResultVO extends BasePage<ProductVO> {
	public ProductPageResultVO() {
		super();
	}
	
	public ProductPageResultVO(List<ProductVO> content, 
			int pageSize, int pageNo, long total) {
		super(content, pageSize, pageNo, total);
	}

}
