package service;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;
import pojo.DeployMode;
import pojo.Leave;
import pojo.User;

import java.util.List;
import java.util.Map;

@Service
public interface IEngineService {

	//通过id获取部署模式
	DeployMode selectById(DeployMode deployMode);

	//通过制定模式进行部署
	Deployment deploy(String mode);

	//开启流程
	ProcessInstance startProcess(Deployment deployment, String businessKey, Map<String, Object> map);

	//完成task
	void completeTask(ProcessInstance processInstance, String businessKey);

	//查询用户task列表
	List<Task> taskQuery(User user);

	//通过task列表获得leave列表
	List<Leave> leaveQuery(List<Task> taskList);

	//通过businessKey查询task
	Task taskQueryByBusinessKey(String businessKey, String assignee);

	//通过taskId结束task
	void completeTask(String id);
}
