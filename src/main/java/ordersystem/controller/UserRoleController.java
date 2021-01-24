package ordersystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ordersystem.model.UserRole;
import ordersystem.service.UserRoleService;

/**
 * @author Mian Munawar
 *
 */
@RestController
public class UserRoleController {
	
	@Autowired
	private UserRoleService userRoleService;
	
	@RequestMapping("/userroles")
	public List<UserRole> getAllUserRoles() {
		
		return userRoleService.getAllUserRoles();
	}	

}
