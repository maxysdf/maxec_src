package idv.maxy.maxec.biz.vo;

import java.util.ArrayList;
import java.util.List;

public class BasePage<T> implements BasePageable {
	private int number;
	private int size;
	private long totalElements;
	private List<T> content;
	
	public BasePage() {
		this(new ArrayList<>(), 10, 0, 0L);
	}
	
	public BasePage(List<T> content, int pageSize, int pageNo, long total) {
		this.content = content;
		this.size = pageSize;
		this.number = pageNo;
		this.totalElements = total;
	}

	@Override
	public int getNumber() { return number; }

	@Override
	public int getSize() { return size; }

	@Override
	public int getNumberOfElements() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasContent() {
		return !content.isEmpty();
	}

	@Override
	public int getTotalPages() {
		if(size == 0) { return 1; }
		return new Long(totalElements % size > 0 ? totalElements / size + 1 : totalElements / size).intValue();
	}

	@Override
	public long getTotalElements() {
		return totalElements;
	}

	@Override
	public boolean hasPrevious() {
		return number > 1;
	}

	@Override
	public List<T> getContent() {
		return content;
	}

	@Override
	public boolean isFirst() {
		return number == 1;
	}

	@Override
	public boolean isLast() {
		return number == getTotalPages();
	}

	@Override
	public boolean hasNext() {
		return number < getTotalPages();
	}
}
