package com.ysd.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.crm.controller.WebSocketServlet;
import com.ysd.crm.dao.EmployeeMapper;
import com.ysd.crm.entity.Asker;
import com.ysd.crm.entity.Employee;
import com.ysd.crm.entity.EmployeeRole;
import com.ysd.crm.entity.Message;
import com.ysd.crm.entity.Pagination;
import com.ysd.crm.entity.Role;
import com.ysd.crm.util.SpringContextUtil;
@Service
public class EmployeeServiceImp implements EmployeeService{

	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private Asker asker;
	@Override
	public Pagination<Employee> selectEmployeeAll(Pagination<Employee> pagination) {
		List<Employee> selectEmployeeAll = employeeMapper.selectEmployeeAll(pagination);
		Integer selectEmployeeCount = employeeMapper.selectEmployeeCount(pagination);
		pagination.setRows(selectEmployeeAll);
		pagination.setTotal(selectEmployeeCount);
		return pagination;
	}


	//根据员工id删除角色
	public Integer deleteEmployee(Integer e_id) {
		// TODO Auto-generated method stub
		Integer selectGenJinStudentCountById = employeeMapper.selectGenJinStudentCountById(e_id);
		if(selectGenJinStudentCountById>0) {
			return 0;
		}else {
			return employeeMapper.deleteEmployee(e_id);
		}
		
	}

	@Override
	public Integer updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeMapper.updateEmployee(employee);
	}


    //查询所有角色
    public List<Role> selectAllRole() {
        // TODO Auto-generated method stub
        
        List<Role> list = employeeMapper.selectAllRole();
        
        return list;
    }


    //查询用户已拥有的角色
    public List<Role> selectEmployeeRoleByName(Employee employee) {
        // TODO Auto-generated method stub
        
        List<Role> list = employeeMapper.selectEmployeeRoleByName(employee);
        
        return list;
    }


   //根据用户id添加角色
    public Integer insertRoleForEmployee(String arr,EmployeeRole employeeRole,String e_name,String r_name) {
        // TODO Auto-generated method stub
        
    	String[] ridArr = arr.split(",");
    	String[] rname=r_name.split(",");
	    Integer code = 0;
	    for (int i = 0;i < ridArr.length;i++) {
	    	if(rname[i].equals("咨询师") || rname[i].equals("网络咨询师")) {
	    		employeeRole.setR_id(Integer.parseInt(ridArr[i]));
	    		asker.setA_name(e_name);
	    		asker.setA_roleName(rname[i]);
	    		employeeMapper.addAsker(asker);
		        code=employeeMapper.insertRoleForEmployee(employeeRole);
	    	}else {
	    		employeeRole.setR_id(Integer.parseInt(ridArr[i]));
	    		code=employeeMapper.insertRoleForEmployee(employeeRole);
	    	}
	    }

        return code;
    }


   //根据用户id删除角色
    public Integer deleteRoleForEmployee(String arr,EmployeeRole employeeRole,String r_name,String name) {
         String[] rname=r_name.split(",");
    	 String[] ridArr = arr.split(",");
		 Integer coun=0; 
    	 Integer sizes=0;
    	 for (int i = 0;i < ridArr.length;i++) {
    		 if(rname[i].equals("咨询师")) {
    			 sizes=sizes;
    		 }else {
    			 sizes+=1;
    		 }
    	 }
    	 if(sizes==ridArr.length) {
    		 for(int i = 0;i < ridArr.length;i++) {
    			 if(rname[i].equals("网络咨询师")) {
    				 employeeMapper.deleteAskerByName(name, rname[i]);
    				 employeeRole.setR_id(Integer.parseInt(ridArr[i])); 
        			 coun=employeeMapper.deleteRoleForEmployee(employeeRole);
    			 }else {
    				 employeeRole.setR_id(Integer.parseInt(ridArr[i])); 
        			 coun=employeeMapper.deleteRoleForEmployee(employeeRole);
    			 }
    		 }
    	 }else {
    		 for(int i = 0;i < rname.length;i++) {
    			 if(rname[i].equals("咨询师")) { 
   				  Integer selectGenJinStudentCountById =employeeMapper.selectGenJinStudentCountById(employeeRole.getE_id());
   				  	if(selectGenJinStudentCountById>0){ 
   					  coun= 0; 
   				  	}else{
   				  	employeeMapper.deleteAskerByName(name, rname[i]);
   				  	employeeRole.setR_id(Integer.parseInt(ridArr[i])); 
   				  	coun= employeeMapper.deleteRoleForEmployee(employeeRole);
   				  	}
    			 }else {
    				 if(rname[i].equals("网络咨询师")) {
    					 employeeMapper.deleteAskerByName(name, rname[i]);
    					 employeeRole.setR_id(Integer.parseInt(ridArr[i])); 
    	       	    	 employeeMapper.deleteRoleForEmployee(employeeRole);
    				 }else {
    					 employeeRole.setR_id(Integer.parseInt(ridArr[i])); 
    	       	    	 employeeMapper.deleteRoleForEmployee(employeeRole);
    				 }
    			 }
    	 }
    	}
			return coun;
         
    }


    @Override
    public Integer updateEmployeePassword(Employee employee) {
        // TODO Auto-generated method stub
        
        Integer i = employeeMapper.updateEmployeePassword(employee);
        
        return i;
    }


    @Override
    public String selectFingerprintNumByLoginName(Employee employee) {
        // TODO Auto-generated method stub
        
        String fingerprintNum = employeeMapper.selectFingerprintNumByLoginName(employee);
        
        return fingerprintNum;
    }


    @Override
    public Integer updateEmployeeLock(Employee employee) {
        // TODO Auto-generated method stub
        
        Integer i = employeeMapper.updateEmployeeLock(employee);
        
        return i;
    }


    @Override
    public Integer updateEmployeeUnLock(Employee employee) {
        // TODO Auto-generated method stub
        
        Integer i = employeeMapper.updateEmployeeUnLock(employee);
        
        return i;
    }


	//根据登录员工的角色显示不同的统计图
	public List selectTongJiTu(String e_loginName) {
		//根据登录名查询拥有的角色
		String selectRoleByEmpName = employeeMapper.selectRoleByEmpName(e_loginName);
		List list=new ArrayList();
		if(selectRoleByEmpName!=null) {
			if(selectRoleByEmpName.equals("管理员")) {
				Integer selectSuoDingCount = employeeMapper.selectSuoDingCount();
				Integer selectWeiSuoDingCount = employeeMapper.selectWeiSuoDingCount();
				list.add(selectSuoDingCount);
				list.add(selectWeiSuoDingCount);
				list.add(selectRoleByEmpName);
			}else if(selectRoleByEmpName.equals("咨询经理")){
				Integer selectWeiQianDaoRenShu = employeeMapper.selectWeiQianDaoRenShu();
				Integer selectQianDaoRenShu = employeeMapper.selectQianDaoRenShu();
				list.add(selectQianDaoRenShu);
				list.add(selectWeiQianDaoRenShu);
				list.add(selectRoleByEmpName);
			}else if(selectRoleByEmpName.equals("咨询师")) {
				Integer selectStudentByEmpName = employeeMapper.selectStudentByEmpName(e_loginName);
				Integer selectStudentLuiShiByEmpName = employeeMapper.selectStudentLuiShiByEmpName(e_loginName);
				Integer selectStudentLuRuByEmpName = employeeMapper.selectStudentLuRuByEmpName(e_loginName);
				Integer genjin=selectStudentByEmpName-selectStudentLuiShiByEmpName-selectStudentLuRuByEmpName;
				list.add(selectStudentLuiShiByEmpName);
				list.add(selectStudentLuRuByEmpName);
				list.add(selectRoleByEmpName);
				list.add(genjin);
			}else if(selectRoleByEmpName.equals("网络咨询师")) {
				Integer selectStudentAddByEmpName = employeeMapper.selectStudentAddByEmpName(e_loginName);
				Integer selectStudentAddLiuShuByEmpName = employeeMapper.selectStudentAddLiuShuByEmpName(e_loginName);
				Integer selectStudentAddLuRuByEmpName = employeeMapper.selectStudentAddLuRuByEmpName(e_loginName);
				Integer genjin=selectStudentAddByEmpName-selectStudentAddLiuShuByEmpName-selectStudentAddLuRuByEmpName;
				list.add(selectStudentAddLiuShuByEmpName);
				list.add(selectStudentAddLuRuByEmpName);
				list.add(selectRoleByEmpName);
				list.add(genjin);
			}
		}else {
			
				list.add("未定义角色");
			
		}
		
		return list;
			
		
		
	}


	//查询角色模块中间表数量
	public Integer selectEmployeeroleCount() {
		EmployeeMapper employee= SpringContextUtil.getBean("employeeMapper");
		Integer selectemployeeroleCount = employee.selectemployeeroleCount();
		return selectemployeeroleCount;
	}


	//根据学生id查询所属咨询师
	public String selectStudentByIdEmpName(Integer tidsss,String name,String mess) {
		String names=employeeMapper.selectStudentByIdEmpName(tidsss);
		String p=name+","+names+","+mess;
		WebSocketServlet websocket=new WebSocketServlet();
		websocket.onMessage(p);
		return names;
	}


	//添加消息
	public Integer insertMessage(String messaged) {
		Message messagesss=new Message();
		String[] split = messaged.split(",");
		String name=split[0];
		messagesss.setE_sendName(name);
		messagesss.setE_acceptName(split[1]);
		messagesss.setM_content(split[2]);
		System.out.println(messagesss.toString());
		System.out.println(employeeMapper);
		EmployeeMapper employee= SpringContextUtil.getBean("employeeMapper");
		Integer i = employee.insertMessage(messagesss);
		return i;
	}


	//根据员工登录名查询未读信息
	public List<Message> selectEmpByname(String name) {
		List<Message> selectEmpByName = employeeMapper.selectEmpByName(name);
		return selectEmpByName;
	}


	//根据编号修改消息状态
	public Integer updateMessById(Integer id) {
		
		return employeeMapper.updataMessageById(id);
	}

}
