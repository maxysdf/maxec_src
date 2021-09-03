package idv.maxy.maxec.app.backend.graphql.vo;

import java.util.List;

import org.springframework.data.domain.Page;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Pageable {
	private Page page;
	public <T> Pageable(Page<T> page) {
		this.page = page;
	}
	
	public int  getNumber()           { return page.getNumber(); }
	public int  getNumberOfElements() { return page.getNumberOfElements(); }
	public int  getSize()             { return page.getSize(); }
	public long getTotalElements()    { return page.getTotalElements(); }
	public int  getTotalPages()       { return page.getTotalPages(); }
	public boolean hasContent()       { return page.hasContent(); }
	public boolean hasNext()          { return page.hasNext(); }
	public boolean hasPrevious()      { return page.hasPrevious(); }
	public boolean isFirst()          { return page.isFirst(); }
	public boolean isLast()           { return page.isLast(); }
	public <T>  List<T> getContent()  { return page.getContent(); }
}
