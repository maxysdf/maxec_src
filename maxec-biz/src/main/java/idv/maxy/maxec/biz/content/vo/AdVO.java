package idv.maxy.maxec.biz.content.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Max Chen
 *
 */
public class AdVO {
	private String id;
	private String name;
	private String code;
	private List<AdItemVO> items = new ArrayList<>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<AdItemVO> getItems() {
		return items;
	}
	public void setItems(List<AdItemVO> items) {
		this.items = items;
	}
}
