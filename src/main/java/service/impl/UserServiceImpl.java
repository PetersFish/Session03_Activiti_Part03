package service.impl;

import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;
import service.IUserService;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserMapper mapper;

	@Override
	public List<User> selectUserByAttribute(User user) {
		return mapper.selectUserByAttribute(user);
	}
}
