package Model;

public class customer {
	
	private Integer id;
	private String address;
	private String added_date;
	private String email;
	private String gender;
	private String name;
	private String password;
	private String phone;
	
	public customer() { super(); }
	
	public customer(String name, String password) {
		this.name=name;
		this.password=password;
		gender="N/A";
	}
	
	public customer(String address, String email, String phone, String gender) {
		this.address=address;
		this.email=email;
		this.phone=phone;
		this.gender=gender;
	}
	
	public customer(String name, String password, String address, String email, String phone, String gender) {
		this.name=name;
		this.password=password;
		this.address=address;
		this.email=email;
		this.phone=phone;
		this.gender=gender;
	}
	
	public customer(String gender) {
		this.gender=gender;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAdded_date() {
		return added_date;
	}

	public void setAdded_date(String added_date) {
		this.added_date = added_date;
	}

}
