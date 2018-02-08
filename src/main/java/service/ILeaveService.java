package service;

import org.springframework.stereotype.Service;
import pojo.Leave;

@Service
public interface ILeaveService {

	//通过属性插入一条leave记录
	int insertSelective(Leave leave);

	//通过主键获得leave
	Leave selectByPrimaryKey(String businessKey);
}
