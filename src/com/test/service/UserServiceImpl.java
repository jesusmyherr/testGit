package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.UserDao;
import com.test.domain.Student;
import com.test.domain.User;
import com.test.utils.PageBean;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	

	@Override
	public User loginUser(User user) {
		//System.out.println("Service");

		// TODO Auto-generated method stub
		return userDao.loginUser(user);
		
	
  	}



	@Override
	public PageBean<Student> findPage(PageBean<Student> pageBean) {
		// TODO Auto-generated method stub
				if(pageBean.getCurrentPage()==null) {
					pageBean.setCurrentPage(1);
				}
			
				int totalCount = userDao.findCount();
				pageBean.setTotalCount(totalCount);
				
				int pageSize = 3;
				pageBean.setPageSize(pageSize);
				
		
				int totalPage = 0;
				if(totalCount%pageSize==0) {//整除
					totalPage = totalCount/pageSize;
				} else {//不能整除
					totalPage = totalCount/pageSize+1;
				}
				pageBean.setTotalPage(totalPage);
				

				int begin = (pageBean.getCurrentPage()-1)*pageSize;
				List<Student> list = userDao.findPage(begin,pageSize);
				pageBean.setList(list);
				
				return pageBean;
	}



	@Override
	public void delete(int student_id) {
		// TODO Auto-generated method stub
		userDao.delete(student_id);
		
	}



	@Override
	public void delMore(int[] student_idS) {
		// TODO Auto-generated method stub
	  if(student_idS != null) {
		for(int student_id:student_idS) {
			userDao.delete(student_id);
		}
	  }
			
		
	}
	
	
	
	
}
