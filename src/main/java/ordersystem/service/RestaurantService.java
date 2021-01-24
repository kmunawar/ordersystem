package ordersystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ordersystem.database.RestaurantRepository;
import ordersystem.exceptions.MenuNotFoundException;
import ordersystem.model.Restaurant;

/**
 * @author Mian Munawar
 *
 */
@Service
public class RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;

	public List<Restaurant> getAllRestaurants() {
		List<Restaurant> menus = new ArrayList<Restaurant>();
		restaurantRepository.findAll().forEach(menus::add);
		return menus;
	}	
	
	public void addRestaurant(Restaurant menu) {
		restaurantRepository.save(menu);
	}	

	public Restaurant getRestaurant(String name) {
		try {
			Restaurant menu = restaurantRepository.findById(name).get();
			return menu;
		} catch (Exception e) {
			throw new MenuNotFoundException(e.getMessage(), e);
		}
	}
	
	public void updateRestaurant(Restaurant menu, String id) {
		restaurantRepository.save(menu);
	}
	
	public void deleteRestaurant(String name) {
		restaurantRepository.deleteById(name);
	}	
}
