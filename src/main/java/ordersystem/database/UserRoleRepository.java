package ordersystem.database;

import org.springframework.data.repository.CrudRepository;

import ordersystem.model.UserRole;

/**
 * @author Mian Munawar
 *
 */
public interface UserRoleRepository extends CrudRepository<UserRole, String> {

}
