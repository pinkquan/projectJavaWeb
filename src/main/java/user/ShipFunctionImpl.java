package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import object.ProductObject;
import object.ShipObject;
import util.ConnectionPool;
import util.ConnectionPoolImpl;

public class ShipFunctionImpl implements ShipFunction {
    private Connection con;
    private ConnectionPool cp;

    public ShipFunctionImpl(ConnectionPool cp) {
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
    public ShipObject getShip(int id) {
        String sql = "SELECT * FROM tblship WHERE ship_id = ?";
        try (PreparedStatement pre = this.con.prepareStatement(sql)) {
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                ShipObject ship = new ShipObject();
                ship.setShipId(rs.getInt("ship_id"));
                ship.setShipName(rs.getString("ship_name"));
                ship.setShipPrice(rs.getString("ship_price"));
                // Thêm các trường khác nếu có
                return ship;
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
    public List<ShipObject> getShips() {
        List<ShipObject> shippingMethods = new ArrayList<>();
        String sql = "SELECT * FROM tblship";
        try (PreparedStatement pre = this.con.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {
            while (rs.next()) {
                ShipObject ship = new ShipObject();
                ship.setShipId(rs.getInt("ship_id"));
                ship.setShipName(rs.getString("ship_name"));
                ship.setShipPrice(rs.getString("ship_price"));
                // Thêm các trường khác nếu có
                shippingMethods.add(ship);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                this.con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return shippingMethods;
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
		ShipFunction sf = new ShipFunctionImpl(null);

		List<ShipObject> gitem = sf.getShips();
		for(ShipObject item : gitem) {
			System.out.println(item);
		}	
		
		
    }
    
}
