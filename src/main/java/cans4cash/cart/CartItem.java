package cans4cash.cart;

import cans4cash.product.Product;

public class CartItem {
	

	private int quantity;
    private Product product;

    
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
    
    public void setProduct(Product p){
    	product = p;
    }
    
    public Product getProduct(){
    	return product;
    }

    
    
    
  
}
