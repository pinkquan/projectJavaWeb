package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import object.Account;
import util.ConnectionPool;
import util.ConnectionPoolImpl;

public class AccountFunctionImp{
private Connection con;
    
    private ConnectionPool cp;
	
	public AccountFunctionImp(ConnectionPool cp) {
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
	
	
    public boolean addAccount(Account item) {
        String sql = "INSERT INTO tbluser (user_id, user_firstname, user_birthday, user_address, user_phone, user_email, user_pass, user_status, user_role, user_created_date) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, DATE_FORMAT(CURRENT_TIMESTAMP(), '%Y-%m-%d'));";
        
        try {
        	PreparedStatement pre = this.con.prepareStatement(sql);
            pre.setString(1, item.get_id());
            pre.setString(2, item.getFirst_name());
            pre.setString(3, item.getDate_of_birth());
            pre.setString(4, item.getAddress());
            pre.setString(5, item.getPhone_number());
            pre.setString(6, item.getEmail());
            pre.setString(7, item.getPassword());
            pre.setInt(8, item.getStatus());
            pre.setString(9, item.getRole());

            return this.exe(pre);

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

	
	public boolean editAccount(String id, Account item) {
		// TODO Auto-generated method stub
		String sql = "UPDATE tbluser SET " +
	             "user_firstname = ?, user_birthday = ?, " +
	             "user_address = ?, user_phone = ?, user_email = ?, " +
	             "user_pass = ?, user_role = ? " +
	             "WHERE user_id = ?;";


        try{
        	PreparedStatement pre = this.con.prepareStatement(sql);

            pre.setString(1, item.getFirst_name());
            pre.setString(2, item.getDate_of_birth());
            pre.setString(3, item.getAddress());
            pre.setString(4, item.getPhone_number());
            pre.setString(5, item.getEmail());
            pre.setString(6, item.getPassword());
            pre.setString(7, item.getRole());
            pre.setString(8, id);

            return this.exe(pre);
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


	public boolean editStatus(String id, int status) {
		// TODO Auto-generated method stub
		String sql = "UPDATE tbluser SET " +
	             "user_status = ? " +
	             "WHERE user_id = ?;";

        try{
        	PreparedStatement pre = this.con.prepareStatement(sql);

            pre.setInt(1, status);
            pre.setString(2, id);

            return this.exe(pre);
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
	
	public boolean delAccount(String id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM tbluser WHERE user_id = ?";

        try{
        	PreparedStatement pre = this.con.prepareStatement(sql);

            pre.setString(1, id);

            return this.exe(pre);
        
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

	
	public Account getAccount(String id) {
		// TODO Auto-generated method stub
		
        String sql = "SELECT * FROM tbluser WHERE user_id = ?" ;
        try{
        	PreparedStatement pre = this.con.prepareStatement(sql);

            pre.setString(1, id);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
            	Account item = new Account();
                item.set_id(rs.getString("user_id"));
                item.setFirst_name(rs.getString("user_firstname"));
                item.setAddress(rs.getString("user_address"));
                item.setEmail(rs.getString("user_email"));
                item.setDate_of_birth(rs.getString("user_birthday"));
                item.setPhone_number(rs.getString("user_phone"));
                item.setPassword(rs.getString("user_pass"));
                item.setStatus(Integer.parseInt(rs.getString("user_status")));
                item.setStart_date(rs.getString("user_created_date"));
                item.setRole(rs.getString("user_role"));
            
                return item;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                this.con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }
	
	public Account getAccount(String id, String pass) {
		// TODO Auto-generated method stub
		Account item = null;
        String sql = "SELECT * FROM tbluser WHERE user_id = ? AND user_pass = ?" ;
        try{
        	PreparedStatement pre = this.con.prepareStatement(sql);
            pre.setString(1, id);
            pre.setString(2, pass);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
            	item = new Account();
                item.set_id(rs.getString("user_id"));
                item.setFirst_name(rs.getString("user_firstname"));
                item.setAddress(rs.getString("user_address"));
                item.setEmail(rs.getString("user_email"));
                item.setDate_of_birth(rs.getString("user_birthday"));
                item.setPhone_number(rs.getString("user_phone"));
                item.setPassword(rs.getString("user_pass"));
                item.setStatus(Integer.parseInt(rs.getString("user_status")));
                item.setStart_date(rs.getString("user_created_date"));
                item.setRole(rs.getString("user_role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                this.con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return item;
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

	
	public ArrayList<Account> getAccounts() {
		// TODO Auto-generated method stub
		ArrayList<Account> results = new ArrayList<>();
		Account account = new Account();
        String sql = "SELECT * FROM tbluser ORDER BY user_id ASC";
        try {
        	PreparedStatement pre = this.con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
            	account = new Account();
            	account.set_id(rs.getString("user_id"));
            	account.setFirst_name(rs.getString("user_firstname"));
            	account.setAddress(rs.getString("user_address"));
                account.setEmail(rs.getString("user_email"));
                account.setDate_of_birth(rs.getString("user_birthday"));
                account.setPhone_number(rs.getString("user_phone"));
                account.setPassword(rs.getString("user_pass"));
                account.setStatus(Integer.parseInt(rs.getString("user_status")));
                account.setStart_date(rs.getString("user_created_date"));
                account.setRole(rs.getString("user_role"));
                results.add(account);

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
	
	public int getAmountOfAcc() {
		int result = 0;
		String sql = "SELECT COUNT(user_id) as customers FROM tbluser " +
	             "WHERE user_status = 1 AND user_role = 'User';";

		try {
        	PreparedStatement pre = this.con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            
            while (rs.next()) {
                result = rs.getInt("customers");
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
	
	
	public static void print(AccountFunctionImp user) throws SQLException{
        ArrayList<Account> list = user.getAccounts();
        for(Account i : list){
            System.out.println(i);
        }
    }

	public static void main(String[] args) throws SQLException, ClassNotFoundException{

      AccountFunctionImp user = new AccountFunctionImp(null);

      // Show all the data in Students DB
      System.out.println("The original list of acc in the database");
      print(user);

      // Test Data
      Account student = new Account(
    		  "2021608160",
              "An",
              "2005-08-22",
              "Ha Noi",
              "09999988899",
              "An@gmail.com",
              "12345");

      // Add student
      user.addAccount(student);
      System.out.println("After adding a new student");
      print(user);

      user.releaseConnection();
  }
}
