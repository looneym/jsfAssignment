package cans4cash.customer;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;


import cans4cash.cart.CartItem;

import java.util.List;

import javax.annotation.PostConstruct;

@ManagedBean
@ApplicationScoped
public class CustomerView {
	
   
	@ManagedProperty("#{customerService}")
    private CustomerService store;
	private List<Customer> customers;
  
   

	
	public CustomerService getStore() {
		return store;
	}


	public void setStore(CustomerService store) {
		this.store = store;
	}


	public List<Customer> getCustomers() {
		customers = store.findAll();
		return customers;
	}


	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}


	public String add(){
		store.save(customer);
		System.out.println(" saved customer: "+customer.toString());
		customer = new Customer();
    	System.out.println("add to store");
//    	return "./viewAndBuy.xhtml";
    	return "/AllCustomers.xhtml";
//    	return "/AdminDashboard.xhtml";
    }
	
	public String login(){
		store.save(customer);
		System.out.println(" saved customer: "+customer.toString());
		customer = new Customer();
    	System.out.println("add to store");
    	return "/LoggedIn.xhtml";
    }
	
	private Customer customer;
    
    @PostConstruct
    public void makeCustomer(){
    	System.out.println("YOU HAVE RUN CustomerView !!!!!!!!!!!!!!!!!!!!!!!! ");
    	customer = new Customer();
    	System.out.println("postconstruct customer");
    	customers = store.findAll();
    }
    
    public void remove(Customer p) {
		store.remove(p);
		customers = store.findAll();
		FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Customer removed!", null));
	}
    

    
 

    
    public Customer getCustomer() {
		return customer;
	}

    

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	
}