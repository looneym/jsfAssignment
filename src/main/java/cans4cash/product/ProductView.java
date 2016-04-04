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
	
	
	public CustomerService getCustomerStore() {
		return customerStore;
	}




	public void setCustomerStore(CustomerService customerStore) {
		this.customerStore = customerStore;
	}

	private List<Product> products;
	private List<CartItem> cart;
	
	public void makeOrder(){
		
		CustomerOrder order = new CustomerOrder();
		System.out.println("Yo! here's the cart:");
		for (int i = 0; i<cart.size();i++){
			CartItem item = cart.get(i);
			System.out.println(item.toString());
			cartItemStore.save(item);
			order.addItem(item);
		}
		order.setCustomer(customer);
		orderStore.save(order);
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
    	customer = new Customer("John", "password");
    	customerStore.save(customer);
    }
    
    public void remove(Product p) {
		store.remove(p);
		products = store.findAll();
		FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Product removed!", null));
	}
    
    public void addToCart(Product p){
    	System.out.println("Called ProductView.addToCart");
    	System.out.println(p);
    	CartItem item = new CartItem(1 ,p);
    	cart.add(item);
    	
    	
    }
    
    public void removeFromCart(CartItem c){
    	cart.remove(c);
    }
    
   public List<CartItem> getCartitems(){
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