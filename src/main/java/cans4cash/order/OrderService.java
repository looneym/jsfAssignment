package cans4cash.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public List<CustomerOrder> findAll() {
		return orderRepository.findAll();
	}

	public void save(CustomerOrder order) {
		orderRepository.save(order);
	}

	public void remove(CustomerOrder order) {
		orderRepository.delete(order);
	}

}
