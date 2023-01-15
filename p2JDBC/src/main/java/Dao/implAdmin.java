package Dao;

import java.util.List;

public interface implAdmin {
	
	void addAdmin(Object o);
	
	List<Object> queryAll();
	Object queryId(int id);
	Object queryUser(String name);
	Object queryUser(String name, String password);
	
	void update(String password, int id);
	void update(String name, String password, String email, int id);
	
	void delete(int id);
	

}
