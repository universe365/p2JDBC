package Dao;

import java.util.List;

public interface implCart {
	
	void addCart(Object o);
	
	List<Object> queryAll();
	List<Object> queryCustomer(int customer_id);
	Object queryCustomer(int customer_id, int product_id);
	
	void update( int quantity, int id);
	
	void delete(int id);

}
