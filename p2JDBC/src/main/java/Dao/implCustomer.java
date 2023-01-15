package Dao;

import java.util.List;

public interface implCustomer {
	
	void addCustomer(Object o);
	
	List<Object> queryAll();
	Object queryId(int id);
	Object queryUser(String name, String password);
	Object queryUser(String name);
	
	void update(String address, String gender, String email, String phone, int id);
	void update(String password, int id);
	
	void delete(int id);

}
