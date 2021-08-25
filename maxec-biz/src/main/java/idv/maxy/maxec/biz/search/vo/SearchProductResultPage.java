package idv.maxy.maxec.biz.search.vo;

import java.util.List;

import idv.maxy.maxec.biz.vo.BasePage;

public class SearchProductResultPage extends BasePage<SearchProductResultVO> {
//	public SearchProductResultPage(Page<SearchProductResultVO> page) {
//		super(page);
//	}
	
	public SearchProductResultPage() {
		super();
	}
	
	public SearchProductResultPage(List<SearchProductResultVO> content, 
			int pageSize, int pageNo, long total) {
		super(content, pageSize, pageNo, total);
	}
	
}
