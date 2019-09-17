package com.ysd.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.crm.dao.IndexTreeMapper;
import com.ysd.crm.entity.Employee;
import com.ysd.crm.entity.Modules;
@Service
public class IndexTreeServiceImpl implements IndexTreeService{

	 	@Autowired
	    private IndexTreeMapper indexTreeMapper;

	    @Override
	    public List<Modules> selectEmployeeAllModules(Employee employee) {
	        // TODO Auto-generated method stub
	        
	        List<Modules> list = indexTreeMapper.selectEmployeeAllModules(employee);
	        
	        return list;
	    }
	    
	    @Override
	    public String selectProtectMTelByLoginName(Employee employee) {
	        // TODO Auto-generated method stub
	        
	        String phoneNumber = indexTreeMapper.selectProtectMTelByLoginName(employee);
	        
	        return phoneNumber;
	    }
	    
	    @Override
	    public String selectFingerprintNumByLoginName(Employee employee) {
	        // TODO Auto-generated method stub
	        
	        String fingerPrintnumber = indexTreeMapper.selectFingerprintNumByLoginName(employee);
	        
	        return fingerPrintnumber;
	    }

	    @Override
	    public Integer updatePasswordByLoginName(Employee employee) {
	        // TODO Auto-generated method stub
	        
	        Integer i = indexTreeMapper.updatePasswordByLoginName(employee);
	        
	        return i;
	    }

	    @Override
	    public Integer selectIsOldPasswordSame(Employee employee) {
	        // TODO Auto-generated method stub
	        
	        Integer i = indexTreeMapper.selectIsOldPasswordSame(employee);
	        
	        return i;
	    }

}
