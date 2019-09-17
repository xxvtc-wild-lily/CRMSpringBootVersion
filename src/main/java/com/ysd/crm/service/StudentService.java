package com.ysd.crm.service;

import com.ysd.crm.entity.NetFollow;
import com.ysd.crm.entity.Pagination;
import com.ysd.crm.entity.Student;

public interface StudentService {
	Pagination<Student> selectStudentAll(Pagination<Student> pagination);
	
	Integer insertStudent(Student student);
	
	Integer deleteStudent(Integer s_id);
	
	Integer updateStudent(Student student);
	
	
	Integer insertNetFoll(NetFollow netfollow);
}
