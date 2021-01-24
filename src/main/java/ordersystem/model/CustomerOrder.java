package ordersystem.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 * @author Mian Munawar
 *
 */
@Entity
public class CustomerOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double tax;
	private Double deliveryCharge;
	private Double totalPrice;
	private Long deliveryTimeMins; 
	private boolean pickedUp;
	private boolean delivered;

	@ManyToOne
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "order_id")
	private List<OrderItem> orderItems;
	

	public CustomerOrder() {
		super();
	}

	public CustomerOrder(Long id, Double totalPrice, Double deliveryCharge, Long deliveryTimeMins, boolean pickedUp,
			boolean delivered, Customer customer, List<OrderItem> orderItems) {
		super();
		this.id = id;
		this.deliveryCharge = deliveryCharge;
		this.totalPrice = totalPrice;
		this.deliveryTimeMins = deliveryTimeMins;
		this.pickedUp = pickedUp;
		this.delivered = delivered;
		this.customer = customer;
		this.orderItems = orderItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isPickedUp() {
		return pickedUp;
	}

	public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
	}

	public boolean isDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Double getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(Double deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

	public Long getDeliveryTimeMins() {
		return deliveryTimeMins;
	}

	public void setDeliveryTimeMins(Long deliveryTime) {
		this.deliveryTimeMins = deliveryTime;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}
	
	
}
