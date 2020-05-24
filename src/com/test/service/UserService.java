package com.test.service;

import com.test.domain.Student;
import com.test.domain.User;
import com.test.utils.PageBean;

public interface UserService {

	User loginUser(User user);
	
	PageBean<Student> findPage(PageBean<Student> pageBean);

	void delete(int student_id);

	void delMore(int[] student_ids);



}
