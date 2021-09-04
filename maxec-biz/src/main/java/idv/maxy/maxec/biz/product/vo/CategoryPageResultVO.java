package idv.maxy.maxec.biz.product.vo;

import java.util.List;

import idv.maxy.maxec.biz.vo.BasePage;

public class CategoryPageResultVO extends BasePage<CategoryVO> {
	public CategoryPageResultVO() {
		super();
	}
	
	public CategoryPageResultVO(List<CategoryVO> content, 
			int pageSize, int pageNo, long total) {
		super(content, pageSize, pageNo, total);
	}

}