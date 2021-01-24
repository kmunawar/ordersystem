package ordersystem.database;

import org.springframework.data.repository.CrudRepository;

import ordersystem.model.Customer;

/**
 * @author Mian Munawar
 *
 */
public interface CustomerRepository  extends CrudRepository<Customer, String> {

}
