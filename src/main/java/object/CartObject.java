package object;

import java.util.Objects;

public class CartObject {
	private int cartId;
    private int userId;
	public CartObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartObject(int cartId, int userId) {
		super();
		this.cartId = cartId;
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "CartObject [cartId=" + cartId + ", userId=" + userId + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(cartId, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartObject other = (CartObject) obj;
		return cartId == other.cartId && userId == other.userId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
    
}
