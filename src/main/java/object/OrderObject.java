package object;

import java.util.Objects;

public class OrderObject {
    private int orderId;
    private String orderCreatedDate;
    private int orderTotalPrice;
    private String orderStatus;
    private String orderAddressShipping;
    private String orderShipName;
    private int orderShipPrice;
    private String userId;
    private int shipId;
    private int paymentId;
    private String orderMessage;
	public OrderObject() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getOrderMessage() {
		return orderMessage;
	}



	public void setOrderMessage(String orderMessage) {
		this.orderMessage = orderMessage;
	}



	public OrderObject(int orderId, String orderCreatedDate, int orderTotalPrice, String orderStatus,
			String orderAddressShipping, String orderShipName, int orderShipPrice, String userId, int shipId,
			int paymentId, String orderMessage) {
		super();
		this.orderId = orderId;
		this.orderCreatedDate = orderCreatedDate;
		this.orderTotalPrice = orderTotalPrice;
		this.orderStatus = orderStatus;
		this.orderAddressShipping = orderAddressShipping;
		this.orderShipName = orderShipName;
		this.orderShipPrice = orderShipPrice;
		this.userId = userId;
		this.shipId = shipId;
		this.paymentId = paymentId;
		this.orderMessage = orderMessage;
	}



	@Override
	public String toString() {
		return "OrderObject [orderId=" + orderId + ", orderCreatedDate=" + orderCreatedDate + ", orderTotalPrice="
				+ orderTotalPrice + ", orderStatus=" + orderStatus + ", orderAddressShipping=" + orderAddressShipping
				+ ", orderShipName=" + orderShipName + ", orderShipPrice=" + orderShipPrice + ", userId=" + userId
				+ ", shipId=" + shipId + ", paymentId=" + paymentId + ", orderMessage=" + orderMessage +"]";
	}
	



	@Override
	public int hashCode() {
		return Objects.hash(orderAddressShipping, orderCreatedDate, orderId, orderShipName, orderShipPrice, orderStatus,
				orderTotalPrice, paymentId, shipId, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderObject other = (OrderObject) obj;
		return Objects.equals(orderAddressShipping, other.orderAddressShipping)
				&& Objects.equals(orderCreatedDate, other.orderCreatedDate) && orderId == other.orderId
				&& Objects.equals(orderShipName, other.orderShipName)
				&& Objects.equals(orderShipPrice, other.orderShipPrice)
				&& Objects.equals(orderStatus, other.orderStatus) && orderTotalPrice == other.orderTotalPrice
				&& paymentId == other.paymentId && shipId == other.shipId && userId == other.userId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderCreatedDate() {
		return orderCreatedDate;
	}
	public void setOrderCreatedDate(String orderCreatedDate) {
		this.orderCreatedDate = orderCreatedDate;
	}
	public int getOrderTotalPrice() {
		return orderTotalPrice;
	}
	public void setOrderTotalPrice(int orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderAddressShipping() {
		return orderAddressShipping;
	}
	public void setOrderAddressShipping(String orderAddressShipping) {
		this.orderAddressShipping = orderAddressShipping;
	}
	public String getOrderShipName() {
		return orderShipName;
	}
	public void setOrderShipName(String orderShipName) {
		this.orderShipName = orderShipName;
	}
	public int getOrderShipPrice() {
		return orderShipPrice;
	}
	public void setOrderShipPrice(int orderShipPrice) {
		this.orderShipPrice = orderShipPrice;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getShipId() {
		return shipId;
	}
	public void setShipId(int shipId) {
		this.shipId = shipId;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	
}
