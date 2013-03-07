package support.service;

import java.util.List;

import support.domain.entity.User;

public interface UserService {
	
	User findByNumber(String userId);

	void create(User userDetails);
	
	List<User> findAll();

}
