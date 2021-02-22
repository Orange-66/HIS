package com.his.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes(value= {"user"})
public class IndexController
{
	/**
	 * 返回控制页面方法
	 * @return
	 */
	@RequestMapping("/index")
	public String index()
	{
        return "index";
	}
	
	
	/**
	 * 返回首页方法
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response, SessionStatus sessionStatus) throws Exception
	{
		System.out.println("login跳转");
		sessionStatus.setComplete();//销毁session
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
}
