package ordersystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ordersystem.database.UserRoleRepository;
import ordersystem.model.UserRole;

/**
 * @author Mian Munawar
 *
 */
@Service
public class UserRoleService {
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	public List<UserRole> getAllUserRoles() {
		List<UserRole> userRoles = new ArrayList<UserRole>();
		userRoleRepository.findAll().forEach(userRoles::add);
		return userRoles;
	}

	public UserRole getUserRole(String userName) {
		 return userRoleRepository.findById(userName).get();
	}
	
	public void addUserRole(UserRole userRole) {
		userRoleRepository.save(userRole);
	}
	
	public void updateUser(UserRole userRole, String userName) {
		userRoleRepository.save(userRole);
	}	
	
	public void deleteUserRole(String userName) {
		userRoleRepository.deleteById(userName);
	}	

}
