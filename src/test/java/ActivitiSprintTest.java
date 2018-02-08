import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-activiti.xml"})
public class ActivitiSprintTest {

	@Autowired
	ProcessEngine processEngine;

	@Test
	public void deploy(){
		/*RepositoryService service = processEngine.getRepositoryService();
		Deployment deploy = service.createDeployment().addClasspathResource("classpath*:process_inlineMode.bpmn").deploy();
		System.out.println(deploy);*/
	}


}
