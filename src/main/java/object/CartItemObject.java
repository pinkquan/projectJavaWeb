package object;

import java.util.Objects;

public class CartItemObject {
    private int cartItemId;
    private int cartItemQuantity;
    private int productId;
    private int cartId;
	public CartItemObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartItemObject(int cartItemId, int cartItemQuantity, int productId, int cartId) {
		super();
		this.cartItemId = cartItemId;
		this.cartItemQuantity = cartItemQuantity;
		this.productId = productId;
		this.cartId = cartId;
	}
	@Override
	public String toString() {
		return "CartItemObject [cartItemId=" + cartItemId + ", cartItemQuantity=" + cartItemQuantity + ", productId="
				+ productId + ", cartId=" + cartId + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(cartId, cartItemId, cartItemQuantity, productId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItemObject other = (CartItemObject) obj;
		return cartId == other.cartId && cartItemId == other.cartItemId
				&& Objects.equals(cartItemQuantity, other.cartItemQuantity) && productId == other.productId;
	}
	public int getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	public int getCartItemQuantity() {
		return cartItemQuantity;
	}
	public void setCartItemQuantity(int cartItemQuantity) {
		this.cartItemQuantity = cartItemQuantity;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
    
}
