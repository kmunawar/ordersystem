package ordersystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ordersystem.model.AppUser;
import ordersystem.service.UserService;

/**
 * @author Mian Munawar
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public List<AppUser> getAllUsers() {
		
		return userService.getAllUsers();
	}

}
