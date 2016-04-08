package cans4cash.cart;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import cans4cash.product.Product;

@Entity
public class CartItem {
	

	private int quantity;
	private double total;
	
	@OneToOne()
    private Product product;
    
    @Id
	@GeneratedValue
	private int id;
    
    public CartItem(){
    	
    }

    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CartItem(int qty, Product p) {
		this.quantity = qty;
		this.product = p;
	}
    
    public int getQuantity(){
    	return quantity;
    }
    
    public void setQuantity(int q){
    	quantity = q;
    }
    
    public void incrementQuantity(){
    	quantity++;
    }
    
    public void setProduct(Product p){
    	product = p;
    }
    
    public Product getProduct(){
    	return product;
    }


	public void decrementQuantity() {
		quantity--;
		
	}
	
	public double getTotal(){
		total = quantity * product.getPrice();
		return total;
	}

    
    
    
  
}
