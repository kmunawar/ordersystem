package ordersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ordersystem.database.TaxRateRepository;
import ordersystem.model.TaxRate;

/**
 * @author Mian Munawar
 *
 */
@Service
public class TaxRateService {

	@Autowired
	private TaxRateRepository taxRateRepository;
	
	public TaxRate getTaxRate(Long id) {
		return taxRateRepository.findById(id).get();
	}	

}
