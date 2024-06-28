package user;

import java.util.ArrayList;

import object.ProductObject;
import util.ConnectionPool;

public interface ProductFunction {
	public boolean addProduct(ProductObject item);
	public boolean editProduct(ProductObject item);
	public boolean delProduct(ProductObject item);
	
	public ProductObject getProduct(int id);
	
	public ArrayList<ProductObject> getProducts(int category_id);
	
    public ConnectionPool getCP();  
    public void releaseConnection();
}
