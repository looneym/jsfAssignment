package cans4cash.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public void save(Product prod) {
		productRepository.save(prod);
	}

	public void remove(Product prod) {
		productRepository.delete(prod);
	}

}

