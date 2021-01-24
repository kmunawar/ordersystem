package ordersystem.database;

import org.springframework.data.repository.CrudRepository;

import ordersystem.model.CustomerOrder;

/**
 * @author Mian Munawar
 *
 */
public interface CustomerOrderRepository extends CrudRepository<CustomerOrder, Long> {

}
