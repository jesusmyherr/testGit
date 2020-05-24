package com.test.dao;

import java.util.List;

import com.test.domain.Student;
import com.test.domain.User;

public interface UserDao {

	User loginUser(User user);
	int findCount();
	 List<Student> findPage(int begin, int pageSize);
	 void delete(int student_id);
}
