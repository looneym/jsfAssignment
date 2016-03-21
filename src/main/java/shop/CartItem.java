package shop;

import records.Product;

public class CartItem {
	

	private int quantity;
    private Product product;
    private String name;
	private String description;
	private String imageFile;	
	private double price;
    
    public CartItem(int qty, Product p) {
		this.setQuantity(qty);
		this.product = p;
		this.name = this.product.getName();
		this.description = this.product.getDescription();
		this.setImageFile(this.product.getImageFile());
		this.price = this.product.getPrice();
	}
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("set name "+name);
		this.name = name;
	}
	public String getAge() {
		return description;
	}
	public void setAge(String desc) {
		description = desc;
	}

	public String Print() {
		return this.product.toString();
		
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.imageFile = description;
	}
    
    
    
  
}
