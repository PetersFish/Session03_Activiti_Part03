package service;

import org.springframework.stereotype.Service;
import pojo.User;

import java.util.List;

@Service
public interface IUserService {
	List<User> selectUserByAttribute(User user);
}
