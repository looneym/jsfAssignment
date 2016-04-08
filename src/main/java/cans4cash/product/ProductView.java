package cans4cash.product;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
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

	private Product product;
	private Customer customer;
	private CustomerOrder order;
	private List<CartItem> orderItems;
	private List<Product> products;
	private List<CartItem> cart;
	private double cartTotal;
	
	// CartTotal is the total of all of the CartItems combined
	// Initialized at 0 each time 
	public double getCartTotal() {
		cartTotal = 0;
		for (int i = 0; i < cart.size(); i++) {
			CartItem item = cart.get(i);
			cartTotal = cartTotal + item.getTotal();
		}
		return cartTotal;
	}

	public String makeOrder() {

		CustomerOrder order = new CustomerOrder();
		if (cart.isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "You cannot make an order with no items in it", null));
			return "/shopNow.xhtml";
		}
		for (int i = 0; i < cart.size(); i++) {
			CartItem item = cart.get(i);
			System.out.println(item.toString());
			cartItemStore.save(item);
			order.addItem(item);
		}

		try {
			customer = customerStore.findAll().get(0);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "You cannot make an order without loggin in", null));
			return "/Login.xhtml";
		}
		order.setCustomer(customer);
		orderStore.save(order);
		cart.clear();
		return "/PostCheckout.xhtml";

	}

	public List<CartItem> getOrderItems() {
		List<CustomerOrder> orders = orderStore.findAll();
		order = orders.get(0);
		orderItems = order.getItems();
		return orderItems;

	}

	public CustomerOrder getOrder() {
		List<CustomerOrder> orders = orderStore.findAll();
		order = orders.get(0);
		return order;
	}

	public String add() {
		store.save(product);
		product = new Product();
		return "/AllProducts.xhtml";
	}

	@PostConstruct
	public void makeProduct() {
		product = new Product();
		products = store.findAll();
		cart = new ArrayList<CartItem>();
	}

	// Remove a Product from the DB. Will not complete if Product has been ordered by a Customer
	public void remove(Product p) {
		try {
			store.remove(p);
			products = store.findAll();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Product removed!", null));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Unable to delete product. It exists as a foreign key in orders table", null));

		}
	}

	// Add a Product to the Cart. If it has been previously added, the quantity of the CartItem is incremented,
	// otherwise a new CartItem is created
	public void addToCart(Product p) {
		for (int i = 0; i < cart.size(); i++) {
			CartItem item = cart.get(i);
			if (item.getProduct().getId() == p.getId()) {
				item.incrementQuantity();
				return;
			}
		}
		CartItem item = new CartItem(1, p);
		cart.add(item);

	}

	// For an existing CartItem, increment the number of products
	public void addOne(CartItem item) {
		item.incrementQuantity();

	}

	// For an existing CartItem, decrement the number of products
	public void removeOne(CartItem item) {
		if (item.getQuantity() <= 1) {
			removeFromCart(item);

		} else {
			item.decrementQuantity();
		}

	}

	// For an existing CartItem, remove it entirely from the Cart
	public void removeFromCart(CartItem c) {
		cart.remove(c);
	}

	public List<CartItem> getCart() {
		return cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public CustomerService getCustomerStore() {
		return customerStore;
	}

	public void setCustomerStore(CustomerService customerStore) {
		this.customerStore = customerStore;
	}

	public ProductService getStore() {
		return store;
	}

	public void setStore(ProductService store) {
		this.store = store;
	}

	public void setCartItemStore(CartItemService cartItemStore) {
		this.cartItemStore = cartItemStore;
	}

	public CartItemService getCartItemStore() {
		return cartItemStore;
	}

	public void setOrderStore(OrderService orderStore) {
		this.orderStore = orderStore;
	}

	public OrderService getOrderStore() {
		return orderStore;
	}

	public List<Product> getProducts() {
		products = store.findAll();
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}