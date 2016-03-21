package records;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import shop.Cart;
import shop.CartItem;

import java.util.List;

import javax.annotation.PostConstruct;

@ManagedBean
@ApplicationScoped
public class ProductView {
	
   
	@ManagedProperty("#{productService}")
    private ProductService store;
	private List<Product> products;
	private Cart cart;
  
   

	
	public ProductService getStore() {
		return store;
	}


	public void setStore(ProductService store) {
		this.store = store;
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
    	return "./ProductOutput.xhtml";
    }
	
	private Product product;
    
    @PostConstruct
    public void makeProduct(){
    	System.out.println("YOU HAVE RUN ProductView !!!!!!!!!!!!!!!!!!!!!!!! ");
    	product = new Product();
    	System.out.println("postconstruct product");
    	products = store.findAll();
    	cart = new Cart();
    }
    
    public void remove(Product p) {
		store.remove(p);
		products = store.findAll();
		FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Product removed!", null));
	}
    
    public void addToCart(Product p){
    	System.out.println("Called ProductView.addToCart");
    	cart.add(1, p);
    	
    	
    }
    
    public void removeFromCart(CartItem c){
    	cart.deleteItem(c);
    }
    
   public List<CartItem> getCartitems(){
	  /* ArrayList<CartItem> l = cart.getCart();
	   if (l.size() == 0){
		   CartItem x = new CartItem(1,new Product());
		   l.add(x);
		   return l;
	   }*/
	   return cart.getCart();
   }
    
    public Product getProduct() {
		return product;
	}

    

	public void setProduct(Product product) {
		this.product = product;
	}

	
	
}