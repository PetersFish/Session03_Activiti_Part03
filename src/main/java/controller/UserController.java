package controller;

import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Leave;
import pojo.User;
import service.IEngineService;
import service.IUserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	User user;

	@Autowired
	IUserService userService;

	@Autowired
	IEngineService engineService;

	//进入登录页面
	@RequestMapping("tologin.do")
	public String tologin(){
		return "login";
	}

	//跳转进入主页
	@RequestMapping("toindex.do")
	public String toindex(){
		return "index";
	}

	//进行登录操作
	@RequestMapping("/checklogin.do")
	public String doLogin(HttpSession session,User user){

		List<User> userList = userService.selectUserByAttribute(user);
		if (userList.size() != 0) {
			User sessionUser = userList.get(0);
			session.setAttribute("sessionUser",sessionUser);
			return "redirect:/user/toindex.do";
		}
		session.setAttribute("errMsg","用户名或密码错误");
		return "login";
	}

	//进行登出操作
	@RequestMapping("logout.do")
	public String logout(HttpSession session){
		session.removeAttribute("sessionUser");
		session.removeAttribute("leaveList");
		return "redirect:/user/tologin.do";
	}


}
