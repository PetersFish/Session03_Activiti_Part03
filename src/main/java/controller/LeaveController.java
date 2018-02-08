package controller;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Leave;
import pojo.User;
import service.IEngineService;
import service.ILeaveService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/leave")
public class LeaveController {

	@Autowired
	ILeaveService leaveService;

	@Autowired
	IEngineService engineService;

	//提交申请
	@ResponseBody
	@RequestMapping("/submitleave.do")
	public String submitLeave(Leave leave, HttpSession session){

		//从session获得user对象
		User user = (User) session.getAttribute("sessionUser");
		Map<String,Object> map = new HashMap<>();
		map.put("username",user.getUsername());

		//给leave分配id
		String id = UUID.randomUUID().toString().replace("-","");
		String businessKey = id;
		leave.setId(id);
		leave.setUid(user.getId());

		//从session获得deployment对象
		Deployment deployment = (Deployment) session.getAttribute("deployment");

		//插值前开启process
		ProcessInstance processInstance = engineService.startProcess(deployment,businessKey,map);

		//进行插值
		int flag = leaveService.insertSelective(leave);

		if (flag > 0){
			//完成task
			engineService.completeTask(processInstance,businessKey);

			return "1";
		}
		return "0";
	}
}
