package com.ysd.crm.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysd.crm.entity.Employee;
import com.ysd.crm.entity.EmployeeCheck;
import com.ysd.crm.service.RegisterService;

@Controller
public class RegisterController {
    
    @Autowired
    private RegisterService registerService;
    
    @RequestMapping(value="/register",method=RequestMethod.POST)
    @ResponseBody
    public Integer register(Employee employee) {
        
        Integer i = registerService.insertEmployeeCheck(employee);
        
        return i;
    }
    
    
    @RequestMapping(value="/signBack",method=RequestMethod.POST)
    @ResponseBody
    public Integer signBack(Employee employee) {
        
        Integer i = registerService.updateEmployeeCheck(employee);
        
        return i;
    }
    
}
