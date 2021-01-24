package ordersystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ordersystem.model.Restaurant;
import ordersystem.service.RestaurantService;

/**
 * @author Mian Munawar
 *
 */
@RestController
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@RequestMapping("/restaurants")
	public List<Restaurant> getAllRestaurants() {
		
		return restaurantService.getAllRestaurants();
	}
	
	@RequestMapping("/restaurants/{name}")
	public Restaurant getRestaurant(@PathVariable String name) {
		return restaurantService.getRestaurant(name);
	}
	
}
