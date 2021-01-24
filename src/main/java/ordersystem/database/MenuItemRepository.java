package ordersystem.database;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ordersystem.model.MenuItem;

/**
 * @author Mian Munawar
 *
 */
public interface MenuItemRepository extends CrudRepository<MenuItem, Long> {
	
	public List<MenuItem> findByMenuName(String name);
}
