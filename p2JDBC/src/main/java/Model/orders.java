package Model;

public class orders {
	
	private Integer id;
	private Integer order_no;
	private String customer_name;
	private String mobile_number;
	private String email_id;
	private String address;
	private String address_type;
	private String image;
	private String image_name;
	private String product_name;
	private Integer quantity;
	private Integer product_price;
	private Integer product_selling_price;
	private Integer product_total_price;
	private String order_status;
	private String order_date;
	private Integer customer_id;
	
	public orders() {super();}
	
	public orders(Integer order_no, String customer_name,
				String mobile_number, String email_id, String address,
				String address_type, String image, String image_name,
				String product_name, Integer quantity, Integer product_price,
				Integer product_selling_price, Integer product_total_price,
				String order_status, Integer customer_id) {
		this.order_no=order_no;
		this.customer_name=customer_name;
		this.mobile_number=mobile_number;
		this.email_id=email_id;
		this.address=address;
		this.address_type=address_type;
		this.image=image;
		this.product_name=product_name;
		this.quantity=quantity;
		this.product_price=product_price;
		this.product_selling_price=product_selling_price;
		this.product_total_price=product_total_price;
		this.order_status=order_status;
		this.customer_id=customer_id;
	}
	
	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Integer order_no) {
		this.order_no = order_no;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress_type() {
		return address_type;
	}
	public void setAddress_type(String address_type) {
		this.address_type = address_type;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getProduct_price() {
		return product_price;
	}
	public void setProduct_price(Integer product_price) {
		this.product_price = product_price;
	}
	public Integer getProduct_selling_price() {
		return product_selling_price;
	}
	public void setProduct_selling_price(Integer product_selling_price) {
		this.product_selling_price = product_selling_price;
	}
	public Integer getProduct_total_price() {
		return product_total_price;
	}
	public void setProduct_total_price(Integer product_total_price) {
		this.product_total_price = product_total_price;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
	
	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	

}
