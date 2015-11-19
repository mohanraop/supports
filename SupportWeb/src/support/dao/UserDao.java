/**
 * 
 */
package support.dao;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

/**
 * @author Samatha
 *
 */

@Repository("userDao")
public class UserDao extends AbstractBaseDao implements UserDetailsService {

	@Override
	public Class<?> getDomainClass() {
		return support.domain.entity.User.class;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Collection<GrantedAuthority> authorities=  new ArrayList<GrantedAuthority>();
		authorities.add(new GrantedAuthorityImpl("ROLE_USER"));
		SimpleSearchCriteria criteria = new SimpleSearchCriteria();
		criteria.addEqual("userName", username);
		try{
		//support.domain.entity.User userV = findFirst(criteria);
		UserDetails user = new User(username, username, true, true, true, true,authorities);
		return user;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
