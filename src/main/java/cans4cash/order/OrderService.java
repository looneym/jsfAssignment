package cans4cash.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	public void save(Order order) {
		orderRepository.save(order);
	}

	public void remove(Order order) {
		orderRepository.delete(order);
	}

}
