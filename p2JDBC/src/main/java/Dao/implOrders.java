package Dao;

import java.util.List;

public interface implOrders {
	
	boolean addOrder(Object o);
	
	List<Object> queryAll();
	Object queryId(int id, int order_no);
	Object queryId(int id);
	List<Object> queryOrderN(int order_no);
	List<Object> queryByUserId(int customer_id);
	
	void update(String order_status, int order_no, int id);
	
	void delete(int id, int order_no);
	void delete(int order_no);
	
	Integer random_id(List<Object> orderlist);

}
