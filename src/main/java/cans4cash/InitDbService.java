package cans4cash;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cans4cash.cart.CartItemRepository;
import cans4cash.customer.CustomerRepository;
import cans4cash.order.OrderRepository;
import cans4cash.product.Product;
import cans4cash.product.ProductRepository;


@Service
public class InitDbService {

	@Autowired
	private ProductRepository productRepository;

	@PostConstruct
	public void init() {
		System.out.println("*** INIT DATABASE START ***");
		{
			Product a = new Product();
			a.setName("Heineken");
			a.setDescription("A slightly more expensive can, popular amongst the middle-aged");
		    a.setPrice(1.99);
		    a.setImageFile("/img1");
			productRepository.save(a);
		}
		{
			Product b = new Product();
			b.setName("Orangeboom");
			b.setDescription("A suspiciously cheap can");
		    b.setPrice(.65);
		    b.setImageFile("/img2");
			productRepository.save(b);
		}
		{
			Product c = new Product();
			c.setName("Prazky");
			c.setDescription("A solid, reliable can at a reasonable price");
		    c.setPrice(1.25);
		    c.setImageFile("/img3");
			productRepository.save(c);
		}
		System.out.println("*** INIT DATABASE FINISH ***");
	}
}
