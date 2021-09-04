package idv.maxy.maxec.biz.product.vo;

import java.util.List;

import idv.maxy.maxec.biz.vo.BasePage;

public class TagPageResultVO extends BasePage<TagVO> {
	public TagPageResultVO() {
		super();
	}
	
	public TagPageResultVO(List<TagVO> content, 
			int pageSize, int pageNo, long total) {
		super(content, pageSize, pageNo, total);
	}
}