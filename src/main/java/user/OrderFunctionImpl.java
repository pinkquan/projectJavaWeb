package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import object.*;
import util.*;


public class OrderFunctionImpl implements OrderFunction {
	
private Connection con;
    
    private ConnectionPool cp;

    public OrderFunctionImpl(ConnectionPool cp) {
        if (cp == null) {
        	this.cp = new ConnectionPoolImpl();
//            cp = new ConnectionPoolImpl();
        } else {
        	this.cp = cp;
        }

        //Xin kết nối
        try {
            this.con = this.cp.getConnection("User");

            //Chấm dứt chế độ thực thi tự động của kết nối
            if (this.con.getAutoCommit()) {
                this.con.setAutoCommit(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    private boolean exe(PreparedStatement pre) {
        if (pre != null) {
            // pre đã được biên dịch và truyền đầy đủ giá trị cho tham số
            try {
                int result = pre.executeUpdate();
                if (result == 0) {
                    this.con.rollback();
                    return false;
                }

                // Xác nhận thực thi sau cùng
                this.con.commit();
                return true;

            } catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();

                try {
                    this.con.rollback();
                } catch (SQLException e1) {
                    // TODO: handle exception
                    e1.printStackTrace();
                }
            } finally {
                pre = null;
            }
        }
        return false;
    }
    @Override
    public ArrayList<OrderDetail> getOrders() {
        ArrayList<OrderDetail> results = new ArrayList<>();
        OrderDetail item = null;
        String sql = "SELECT o.*, u.user_firstname, u.user_email, u.user_phone, p.payment_method " +
                     "FROM tblorder o " +
                     "JOIN tbluser u ON o.user_id = u.user_id " +
                     "JOIN tblpayment p ON o.payment_id = p.payment_id " +
                     "ORDER BY o.order_id DESC";
        
        try {
            PreparedStatement pre = this.con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    item = new OrderDetail();
                    item.setOrderId(rs.getInt("order_id"));
                    item.setOrderCreatedDate(rs.getString("order_created_date"));
                    item.setOrderTotalPrice(rs.getInt("order_total_price"));
                    item.setOrderStatus(rs.getString("order_status"));
                    item.setOrderAddressShipping(rs.getString("order_address_shipping"));
                    item.setOrderShipName(rs.getString("order_ship_name"));
                    item.setOrderShipPrice(rs.getInt("order_ship_price"));
                    item.setUserId(rs.getString("user_id"));
                    item.setPaymentId(rs.getInt("payment_id"));
                    
                    // Thêm các trường mới từ OrderDetail
                    item.setCustomerName(rs.getString("user_firstname"));
                    item.setEmail(rs.getString("user_email"));
                    item.setPhone(rs.getString("user_phone"));
                    item.setPaymentMethod(rs.getString("payment_method"));
                    
                    results.add(item);
                }
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                this.con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        return results;
    }

    
    
    
    @Override
    public boolean delOrder(OrderDetail item) {
        PreparedStatement ps = null;
        String query = "DELETE FROM tblorder WHERE order_id = ?";

        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, item.getOrderId());
            
            int result = ps.executeUpdate();
            
            if (result > 0) {
                this.con.commit();
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public boolean addOrder(OrderDetail order) {
        PreparedStatement ps = null;
        String query = "INSERT INTO tblorder (order_id, order_created_date, order_total_price, order_status, " +
                       "order_address_shipping, order_ship_name, order_ship_price, user_id, payment_id, " +
                       "order_message) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, order.getOrderId()); // Set order_id từ đối tượng OrderDetail
            ps.setString(2, order.getOrderCreatedDate());
            ps.setInt(3, order.getOrderTotalPrice());
            ps.setString(4, order.getOrderStatus());
            ps.setString(5, order.getOrderAddressShipping());
            ps.setString(6, order.getOrderShipName());
            ps.setInt(7, order.getOrderShipPrice());
            ps.setString(8, order.getUserId());
            ps.setInt(9, order.getPaymentId());
            ps.setString(10, order.getOrderMessage()); // Thêm order_message vào tham số

            int result = ps.executeUpdate();

            if (result > 0) {
                this.con.commit();
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }



	@Override
	public ConnectionPool getCP() {
		// TODO Auto-generated method stub
		return this.cp;
	}

	@Override
	public void releaseConnection() {
		// TODO Auto-generated method stub
		try {
			this.cp.releaseConnection(this.con, "User");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
        OrderFunction of = new OrderFunctionImpl(null);

        // Lấy danh sách đơn hàng từ cơ sở dữ liệu
        ArrayList<OrderDetail> list = of.getOrders();
        OrderDetail detail = new OrderDetail();
        
        list.forEach(u -> {
            System.out.println(u);
        });
    }

	@Override
	public ArrayList<OrderDetail> viewOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
