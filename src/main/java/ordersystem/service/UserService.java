package ordersystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ordersystem.database.UserRepository;
import ordersystem.model.AppUser;

/**
 * @author Mian Munawar
 *
 */
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<AppUser> getAllUsers() {
		List<AppUser> users = new ArrayList<AppUser>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	public AppUser getUser(String userName) {
		Optional<AppUser> optional =  userRepository.findById(userName);
		if (!optional.isPresent()) {
			optional = Optional.of(new AppUser("", "", ""));
		}
		return optional.get();
	}

	public void addUser(AppUser user) {
		userRepository.save(user);
	}
	
	public void updateUser(AppUser user, String userName) {
		userRepository.save(user);
	}	
	
	public void deleteUser(String userName) {
		userRepository.deleteById(userName);
	}
}
