package object;

import java.util.Objects;

public class PaymentObject {
	private int paymentId;
    private String paymentMethod;
	public PaymentObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentObject(int paymentId, String paymentMethod) {
		super();
		this.paymentId = paymentId;
		this.paymentMethod = paymentMethod;
	}
	@Override
	public String toString() {
		return "PaymentObject [paymentId=" + paymentId + ", paymentMethod=" + paymentMethod + "]";
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

    
}
