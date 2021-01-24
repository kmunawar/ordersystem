package ordersystem.database;

import org.springframework.data.repository.CrudRepository;

import ordersystem.model.AppUser;

/**
 * @author Mian Munawar
 *
 */
public interface UserRepository extends CrudRepository<AppUser, String> {

}
