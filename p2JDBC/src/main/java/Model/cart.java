package Model;

public class cart {
	
	private Integer id;
	private Integer discount_price;
	private Integer quantity;
	private Integer total_price;
	private Integer customer_id;
	private Integer product_id;
	
	public cart() {super();}
	
	public cart(int customer_id, int product_id, int quantity, int total_price, int discount_price) {
		this.customer_id=customer_id;
		this.product_id=product_id;
		this.quantity=quantity;
		this.total_price=total_price;
		this.discount_price=discount_price;
	}
	

	public cart(int customer_id, int product_id, int quantity) {
		this.customer_id=customer_id;
		this.product_id=product_id;
		this.quantity=quantity;
		total_price=0;
		discount_price=0;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDiscount_price() {
		return discount_price;
	}
	public void setDiscount_price(Integer discount_price) {
		this.discount_price = discount_price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getTotal_price() {
		return total_price;
	}
	public void setTotal_price(Integer total_price) {
		this.total_price = total_price;
	}
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	

}
