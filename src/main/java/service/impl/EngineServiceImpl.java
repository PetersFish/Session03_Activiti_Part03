package service.impl;

import mapper.DeployModeMapper;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.DeployMode;
import pojo.Leave;
import pojo.User;
import service.IEngineService;
import service.ILeaveService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EngineServiceImpl implements IEngineService {

	@Autowired
	DeployModeMapper mapper;

	@Autowired
	ProcessEngine engine;

	@Autowired
	ILeaveService leaveService;

	@Override
	public DeployMode selectById(DeployMode deployMode) {
		return mapper.selectByPrimaryKey(deployMode.getId());
	}

	@Override
	public Deployment deploy(String mode) {
		RepositoryService service = engine.getRepositoryService();
		DeploymentBuilder deploymentBuilder = service.createDeployment().addClasspathResource(mode);
		Deployment deploy = deploymentBuilder.name("inlineMode").category("inlineMode").deploy();
		return deploy;
	}

	@Override
	public ProcessInstance startProcess(Deployment deployment, String businessKey, Map<String, Object> map) {
		RuntimeService runtimeService = engine.getRuntimeService();
		RepositoryService repositoryService = engine.getRepositoryService();
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).singleResult();

		ProcessInstance processInstance = runtimeService.startProcessInstanceById(processDefinition.getId(),businessKey,map);

		return processInstance;
	}

	@Override
	public void completeTask(ProcessInstance processInstance, String businessKey) {
		TaskService taskService = engine.getTaskService();
		Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).processInstanceBusinessKey(businessKey).singleResult();
		taskService.complete(task.getId());
	}

	@Override
	public List<Task> taskQuery(User user) {
		TaskService taskService = engine.getTaskService();
		List<Task> taskList = taskService.createTaskQuery().taskAssignee(user.getUsername()).list();
		return taskList;
	}

	@Override
	public List<Leave> leaveQuery(List<Task> taskList) {

		//初始化信息
		HistoryService historyService = engine.getHistoryService();
		TaskService taskService = engine.getTaskService();
		List<Leave> leaveList = new ArrayList<>();
		Leave leave = null;

		if (taskList != null) {
			//迭代获取leaveList
			for (Task task : taskList) {
				//通过task获取businessKey
				HistoricProcessInstance processInstance = historyService.createHistoricProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
				String businessKey = processInstance.getBusinessKey();

				//通过businessKey获取leave信息，并将leave放入list
				leave = leaveService.selectByPrimaryKey(businessKey);
				leaveList.add(leave);
			}

		}
		return leaveList;
	}

	@Override
	public Task taskQueryByBusinessKey(String businessKey, String assignee) {
		//通过businessKey获得processInstanceId
		HistoryService historyService = engine.getHistoryService();
		HistoricProcessInstance processInstance = historyService.createHistoricProcessInstanceQuery().processInstanceBusinessKey(businessKey).singleResult();

		//通过processInstance，以及assignee获得task
		TaskService taskService = engine.getTaskService();
		Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).taskAssignee(assignee).singleResult();
		return task;
	}

	@Override
	public void completeTask(String id) {
		TaskService taskService = engine.getTaskService();
		taskService.complete(id);
	}

}
