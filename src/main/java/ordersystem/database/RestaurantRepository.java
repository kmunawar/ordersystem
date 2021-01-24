package ordersystem.database;

import org.springframework.data.repository.CrudRepository;

import ordersystem.model.Restaurant;

/**
 * @author Mian Munawar
 *
 */
public interface RestaurantRepository  extends CrudRepository<Restaurant, String> {

}
