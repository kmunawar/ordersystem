package ordersystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ordersystem.database.CustomerOrderRepository;
import ordersystem.database.CustomerRepository;
import ordersystem.database.MenuItemRepository;
import ordersystem.database.TaxRateRepository;
import ordersystem.exceptions.CustomerOrderNotFoundException;
import ordersystem.model.Customer;
import ordersystem.model.CustomerOrder;
import ordersystem.model.MenuItem;
import ordersystem.model.OrderItem;

/**
 * @author Mian Munawar
 *
 */
@Service
public class CustomerOrderService {
	
	@Autowired
	private CustomerOrderRepository customerOrderRepository;
	
	@Autowired
	private MenuItemRepository menuItemRepository;
	
	@Autowired
	private TaxRateRepository taxRateRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<CustomerOrder> getAllOrders() {
		List<CustomerOrder> orders = new ArrayList<CustomerOrder>();
		customerOrderRepository.findAll().forEach(orders::add);
		return orders;	
	}

	public void addOrder(CustomerOrder order) {
		
		/*
		 * Calculate and set the delivery time estimate. 
		 */
		
		// Get the total food preparation time.
		Integer totalPrepTime = 0;
		
		for (OrderItem orderItem : order.getOrderItems()) {
			MenuItem menuItem = orderItem.getMenuItem();
			totalPrepTime += this.menuItemRepository.findById(menuItem.getId()).get().getPrepTime() * orderItem.getQuantity();
		}		
		
		// Calculate the travel time.
		Optional<Customer> customer = this.customerRepository.findById(order.getCustomer().getUserName());
		Double deliveryTime = customer.get().getDistanceFromRestaurant() / 40 * 60; // time (hours)= distance (kilometers) / velocity (kilometers/hour) * 60 (minutes)
		order.setDeliveryTimeMins(deliveryTime.longValue() + totalPrepTime);

		/*
		 * Calculate and set the delivery charge. 
		 */
		Double deliveryCharge = 1.0 * customer.get().getDistanceFromRestaurant();
		order.setDeliveryCharge(deliveryCharge);
		
		/*
		 * Calculate and set the total price and tax.
		 */
		Double totalPrice = 0.0;
		
		for (OrderItem orderItem : order.getOrderItems()) {
			MenuItem menuItem = orderItem.getMenuItem();
			totalPrice += this.menuItemRepository.findById(menuItem.getId()).get().getPrice() * orderItem.getQuantity();
		}
		
		// Calculate tax.
		Double tax = (totalPrice + deliveryCharge) * (this.taxRateRepository.findById(1L).get().getRate() /100.0);
		tax = Math.round(tax * 100.0) / 100.0; // Rounded to 2 decimal places.
		order.setTax(tax);

		totalPrice += tax; // Tax added.
		totalPrice = Math.round(totalPrice * 100.0) / 100.0; // Rounded to 2 decimal places.
		order.setTotalPrice(totalPrice);
		
		/*
		 * Save the customer order.
		 */
		customerOrderRepository.save(order);
	}
	
	public CustomerOrder getOrder(Long id) {
		try {
			CustomerOrder order = customerOrderRepository.findById(id).get();
			return order;
		} catch (Exception e) {
			throw new CustomerOrderNotFoundException(e.getMessage(), e);
		}
	}

	public void updateOrder(CustomerOrder order, Long id /* not used */) {
		try {
			CustomerOrder savedOrder = getOrder(id);
			if (order.isPickedUp()) {savedOrder.setPickedUp(true);}
			if (order.isDelivered()) {savedOrder.setDelivered(true);}
			customerOrderRepository.save(savedOrder);
		} catch (Exception e) {
			throw new CustomerOrderNotFoundException(e.getMessage(), e);
		}
	}
	
	public void deleteOrder(Long id) {
		try {
			customerOrderRepository.deleteById(id);
		} catch (Exception e) {
			throw new CustomerOrderNotFoundException(e.getMessage(), e);
		}
	}	
}
