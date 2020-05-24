package com.test.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.test.domain.Student;
import com.test.domain.User;

@Repository
public class UserDaoImpl implements UserDao {
	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
	 @Autowired
     private SessionFactory sessionFactory;

	

	@Override
	public User loginUser(User user) {

	    Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Customer  where c.username=? and c.password=?");
		
		query.setParameter(0, user.getUsername());
		query.setParameter(1,user.getPassword());
		List<User> list = query.list();
		
		tx.commit();

//		第七步 关闭资源
		session.close();
		sessionFactory.close();
		
	    User[] u=new User[list.size()];
	    list.toArray(u);
	    
	  	return u[0];
//		try {
//			String sql="select * from t_user where username=? and password=?";
//		    return jdbcTemplate.queryForObject(sql, new MyRowMapper_user(), user.getUsername(), user.getPassword());		
//		} catch (Exception e) {
//			// TODO: handle exception
//			return null;
//		}
			
	}
	
	public int findCount() {
	    //得到Session
	    Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		//1 创建query对象
		Query query = session.createQuery("select count(*) from t_student");
		
		//2 调用方法得到结果
		//query对象里面有方法，直接返回对象形式
		Object obj = query.uniqueResult();
		
		//首先把object变成long类型，再变成int类型
		Long lobj = (Long) obj;
		int count = lobj.intValue();
		
		tx.commit();

//		第七步 关闭资源
		session.close();
		sessionFactory.close();
		
	  	return count;
//		try {
//			String sql = "select count(*) from t_student ";
//		   return jdbcTemplate.queryForObject(sql, Integer.class);
//		} catch (Exception e) {
//			// TODO: handle exception
//			return 0;
//		}
	}

	@Override
	public List<Student> findPage(int begin, int pageSize) {
		    //得到Session
		    Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("from t_student");
			
			//2 设置分页数据
			//2.1 设置开始位置
			query.setFirstResult(begin);
			//2.2 设置每页记录数
			query.setMaxResults(pageSize);
			
			//3 调用方法得到结果
			List<Student> list = query.list();
			
			tx.commit();

//			第七步 关闭资源
			session.close();
			sessionFactory.close();
			
		  	return list;
//		
//		try {
//			String sql = "select * from t_student limit ?,?";
//			return jdbcTemplate.query(sql, new MyRowMapper_stu(), begin,pageSize);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			return null;
//		}
		
	}

	@Override
	public void delete(int student_id) {
		    //得到Session
		    Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
		
			User u = session.get(User.class, student_id);
			session.delete(u);
			
			tx.commit();

//			第七步 关闭资源
			session.close();
			sessionFactory.close();
			
//		// TODO Auto-generated method stub
//		String sql = "delete from t_student where student_id = ?";
//		jdbcTemplate.update(sql, student_id);
		
	}
}


	



