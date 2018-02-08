package controller;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.DeployMode;
import pojo.Leave;
import pojo.User;
import service.IEngineService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/engine")
public class EngineController {

	@Autowired
	IEngineService engineService;

	@ResponseBody
	@RequestMapping("/deployment.do")
	public String doeployment(DeployMode deployMode, HttpSession session){

		//通过部署模式的信息进行部署
		deployMode = engineService.selectById(deployMode);
		String mode = deployMode.getName();
		Deployment deployment = engineService.deploy(mode);

		//将部署对象存入session
		session.setAttribute("deployment",deployment);
		return "1";
	}

	//查询task列表
	@ResponseBody
	@RequestMapping("/taskQuery.do")
	public String taskQuery(HttpSession session){

		//获取user
		User user = (User) session.getAttribute("sessionUser");

		//查询task列表
		List<Task> taskList = engineService.taskQuery(user);

		//通过task实例查找请假信息
		List<Leave> leaveList = engineService.leaveQuery(taskList);

		//将leaveList放入session
		session.setAttribute("leaveList",leaveList);

		return "1";
	}

	//完成task
	@ResponseBody
	@RequestMapping("/taskComplete.do")
	public String taskComplete(HttpSession session, Leave leave){
		//通过businessKey,以及assignee获得task
		String businessKey = leave.getId();
		User user = (User) session.getAttribute("sessionUser");
		String assignee = user.getUsername();

		Task task = engineService.taskQueryByBusinessKey(businessKey,assignee);

		//完成task
		engineService.completeTask(task.getId());
		session.removeAttribute("leaveList");
		return "1";
	}
}
