package object;

import java.util.Objects;

public class OrderDetail extends OrderObject {
	private String customerName;
    private String email;
    private String phone;
    private String paymentMethod;
    @Override
    public String toString() {
        return "OrderDetail{" +
               "orderId=" + getOrderId() +
               ", orderCreatedDate='" + getOrderCreatedDate() + '\'' +
               ", orderTotalPrice=" + getOrderTotalPrice() +
               ", orderStatus='" + getOrderStatus() + '\'' +
               ", orderAddressShipping='" + getOrderAddressShipping() + '\'' +
               ", orderShipName='" + getOrderShipName() + '\'' +
               ", orderShipPrice='" + getOrderShipPrice() + '\'' +
               ", customerName='" + customerName + '\'' +
               ", email='" + email + '\'' +
               ", phone='" + phone + '\'' +
               ", paymentMethod='" + paymentMethod + '\'' +
               '}';
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(customerName, email, paymentMethod, phone);
		return result;
	}
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetail(int orderId, String orderCreatedDate, int orderTotalPrice, String orderStatus,
			String orderAddressShipping, String orderShipName, int orderShipPrice, String userId, int shipId,
			int paymentId, String orderMessage) {
		super(orderId, orderCreatedDate, orderTotalPrice, orderStatus, orderAddressShipping, orderShipName, orderShipPrice,
				userId, shipId, paymentId, orderMessage);
		// TODO Auto-generated constructor stub
	}
	public OrderDetail(String customerName, String email, String phone, String paymentMethod) {
		super();
		this.customerName = customerName;
		this.email = email;
		this.phone = phone;
		this.paymentMethod = paymentMethod;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetail other = (OrderDetail) obj;
		return Objects.equals(customerName, other.customerName) && Objects.equals(email, other.email)
				&& Objects.equals(paymentMethod, other.paymentMethod) && Objects.equals(phone, other.phone);
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	
}
