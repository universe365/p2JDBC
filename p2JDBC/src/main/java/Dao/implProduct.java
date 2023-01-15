package Dao;

import java.util.List;

public interface implProduct {
	
	void addProduct(Object o);
	
	List<Object> queryAll();
	Object queryId(int id);
	List<Object> queryCategory(String product_category);
	List<Object> queryPrice(int price);
	List<Object> queryName(String name);
	
	void update(Object o);
	
	void delete(int id);
	

}
