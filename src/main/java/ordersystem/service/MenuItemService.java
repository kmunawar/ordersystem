package ordersystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ordersystem.database.MenuItemRepository;
import ordersystem.model.MenuItem;

/**
 * @author Mian Munawar
 *
 */
@Service
public class MenuItemService {
	
	@Autowired
	private MenuItemRepository menuItemRepository;
	
	public List<MenuItem> getAllMenuItems(String name) {
		List<MenuItem> menuItems = new ArrayList<MenuItem>();
		menuItemRepository.findByMenuName(name).forEach(menuItems::add);
		return menuItems;
	}
	
	public MenuItem getMenuItem(Long id) {
		return menuItemRepository.findById(id).get();
	}
	
	public void addMenuItem(MenuItem menuItem) {
		menuItemRepository.save(menuItem);
	}
	
	public void updateMenuItem(MenuItem menuItem) {
		menuItemRepository.save(menuItem);
	}

	public void deleteMenuItem(Long id) {
		menuItemRepository.deleteById(id);
	}
}
