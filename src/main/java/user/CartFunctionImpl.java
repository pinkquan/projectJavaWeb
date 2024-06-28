package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import object.CartItemObject;
import object.CartObject;
import util.ConnectionPool;
import util.ConnectionPoolImpl;

public class CartFunctionImpl {
private Connection con;
    
    private ConnectionPool cp;
    public CartFunctionImpl(ConnectionPool cp) {
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
    
    public boolean addCart(CartObject item) {
    	StringBuilder sql = new StringBuilder();
    	sql.append("INSERT INTO tblcart");
    	sql.append("(cart_id, user_id) ");
    	sql.append("VALUES(?, ?);");
    	try {
    		PreparedStatement pre = this.con.prepareStatement(sql.toString());
    		pre.setInt(1, item.getCartId());
    		pre.setInt(2, item.getUserId());
    		return this.exe(pre);
    	}catch (SQLException e) {
            e.printStackTrace();
            try {
                this.con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
		return false;
	}
    
    public boolean addCartItem(CartItemObject item) {
//    	StringBuilder sql = new StringBuilder();
//        sql.append("INSERT INTO tblcartitem ");
//        sql.append("(cart_item_id, cart_item_quantity, product_id, cart_id) ");
//        sql.append("VALUES (?, ?, ?, ?);");
//        
//        try {
//            PreparedStatement pre = this.con.prepareStatement(sql.toString());
//            pre.setInt(1, item.getCartItemId());
//            pre.setInt(2, item.getCartItemQuantity());
//            pre.setInt(3, item.getProductId());
//            pre.setInt(4, item.getCartId());
    	StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO tblcartitem ");
        sql.append("(cart_item_quantity, product_id, cart_id) ");
        sql.append("VALUES (?, ?, ?);");

        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            pre.setInt(1, item.getCartItemQuantity());
            pre.setInt(2, item.getProductId());
            pre.setInt(3, item.getCartId());
    		return this.exe(pre);
    	}catch (SQLException e) {
            e.printStackTrace();
            try {
                this.con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
		return false;
	}
    
    public CartObject getCartByUserId(int userId) {
    	String sql = "SELECT * FROM tblcart WHERE user_id = ?";
    	try (
    		PreparedStatement pre = this.con.prepareStatement(sql)) {
            pre.setInt(1, userId);
            ResultSet rs = pre.executeQuery();
            if(rs.next()) {
            	CartObject item = new CartObject();
            	item.setCartId(rs.getInt("cart_id"));
            	item.setUserId(rs.getInt("user_id"));
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
    
    public CartItemObject getCartItemByCartProduct(int cartId, int productId) {
        String sql = "SELECT * FROM tblcartitem WHERE cart_id = ? and product_id = ?";
        try (
            PreparedStatement pre = this.con.prepareStatement(sql)) {
            pre.setInt(1, cartId);
            pre.setInt(2, productId);
            ResultSet rs = pre.executeQuery();
            if(rs.next()) {
                CartItemObject item = new CartItemObject();
                item.setCartItemId(rs.getInt("cart_item_id"));
                item.setCartItemQuantity(rs.getInt("cart_item_quantity"));
                item.setProductId(rs.getInt("product_id"));
                item.setCartId(rs.getInt("cart_id"));
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
    
    public boolean updateCartItem(CartItemObject item) {
        String sql = "UPDATE tblcartitem SET cart_item_quantity = ? WHERE cart_item_id = ?";
        try {
            PreparedStatement pre = this.con.prepareStatement(sql);
            pre.setInt(1, item.getCartItemQuantity());
            pre.setInt(2, item.getCartItemId());

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
    
    public ArrayList<CartItemObject> getCartItemsByCartId(int cartId) {
        ArrayList<CartItemObject> cartItems = new ArrayList<>();
        String sql = "SELECT * FROM tblcartitem WHERE cart_id = ?";
        
        try (PreparedStatement pre = this.con.prepareStatement(sql)) {
            pre.setInt(1, cartId);
            ResultSet rs = pre.executeQuery();
            
            while (rs.next()) {
                CartItemObject item = new CartItemObject();
                item.setCartItemId(rs.getInt("cart_item_id"));
                item.setCartItemQuantity(rs.getInt("cart_item_quantity"));
                item.setProductId(rs.getInt("product_id"));
                item.setCartId(rs.getInt("cart_id"));
                
                cartItems.add(item);
            }
            
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                this.con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        return cartItems;
    }
    
    public boolean deleteCartItem(int cartItemId) {
        String sql = "DELETE FROM tblcartitem WHERE cart_item_id = ?";
        try {
            PreparedStatement pre = this.con.prepareStatement(sql);
            pre.setInt(1, cartItemId);

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

	public static void main(String[] args) throws SQLException, ClassNotFoundException{

//	CartFunctionImpl cf = new CartFunctionImpl(null);
	
//	CartObject itemObject = new CartObject();
//	itemObject.setCartId(1);
//	itemObject.setUserId(1);
	
//	CartItemObject cartItemObject = new CartItemObject();
////	cartItemObject.setCartItemId(1);
//	cartItemObject.setCartItemQuantity(7);
//	cartItemObject.setProductId(4);
//	cartItemObject.setCartId(2021608161);
////	
//////	cf.addCart(itemObject);
//	cf.addCartItem(cartItemObject);
//
//	
//	
//    cf.releaseConnection();
//
  }

    
}
