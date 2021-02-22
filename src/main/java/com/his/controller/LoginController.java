package com.his.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.his.entity.User;
import com.his.service.UserService;

@Controller
@SessionAttributes(value= {"user"})
public class LoginController {
	
	@Autowired
	private UserService userService;
		    
	/**
	 * 提交登陆信息
	 * @return
	 */
	@RequestMapping("/login/submit")
	@ResponseBody
	public int login(@RequestBody User user, Model model)
	{
		System.out.println("login登录信息提交...");
		
		String userName = user.getUserName();
		String password = user.getPassword();
		
		System.out.println("账号"+userName);
		System.out.println("密码"+password);
		
		Map<String, Object> map = userService.isLegal(userName, password, model);
		
        return (int)map.get("state");
	}

}
