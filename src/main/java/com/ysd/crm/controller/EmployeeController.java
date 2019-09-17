﻿package com.ysd.crm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ysd.crm.entity.Employee;
import com.ysd.crm.entity.EmployeeRole;
import com.ysd.crm.entity.Message;
import com.ysd.crm.entity.Pagination;
import com.ysd.crm.entity.Role;
import com.ysd.crm.service.EmployeeService;
import com.ysd.crm.util.PasswordUtil;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private Pagination<Employee> pagination;
	
	@RequestMapping(value="/selectEmployee",method=RequestMethod.POST)
	@ResponseBody
	public Pagination<Employee> selectEmployee(Integer rows,Integer page, Employee employee,String in_e_createTime,String en_e_createTime){
		pagination.setPage((page-1)*rows);
		pagination.setPageSize(rows);
		pagination.setEmployee(employee);
		pagination.setIn_e_createTime(in_e_createTime);
		pagination.setEn_e_createTime(en_e_createTime);
		pagination=employeeService.selectEmployeeAll(pagination);
		return pagination;
	}
	
	@RequestMapping(value="/deleteEmployee",method=RequestMethod.POST)
	@ResponseBody
	public Integer deleteEmployee(Integer e_id) {
		return employeeService.deleteEmployee(e_id);
	}
	
	@RequestMapping(value="/updateEmployee",method=RequestMethod.POST)
	@ResponseBody
	public Integer updateEmployee(Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	
	@RequestMapping(value="/getAllRole",method=RequestMethod.POST)
    @ResponseBody
    public List<Role> getAllRole() {
	    
	    // 查询到的所有角色
	    List<Role> list = employeeService.selectAllRole();
	    
	    return list;
    }
	
	@RequestMapping(value="/getEmployeeRole",method=RequestMethod.POST)
    @ResponseBody
    public List<Role> getEmployeeRole(Employee employee) {
        
        // 查询到的所有角色
        List<Role> list = employeeService.selectEmployeeRoleByName(employee);
        
        return list;
    }
	
	@RequestMapping(value="/removeRoleToEmployee",method=RequestMethod.POST)
    @ResponseBody
	public Integer removeRoleToEmployee(@RequestParam("arr") String arr,EmployeeRole employeeRole,String name,String r_name) {
	  
	       return employeeService.insertRoleForEmployee(arr,employeeRole,name,r_name);
	}
	
	@RequestMapping(value="/removeEmployeeToAll",method=RequestMethod.POST)
    @ResponseBody
    public Integer removeEmployeeToAll(@RequestParam("arr") String arr,EmployeeRole employeeRole,String r_name,String name) {

        return employeeService.deleteRoleForEmployee(arr,employeeRole,r_name,name);
    }
	
	@RequestMapping(value="/resertPassword",method=RequestMethod.POST)
    @ResponseBody
    public Integer resertPassword(Employee employee) {
	    
	    String fingerpringNum = employeeService.selectFingerprintNumByLoginName(employee);
	    String MD5Password = PasswordUtil.generate("ysd123", fingerpringNum);
	    employee.setE_passWord(MD5Password);
	    Integer i = employeeService.updateEmployeePassword(employee);
        
        return i;
    }
	
	@RequestMapping(value="/setEmployeeLock",method=RequestMethod.POST)
    @ResponseBody
    public Integer setEmployeeLock(Employee employee) {
	    
	    Integer i = employeeService.updateEmployeeLock(employee);
        
        return i;
    }
	
	@RequestMapping(value="/setEmployeeUnLock",method=RequestMethod.POST)
    @ResponseBody
    public Integer setEmployeeUnLock(Employee employee) {
        
        Integer i = employeeService.updateEmployeeUnLock(employee);
        
        return i;
    }
	
	@RequestMapping(value="/selectSuoDingZhaungTaiCounts",method=RequestMethod.POST)
    @ResponseBody
    public List selectSuoDingZhaungTaiCount(String e_loginName) {
        return  employeeService.selectTongJiTu(e_loginName);
    }
	@RequestMapping(value="/qutongzhi",method=RequestMethod.POST)
    @ResponseBody
	public void selectStudentByIdEmpName(Integer tidsss,String name,String mess) {
		employeeService.selectStudentByIdEmpName(tidsss,name,mess);
		
	}
	@RequestMapping(value="/messa",method=RequestMethod.POST)
    @ResponseBody
	public List<Message> selectEmpByNameMessage(String e_loginName){
		
		return employeeService.selectEmpByname(e_loginName);
		
	}
	@RequestMapping(value="/messas",method=RequestMethod.POST)
    @ResponseBody
	public List<Message> selectEmpByNameMessages(String e_loginName){
		List<Message> selectEmpByname = employeeService.selectEmpByname(e_loginName);
		return selectEmpByname;
		
	}
	@RequestMapping(value="/messass",method=RequestMethod.POST)
    @ResponseBody
	public Integer updataMessage(Integer m_id){
		
		return employeeService.updateMessById(m_id);
		
	}
}
