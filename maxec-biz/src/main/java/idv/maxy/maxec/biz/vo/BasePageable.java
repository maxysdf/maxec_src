package idv.maxy.maxec.biz.vo;

import java.util.List;

public interface BasePageable {
	public int getNumber();
	public int getSize();
	public int getNumberOfElements();
	public boolean hasContent();
	public int getTotalPages();
	public long getTotalElements();
	public boolean hasPrevious();
	public <T> List<T> getContent();
	public boolean isFirst();
	public boolean isLast();
	public boolean hasNext();
}
