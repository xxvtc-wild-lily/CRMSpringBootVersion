package com.ysd.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.crm.dao.SignlnMapper;
import com.ysd.crm.entity.Employee;
@Service
public class SignInServiceImpl implements SignInService{

	@Autowired
	private SignlnMapper signInMapper;

    @Override
    public Integer selectIsHaveSameLoginName(Employee employee) {
        // TODO Auto-generated method stub
        
        Integer i = signInMapper.selectIsHaveSameLoginName(employee);
        
        return i;
    }

    @Override
    public String selectFingerprintNumByLoginName(Employee employee) {
        // TODO Auto-generated method stub
        
        String fingerprintNum = signInMapper.selectFingerprintNumByLoginName(employee);
        
        return fingerprintNum;
    }

    @Override
    public Integer selectIsPasswordRight(Employee employee) {
        // TODO Auto-generated method stub
        
        Integer i = signInMapper.selectIsPasswordRight(employee);
        
        return i;
    }

    @Override
    public Integer updatePwdWrongTime(Employee employee) {
        // TODO Auto-generated method stub
        
        Integer i = signInMapper.updatePwdWrongTime(employee);
        
        return i;
    }

    @Override
    public Integer selectPwdWrongTime(Employee employee) {
        // TODO Auto-generated method stub
        
        Integer i = signInMapper.selectPwdWrongTime(employee);
        
        return i;
    }

    @Override
    public Integer updateEmployeeIsLockOut(Employee employee) {
        // TODO Auto-generated method stub
        
        Integer i = signInMapper.updateEmployeeIsLockOut(employee);
        
        return i;
    }

    @Override
    public Integer selectIsEmployeeLockOut(Employee employee) {
        // TODO Auto-generated method stub
        
        Integer i = signInMapper.selectIsEmployeeLockOut(employee);
        
        return i;
    }

    @Override
    public Integer updateLastLoginTime(Employee employee) {
        // TODO Auto-generated method stub
        
        Integer i = signInMapper.updateLastLoginTime(employee);
        
        return i;
    }

    @Override
    public Integer updatePwdWrongTimeWhenSuccess(Employee employee) {
        // TODO Auto-generated method stub
        
        Integer i = signInMapper.updatePwdWrongTimeWhenSuccess(employee);
        
        return i;
    }

    @Override
    public String selectIsAdmin(Employee employee) {
        // TODO Auto-generated method stub
        
        String r_name = signInMapper.selectIsAdmin(employee);
        
        return r_name;
    }

    @Override
    public Integer selectEidByloginName(Employee employee) {
        // TODO Auto-generated method stub
        
        Integer e_id = signInMapper.selectEidByloginName(employee);
        
        return e_id;
    }

}
