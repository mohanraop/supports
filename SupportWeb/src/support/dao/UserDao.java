/**
 * 
 */
package support.dao;

import org.springframework.stereotype.Repository;

import support.domain.entity.User;

/**
 * @author Samatha
 *
 */

@Repository("userDao")
public class UserDao extends AbstractBaseDao{

	@Override
	public Class<?> getDomainClass() {
		return User.class;
	}
	
	

}
