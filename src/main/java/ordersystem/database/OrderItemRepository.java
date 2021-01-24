package ordersystem.database;

import org.springframework.data.repository.CrudRepository;

import ordersystem.model.OrderItem;

/**
 * @author Mian Munawar
 *
 */
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
	
}
