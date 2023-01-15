package Model;

public class admin {
	
	private Integer id;
	private String added_date;
	private String email;
	private String password;
	private String name;
	
	public admin() { super(); }
	
	public admin(String name, String password) {
		this.name=name;
		this.password = password;
	}
	
	public admin(String name, String password, String email) {
		this.name=name;
		this.password = password;
		this.email=email;
	}
	 
	
	
	public String getAdded_date() {
		return added_date;
	}

	public void setAdded_date(String added_date) {
		this.added_date = added_date;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
