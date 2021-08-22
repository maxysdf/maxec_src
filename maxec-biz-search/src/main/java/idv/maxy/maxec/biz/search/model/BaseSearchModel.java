package idv.maxy.maxec.biz.search.model;

import javax.persistence.Id;

/**
 * 
 * @author Max Chen
 *
 */
public class BaseSearchModel {
	@Id
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
