package user;

import java.util.List;

import object.ShipObject;
import util.ConnectionPool;

public interface ShipFunction {
	public ShipObject getShip(int id);
	
	public List<ShipObject> getShips();
	
    public ConnectionPool getCP();  
    public void releaseConnection();
}
