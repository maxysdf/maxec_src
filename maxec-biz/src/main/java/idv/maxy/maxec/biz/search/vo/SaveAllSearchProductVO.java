package idv.maxy.maxec.biz.search.vo;

import java.util.List;

public class SaveAllSearchProductVO {
	private List<SearchProductVO> list;
	private long ts;
	
	public List<SearchProductVO> getList() {
		return list;
	}
	public void setList(List<SearchProductVO> list) {
		this.list = list;
	}
	public long getTs() {
		return ts;
	}
	public void setTs(long ts) {
		this.ts = ts;
	}
}
