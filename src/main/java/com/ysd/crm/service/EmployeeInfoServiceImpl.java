package com.ysd.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.crm.dao.EmployeeInfoMapper;
import com.ysd.crm.entity.Employee;

@Service
public class EmployeeInfoServiceImpl implements EmployeeInfoService{

	@Autowired
	private EmployeeInfoMapper empinfo;
	@Override
	public List<Employee> selectEmployeeInfo(Employee employee) {
		// TODO Auto-generated method stub
		return empinfo.selectEmployeeInfo(employee);
	}


}
