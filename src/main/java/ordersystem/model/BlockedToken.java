package ordersystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Mian Munawar
 *
 */
@Entity
public class BlockedToken {
	
	@Id
	private String token;
	
	
	public BlockedToken() {
		super();
	}

	public BlockedToken(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}	
	
}
