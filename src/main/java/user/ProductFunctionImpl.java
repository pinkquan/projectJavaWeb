package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import object.ProductObject;
import util.ConnectionPool;
import util.ConnectionPoolImpl;

public class ProductFunctionImpl implements ProductFunction {
    private Connection con;
    private ConnectionPool cp;

    public ProductFunctionImpl(ConnectionPool cp) {
        if (cp == null) {
            this.cp = new ConnectionPoolImpl();
        } else {
            this.cp = cp;
        }
        try {
            this.con = this.cp.getConnection("User");
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

    @Override
    public boolean addProduct(ProductObject item) {
        String sql = "INSERT INTO tblproduct (product_name, product_ingredient, product_portion, "
                   + "product_energy, product_time_complete, product_description, product_price, "
                   + "product_quantity, "
                   + "category_id, product_img) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pre = this.con.prepareStatement(sql)) {
            pre.setString(1, item.getProductName());
            pre.setString(2, item.getProductIngredient());
            pre.setString(3, item.getProductPortion());
            pre.setString(4, item.getProductEnergy());
            pre.setString(5, item.getProductTimeComplete());
            pre.setString(6, item.getProductDescription());
            pre.setInt(7, item.getProductPrice());
            pre.setInt(8, item.getProductQuantity());
            pre.setInt(9, item.getCategoryId());
            pre.setString(10, item.getProductImg());

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

    @Override
    public boolean editProduct(ProductObject item) {
        String sql = "UPDATE tblproduct SET product_name=?, product_ingredient=?, product_portion=?, "
                   + "product_energy=?, product_time_complete=?, product_description=?, product_price=?, "
                   + "product_quantity=?, "
                   + "category_id=?, product_img=? WHERE product_id=?";

        try (PreparedStatement pre = this.con.prepareStatement(sql)) {
            pre.setString(1, item.getProductName());
            pre.setString(2, item.getProductIngredient());
            pre.setString(3, item.getProductPortion());
            pre.setString(4, item.getProductEnergy());
            pre.setString(5, item.getProductTimeComplete());
            pre.setString(6, item.getProductDescription());
            pre.setInt(7, item.getProductPrice());
            pre.setInt(8, item.getProductQuantity());
            pre.setInt(9, item.getCategoryId());
            pre.setString(10, item.getProductImg());
            pre.setInt(11, item.getProductId());

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

    @Override
    public boolean delProduct(ProductObject item) {
        String sql = "DELETE FROM tblproduct WHERE product_id = ?";

        try (PreparedStatement pre = this.con.prepareStatement(sql)) {
            pre.setInt(1, item.getProductId());

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

    @Override
    public ProductObject getProduct(int id) {
        String sql = "SELECT * FROM tblproduct WHERE product_id = ?";
        try (PreparedStatement pre = this.con.prepareStatement(sql)) {
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                ProductObject item = new ProductObject();
                item.setProductId(rs.getInt("product_id"));
                item.setProductName(rs.getString("product_name"));
                item.setProductIngredient(rs.getString("product_ingredient"));
                item.setProductPortion(rs.getString("product_portion"));
                item.setProductEnergy(rs.getString("product_energy"));
                item.setProductTimeComplete(rs.getString("product_time_complete"));
                item.setProductDescription(rs.getString("product_description"));
                item.setProductPrice(rs.getInt("product_price"));
                item.setProductQuantity(rs.getInt("product_quantity"));
                item.setCategoryId(rs.getInt("category_id"));
                item.setProductImg(rs.getString("product_img"));
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

    @Override
    public ArrayList<ProductObject> getProducts(int category_id) {
        ArrayList<ProductObject> results = new ArrayList<>();
        String sql = "SELECT * FROM tblproduct WHERE category_id = ?";

        try (PreparedStatement pre = this.con.prepareStatement(sql)) {
            pre.setInt(1, category_id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                ProductObject item = new ProductObject();
                item.setProductId(rs.getInt("product_id"));
                item.setProductName(rs.getString("product_name"));
                item.setProductIngredient(rs.getString("product_ingredient"));
                item.setProductPortion(rs.getString("product_portion"));
                item.setProductEnergy(rs.getString("product_energy"));
                item.setProductTimeComplete(rs.getString("product_time_complete"));
                item.setProductDescription(rs.getString("product_description"));
                item.setProductPrice(rs.getInt("product_price"));
                item.setProductQuantity(rs.getInt("product_quantity"));
                item.setCategoryId(rs.getInt("category_id"));
                item.setProductImg(rs.getString("product_img"));
                results.add(item);
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
    public ConnectionPool getCP() {
        return this.cp;
    }

    @Override
    public void releaseConnection() {
        try {
            this.cp.releaseConnection(this.con, "User");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    
    public static void main(String[] args) {
		ProductFunction pf = new ProductFunctionImpl(null);

		ArrayList<ProductObject> gitem = pf.getProducts(2);
		for(ProductObject item : gitem) {
			System.out.println(item);
		}	
		
		
		ProductObject sp1 = pf.getProduct(1);
		System.out.println(sp1);
		
    }
	
}
