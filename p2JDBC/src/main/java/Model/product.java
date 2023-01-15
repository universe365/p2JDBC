package Model;

public class product {
	
	private Integer id;
	private String description;
	private String image;
	private String image_name;
	private String name;
	private Integer price;
	private Integer discount;
	private String product_category;
	
	public product() {super();}
	
	public product(String description, String image, String image_name,
					String name, Integer price,Integer discount, String product_category) {
		this.description=description;
		this.image=image;
		this.image_name=image_name;
		this.name = name.toUpperCase();
		this.price=price;
		this.discount=discount;
		this.product_category=product_category.toUpperCase();
	}
	
	public product( String name, Integer price, String product_category) {
		this.name = name.toUpperCase();
		this.price=price;
		this.product_category=product_category.toUpperCase();
		description=description = "N/A";
		image=image = "N/A";
		image_name=image_name = "N/A";
		discount=0;
	}
	
	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getImage_name() {
		return image_name;
	}
	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name.toUpperCase();
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getProduct_category() {
		return product_category;
	}
	public void setProduct_category(String product_category) {
		this.product_category = product_category.toUpperCase();
	}

}
