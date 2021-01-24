package ordersystem.database;

import org.springframework.data.repository.CrudRepository;

import ordersystem.model.TaxRate;

/**
 * @author Mian Munawar
 *
 */
public interface TaxRateRepository extends CrudRepository<TaxRate, Long> {

}
