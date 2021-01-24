package ordersystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Mian Munawar
 *
 */
@Entity
public class TaxRate {
	
	@Id
	private Long id;
	private Integer rate;
	
	
	public TaxRate() {
		super();
	}


	public TaxRate(Long id, Integer rate) {
		super();
		this.id = id;
		this.rate = rate;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getRate() {
		return rate;
	}


	public void setRate(Integer rate) {
		this.rate = rate;
	}

}
