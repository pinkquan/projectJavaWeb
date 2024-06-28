package object;

import java.util.Objects;

public class CategoryObject {
	private int categoryId;
	private String categoryName;
	public CategoryObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoryObject(int categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "CategoryObject [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(categoryId, categoryName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryObject other = (CategoryObject) obj;
		return categoryId == other.categoryId && Objects.equals(categoryName, other.categoryName);
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
