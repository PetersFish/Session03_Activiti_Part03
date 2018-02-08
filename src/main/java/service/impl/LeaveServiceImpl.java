package service.impl;

import mapper.LeaveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Leave;
import service.ILeaveService;

@Service
public class LeaveServiceImpl implements ILeaveService {

	@Autowired
	LeaveMapper mapper;

	@Override
	public int insertSelective(Leave leave) {

		return mapper.insertSelective(leave);
	}

	@Override
	public Leave selectByPrimaryKey(String businessKey) {

		return mapper.selectByPrimaryKey(businessKey);
	}
}
