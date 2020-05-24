package com.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.domain.Student;
import com.test.domain.User;
import com.test.service.UserService;
import com.test.utils.PageBean;

@Controller
public class LoginAction {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/delMoreStu")
	public String delMoreStu(int[] student_ids) {
		userService.delMore(student_ids);
		return "redirect:/findAllPage";
	}
	
	//删除的方法
	@RequestMapping("/deleteStu")
	public String deleteStu(HttpServletRequest request) {
		String stu_id = request.getParameter("student_id");
		userService.delete(Integer.parseInt(stu_id));
	
		return "redirect:/findAllPage";
	}
	
	
	@RequestMapping("/findAllPage")
	public String list(HttpSession session, PageBean<Student> pageBean, Model model)  {
		
		PageBean<Student> page = userService.findPage(pageBean);
		
		Object obj = session.getAttribute("user");
        if (obj != null) {
        	model.addAttribute("page",page);
        	return "list_stu"; 
      	
        }else {
        	return "redirect:login.jsp";
        }
 
	}
	
	
	@RequestMapping("/login")
	public String login(User user, HttpSession session) {
		
	//	System.out.println("Controller");
		 
		User u = userService.loginUser(user);
		
		if(u != null) {
			session.setAttribute("user", u);
			
			return "main";
		}else {
        	return "redirect:login.jsp";
		}
		
	}

}
