package com.ysd.crm.service;

import java.util.List;

import com.ysd.crm.entity.Employee;

public interface EmployeeInfoService {
	/**
	 * 
	 * @param emp
	 * @return
	 */
	List<Employee> selectEmployeeInfo(Employee employee);
}
