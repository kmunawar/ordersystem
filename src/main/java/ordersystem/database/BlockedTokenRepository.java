package ordersystem.database;

import org.springframework.data.repository.CrudRepository;

import ordersystem.model.BlockedToken;

/**
 * @author Mian Munawar
 *
 */
public interface BlockedTokenRepository extends CrudRepository<BlockedToken, String> {

}
