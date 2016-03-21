package shop;


import java.util.ArrayList;

import records.Product;

public class Cart {
	private  ArrayList<CartItem> cart;
	
    public Cart(){
    	cart = new ArrayList<CartItem>();
    }

	public  ArrayList<CartItem> getCart() {
		return cart;
	}
	public void add(int qty,Product p){
		System.out.println("Called Cart.add");
	    cart.add(new CartItem(qty,p));
	}
	
	public void deleteItem(CartItem c){
		cart.remove(c);
	}
	
	public void Print(){
		 for (int y=0;y<cart.size();y++){
	      	CartItem item = cart.get(y);
	  	    item.Print();
	      	}
	}
	
}
