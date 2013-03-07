package support.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import support.dao.UserDao;
import support.domain.entity.User;
@Service
@Transactional
public class UserServiceImp implements UserService {
	@Autowired
	UserDao userDao;
	

	@Override
	public User findByNumber(String userId) {
		return userDao.findById(userId);
	}

	@Override
	public void create(User userDetails) {
		userDao.save(userDetails);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

}
