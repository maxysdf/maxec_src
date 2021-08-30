package idv.maxy.maxec.biz.search.model;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

public class SearchProductTag {
	
	@Field(type=FieldType.Keyword)
	private String type;
	
	@Field(type=FieldType.Keyword)
	private String id;
	
	@Field(type=FieldType.Keyword)
	private String value;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
