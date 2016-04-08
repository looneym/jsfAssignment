package cans4cash.product;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;


import cans4cash.cart.CartItem;
import cans4cash.cart.CartItemService;
import cans4cash.customer.Customer;
import cans4cash.customer.CustomerService;
import cans4cash.order.CustomerOrder;
import cans4cash.order.OrderService;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

@ManagedBean
@ApplicationScoped
public class ProductView {
	
   
	@ManagedProperty("#{productService}")
    private ProductService store;
	
	@ManagedProperty("#{cartItemService}")
    private CartItemService cartItemStore;
	
	@ManagedProperty("#{orderService}")
	private OrderService orderStore;
	
	@ManagedProperty("#{customerService}")
	private CustomerService customerStore;
	
	private Customer customer;
	private CustomerOrder order;
	private List<CartItem> orderItems;
	
	
	public CustomerService getCustomerStore() {
		return customerStore;
	}




	public void setCustomerStore(CustomerService customerStore) {
		this.customerStore = customerStore;
	}

	private List<Product> products;
	private List<CartItem> cart;
	
	public String makeOrder(){
		
		CustomerOrder order = new CustomerOrder();
		System.out.println("Yo! here's the cart:");
		for (int i = 0; i<cart.size();i++){
			CartItem item = cart.get(i);
			System.out.println(item.toString());
			cartItemStore.save(item);
			order.addItem(item);
		}
		
		
		
		
		try {
			customer = customerStore.findAll().get(0);
		} catch(Exception e){
			FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "You cannot make an order without loggin in", null));
			return "/Login.xhtml";	
		}
		order.setCustomer(customer);
		orderStore.save(order);
		return "/PostCheckout.xhtml";
			

		
	}
	
	
	public List<CartItem> getOrderItems(){
		List<CustomerOrder> orders = orderStore.findAll();
		order = orders.get(0);
		orderItems = order.getItems();
		return orderItems;
		
	}
	
	public CustomerOrder getOrder(){
		List<CustomerOrder> orders = orderStore.findAll();
		order = orders.get(0);
		return order;
	}
  
   

	
	public ProductService getStore() {
		return store;
	}


	public void setStore(ProductService store) {
		this.store = store;
	}
	
	public void setCartItemStore(CartItemService cartItemStore){
		this.cartItemStore = cartItemStore;
	}
	
	public CartItemService getCartItemStore(){
		return cartItemStore;
	}
	
	public void setOrderStore(OrderService orderStore){
		this.orderStore = orderStore;
	}
	
	public OrderService getOrderStore(){
		return orderStore;
	}


	public List<Product> getProducts() {
		products = store.findAll();
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public String add(){
		store.save(product);
		System.out.println(" saved product: "+product.toString());
		product = new Product();
    	System.out.println("add to store");
//    	return "./viewAndBuy.xhtml";
    	return "/AllProducts.xhtml";
    }
	
	private Product product;
    
    @PostConstruct
    public void makeProduct(){
    	System.out.println("YOU HAVE RUN ProductView !!!!!!!!!!!!!!!!!!!!!!!! ");
    	product = new Product();
    	System.out.println("postconstruct product");
    	products = store.findAll();
    	cart = new ArrayList<CartItem>();
    }
    
    public void remove(Product p) {
    	try{
		store.remove(p);
		products = store.findAll();
		FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Product removed!", null));}
    	catch(Exception e){
    		FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Unable to delete product. It exists as a foreign key in orders table", null));
    		
    	}
	}
    
    public void addToCart(Product p){
    	System.out.println("Called ProductView.addToCart");
    	System.out.println(p);
    	for (int i = 0 ; i < cart.size() ; i++){
    		CartItem item = cart.get(i);
    		if (item.getProduct().getId() == p.getId()){
    			System.out.println("Incrementing");
    			item.incrementQuantity();
    			return;
    		}
    	}
    	
    	

		System.out.println("New cart item created");
    	CartItem item = new CartItem(1 ,p);
    	cart.add(item); 
    	
    	}
    	
    
    
    public void addOne(CartItem item){
    	item.incrementQuantity();
		
	}
    
    public void removeOne(CartItem item){
    	if (item.getQuantity() <= 1){
    		removeFromCart(item);
    		
    	} else {
    	item.decrementQuantity();
    	}
		
  	}
    	
    
    
    public void removeFromCart(CartItem c){
    	cart.remove(c);
    }
    
   public List<CartItem> getCart(){
	  /* ArrayList<CartItem> l = cart.getCart();
	   if (l.size() == 0){
		   CartItem x = new CartItem(1,new Product());
		   l.add(x);
		   return l;
	   }*/
	   System.out.println("getCartItems");
	   return cart;
   }
    
    public Product getProduct() {
		return product;
	}

    

	public void setProduct(Product product) {
		this.product = product;
	}

	
	
}