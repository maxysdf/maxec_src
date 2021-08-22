package idv.maxy.maxec.biz.search.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * 
 * @author Max Chen
 *
 */
@Document(indexName="product", createIndex=false)
public class SearchProduct extends BaseSearchModel {
	
	@Field(type=FieldType.Text)
	private String name;
	
	@Field(type=FieldType.Keyword)
	private String sku;

	@Field(type=FieldType.Integer)
	private Integer price;
	
	@Field(type=FieldType.Integer)
	private Integer weight;
	
	@Field(type=FieldType.Integer)
	private Integer rating;
	
	@Field(type=FieldType.Text)
	private String brief;
	
	@Field(type=FieldType.Text)
	private String description;
	
	@Field(type=FieldType.Flattened)
	private List<SearchProductTag> tags = new ArrayList<>();
	
	@Field(type=FieldType.Long)
	private Long timestamp;

	
	public SearchProduct tag(String type, String id, String value) {
		SearchProductTag tag = new SearchProductTag();
		tag.setId(id);
		tag.setType(type);
		tag.setValue(value);
		tags.add(tag);
		return this;
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<SearchProductTag> getTags() {
		return tags;
	}

	public void setTags(List<SearchProductTag> tags) {
		this.tags = tags;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
