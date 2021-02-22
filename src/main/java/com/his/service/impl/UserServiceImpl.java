package com.his.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.his.dao.UserDao;
import com.his.entity.User;
import com.his.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> findAll()
	{
		List<User> userList = userDao.findAll();
		return userList;
	}
	
	@Override
	public Map<String, Object> isLegal(String userName, String password, Model model)
	{
		//
		User user = userDao.queryByName(userName);

		Map<String, Object> map = new HashMap<>();
		
		if(user == null)//无输入账户
		{
			map.put("state", -1);//输入账户错误状态
		}
		else
		{
			if(user.getPassword().equals(password))//输入账户密码均正确
			{
				map.put("state", 0);//输入账户密码均正确状态
				map.put("user", user);
				model.addAttribute("user", user);
			}
			else
			{
				map.put("state", -2);//输入密码错误状态
			}
		}
		
		return map;

	}
	
	@Override
	public List<Map<String, Object>> searchDoctor(String depID,String titleID)
	{

		List<Map<String, Object>> doctorList = userDao.searchDoctorByDT(depID, titleID);
		
		return doctorList;
	}
}
