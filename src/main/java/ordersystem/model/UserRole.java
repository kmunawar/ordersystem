package ordersystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Mian Munawar
 *
 */
@Entity
public class UserRole {
	
	@Id
	private String userName;
	private String UserRole;
	
	public UserRole() {
		super();
	}
	
	public UserRole(String userName, String userRole) {
		super();
		this.userName = userName;
		UserRole = userRole;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserRole() {
		return UserRole;
	}
	
	public void setUserRole(String userRole) {
		UserRole = userRole;
	}
	
	

}
