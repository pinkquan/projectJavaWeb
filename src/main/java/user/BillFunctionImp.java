package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import object.Bill;
import util.ConnectionPool;
import util.ConnectionPoolImpl;

public class BillFunctionImp {
private Connection con;
    
    private ConnectionPool cp;
	
	public BillFunctionImp(ConnectionPool cp) {
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
            try {
                int result = pre.executeUpdate();
                if (result == 0) {
                    this.con.rollback();
                    return false;
                }
                this.con.commit();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    this.con.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            } finally {
                try {
                    pre.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
	
	public ArrayList<Integer> getSaleQuantityByProduct(){
		ArrayList<Integer> list = new ArrayList();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT product_id, SUM(quantity) AS total_quantity_sold ");
		sql.append("FROM tblpaymentdetail ");
		sql.append("GROUP BY product_id;");
		try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            ResultSet rs = pre.executeQuery();
            
            while (rs.next()) {
                list.add(rs.getInt("total_quantity_sold"));
            }
            rs.close();
            return list;

	       } catch (SQLException e) {
	            e.printStackTrace();
	            try {
	                this.con.rollback();
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
	        }
		return list;
	}
	
	public ArrayList<Bill> getBill(){
		ArrayList<Bill> list = new ArrayList();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT order_id, user_id, order_participants, order_message ");
		sql.append("FROM tblorder ");
		sql.append("Order by order_date_come desc ");
		sql.append("Limit 5");
		try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            ResultSet rs = pre.executeQuery();
            
            while (rs.next()) {
            	Bill bill = new Bill();
                bill.setBill_id(rs.getString("order_id"));
                bill.setAcc_id(rs.getString("user_id"));
                bill.setParticipants(rs.getInt("order_participants"));
                bill.setMessage(rs.getString("order_message"));
                list.add(bill);
            }
            rs.close();
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                this.con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
		return list;
    }
	public boolean addBill(Bill item) {
		// TODO Auto-generated method stub
		StringBuilder sqlBill = new StringBuilder();
		sqlBill.append("INSERT INTO tblorder");
		sqlBill.append("(order_id, user_id, order_DATE_COME, order_TIME_COME, order_PARTICIPANTS, order_MESSAGE, order_created_date, payment_id) ");
		sqlBill.append("VALUES(?,?,?,?,?,?, DATE_FORMAT(CURRENT_TIMESTAMP(), '%Y-%m-%d'), 2);");

		StringBuilder sqlPayment = new StringBuilder();
		sqlPayment.append("INSERT INTO TBLPAYMENTDETAIL");
		sqlPayment.append("(PRODUCT_ID, order_id, QUANTITY) ");
		sqlPayment.append("VALUES(?,?,?);");

		try {
		    PreparedStatement preBill = this.con.prepareStatement(sqlBill.toString());
		    preBill.setString(1, item.getBill_id());
		    preBill.setString(2, item.getAcc_id());
		    preBill.setString(3, item.getDate());
		    preBill.setString(4, item.getTime());
		    preBill.setInt(5, item.getParticipants());
		    preBill.setString(6, item.getMessage());
		    this.exe(preBill); 

		    PreparedStatement prePayment = this.con.prepareStatement(sqlPayment.toString());
		    prePayment.setString(1, item.getProduct_id());
		    prePayment.setString(2, item.getBill_id());
		    prePayment.setInt(3, item.getQuantity());
		    return this.exe(prePayment);
        	
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                this.con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
		return false;
	}
	
	
	public int getTotal() {
		int result = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT SUM(p.product_price * py.quantity) AS tong_gia_tri from tblorder b ");
		sql.append("JOIN tblpaymentdetail py ON b.order_id = py.order_id ");
		sql.append("JOIN tblproduct p ON py.product_id = p.product_id");
		try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            ResultSet rs = pre.executeQuery();
            
            while (rs.next()) {
                result = rs.getInt("tong_gia_tri");
            }
            rs.close();
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                this.con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
		return result;
	}
	
	public int getAmountSales() {
		int result = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(b.order_id) as bills FROM sinhvien.tblorder b");
		try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            ResultSet rs = pre.executeQuery();
            
            while (rs.next()) {
                result = rs.getInt("bills");
            }
            rs.close();
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                this.con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
		return result;
	}
	
	public ArrayList<Integer> getSalesByDate() {
		ArrayList<Integer> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("select count(order_id) as sales from tblorder ");
		sql.append("group by order_date_come ");
		sql.append("order by order_date_come asc ");
		try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            ResultSet rs = pre.executeQuery();
            
            while (rs.next()) {
                list.add(rs.getInt("sales"));
            }
            rs.close();
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                this.con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
		return list;
	}
	
	
	public ArrayList<Integer> getRevenueByDate() {
		ArrayList<Integer> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT SUM(p.product_price * py.quantity) AS revenue FROM tblorder b ");
		sql.append("JOIN tblpaymentdetail py ON b.order_id = py.order_id ");
		sql.append("JOIN tblproduct p ON py.product_id = p.product_id ");
		sql.append("GROUP BY b.order_date_come ");
		sql.append("ORDER BY b.order_date_come ASC ");
		try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            ResultSet rs = pre.executeQuery();
            
            while (rs.next()) {
                list.add(rs.getInt("revenue"));
            }
            rs.close();
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                this.con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
		return list;
	}
	
	public ArrayList<String> getDateList() {
		ArrayList<String> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("select b.order_date_come as date_stone from tblorder b ");
		sql.append("group by order_date_come ");
		sql.append("order by order_date_come asc ");
		try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            ResultSet rs = pre.executeQuery();
            
            while (rs.next()) {
                list.add(rs.getString("date_stone"));
            }
            rs.close();
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                this.con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
		return list;
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException{

		BillFunctionImp user = new BillFunctionImp(null);

      // Show all the data in contacts DB

      // Test Data
      Bill pill = new Bill(
    		  "31723",
              "2024-06-21",
              "12:00 PM",
              "DV2",
              9,
              "Xin chao",
              2);
      user.addBill(pill);


      System.out.println(user.getBill());
  
      user.releaseConnection();

  }
	
    public void releaseConnection() {
        try {
            this.cp.releaseConnection(this.con, "User");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ConnectionPool getCP() {
        return this.cp;
    }
}
