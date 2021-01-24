package ordersystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ordersystem.database.OrderItemRepository;
import ordersystem.model.OrderItem;

/**
 * @author Mian Munawar
 *
 */
@Service
public class OrderItemService {
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public List<OrderItem> getAllOrderItems(Long id) {
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		orderItemRepository.findAll().forEach(orderItems::add);
		return orderItems;
	}
	
	public OrderItem getOrderItem(Long id) {
		return orderItemRepository.findById(id).get();
	}
	
	public void addOrderItem(OrderItem orderItem) {
		orderItemRepository.save(orderItem);
	}
	
	public void updateOrderItem(OrderItem orderItem) {
		orderItemRepository.save(orderItem);
	}

	public void deleteOrderItem(Long id) {
		orderItemRepository.deleteById(id);
	}
}