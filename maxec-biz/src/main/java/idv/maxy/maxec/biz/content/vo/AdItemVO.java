package idv.maxy.maxec.biz.content.vo;

public class AdItemVO {
	private String id;
	private String imagePath;
	private String imageAlt;
	private String imageLink;
	private boolean isOpenNew;
	private int sort;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getImageAlt() {
		return imageAlt;
	}
	public void setImageAlt(String imageAlt) {
		this.imageAlt = imageAlt;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public boolean isOpenNew() {
		return isOpenNew;
	}
	public void setOpenNew(boolean isOpenNew) {
		this.isOpenNew = isOpenNew;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
}
