package records;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class xxInitDbService {

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
