package ordersystem.model;


import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * @author Mian Munawar
 *
 */
@Entity
public class Customer {
	
	@Id
	private String userName;
	private String fullName;
	private String address;
	private Double distanceFromRestaurant;

	
	public Customer() {
		super();
	}

	public Customer(String userName, String fullName, String address, Double distanceFromRestaurant) {
		super();
		this.userName = userName;
		this.fullName = fullName;
		this.address = address;
		this.distanceFromRestaurant = distanceFromRestaurant;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getDistanceFromRestaurant() {
		return distanceFromRestaurant;
	}

	public void setDistanceFromRestaurant(Double distanceFromRestaurant) {
		this.distanceFromRestaurant = distanceFromRestaurant;
	}

}
