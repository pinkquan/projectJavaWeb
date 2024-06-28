package object;

import java.sql.Date;
import java.util.Objects;

public class ProductObject {
	private int productId;
	private String productImg;
    private String productName;
    private String productIngredient;
    private String productPortion;
    private String productEnergy;
    private String productTimeComplete;
    private String productDescription;
    private int productPrice;
    private int productQuantity;
    private int categoryId;
	public ProductObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProductObject(int productId, String productImg, String productName, String productIngredient,
			String productPortion, String productEnergy, String productTimeComplete, String productDescription,
			int productPrice, int productQuantity, int categoryId) {
		super();
		this.productId = productId;
		this.productImg = productImg;
		this.productName = productName;
		this.productIngredient = productIngredient;
		this.productPortion = productPortion;
		this.productEnergy = productEnergy;
		this.productTimeComplete = productTimeComplete;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "ProductObject [productId=" + productId + ", productImg=" + productImg + ", productName=" + productName
				+ ", productIngredient=" + productIngredient + ", productPortion=" + productPortion + ", productEnergy="
				+ productEnergy + ", productTimeComplete=" + productTimeComplete + ", productDescription="
				+ productDescription + ", productPrice=" + productPrice + ", productQuantity=" + productQuantity
				+ ", productDateCome=" +  ", productTimeCome=" 
				+ ", productParticipants=" + ", categoryId=" + categoryId + "]";
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}


	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductIngredient() {
		return productIngredient;
	}
	public void setProductIngredient(String productIngredient) {
		this.productIngredient = productIngredient;
	}
	public String getProductPortion() {
		return productPortion;
	}
	public void setProductPortion(String productPortion) {
		this.productPortion = productPortion;
	}
	public String getProductEnergy() {
		return productEnergy;
	}
	public void setProductEnergy(String productEnergy) {
		this.productEnergy = productEnergy;
	}
	public String getProductTimeComplete() {
		return productTimeComplete;
	}
	public void setProductTimeComplete(String productTimeComplete) {
		this.productTimeComplete = productTimeComplete;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
    
    
}
