package user;

import java.util.*;
import object.*;
import util.ConnectionPool;


public interface OrderFunction {
	// Lấy hóa đơn
	public ArrayList<OrderDetail> getOrders();
	
	// Xóa hóa đơn
	public boolean delOrder(OrderDetail item);
	
	public ArrayList<OrderDetail> viewOrder();
	
	public ConnectionPool getCP();
    
    public void releaseConnection();
}
