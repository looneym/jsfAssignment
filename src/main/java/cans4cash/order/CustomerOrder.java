package cans4cash.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import cans4cash.customer.Customer;
import cans4cash.cart.CartItem;

@Entity
public class CustomerOrder {
	
	private String date;
	
	@OneToOne
	private Customer customer;
	
	@OneToMany
	private List<CartItem> items;
	
	@GeneratedValue
	@Id
	private int id;
	
	public CustomerOrder(){
		items = new ArrayList<CartItem>();
		// Get today's date as a String
		date = new Date().toString();
		
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}
	
	public void addItem(CartItem item){
		items.add(item);
		
	}
	
	public void removeItem(CartItem item){
		items.remove(item);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
