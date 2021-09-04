package idv.maxy.maxec.biz.product.vo;

import java.util.List;

import idv.maxy.maxec.biz.vo.BasePage;

public class BrandPageResultVO extends BasePage<BrandVO> {
	public BrandPageResultVO() {
		super();
	}
	
	public BrandPageResultVO(List<BrandVO> content, 
			int pageSize, int pageNo, long total) {
		super(content, pageSize, pageNo, total);
	}
}