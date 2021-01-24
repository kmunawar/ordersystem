package ordersystem.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ordersystem.model.AppUser;
import ordersystem.model.UserRole;
import ordersystem.service.UserRoleService;
import ordersystem.service.UserService;


/**
 * @author Mian Munawar
 *
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRoleService userRoleService;

	/**
	 * This method creates the grant list for user. This grant list allows user access to certain
	 * features.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AppUser appUser = userService.getUser(username);
		UserRole userRole = userRoleService.getUserRole(username);
		
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		grantList.add(new SimpleGrantedAuthority(userRole.getUserRole()));
		
		return new User(appUser.getUserName(), appUser.getPassword(), grantList);		
		
	}
	
	
	

}
