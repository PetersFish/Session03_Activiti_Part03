package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.User;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml"})
public class IUserServiceTest {

	@Autowired
	IUserService userService;

	@Autowired
	User user;

	@Test
	public void testSelect(){
		/*user.setUsername("Peter");
		user.setPassword("123");
		List<User> userList = userService.selectUserByAttribute(user);
		System.out.println(userList);*/
	}
}