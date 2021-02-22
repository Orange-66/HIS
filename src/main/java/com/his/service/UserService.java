package com.his.service;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.his.entity.User;

public interface UserService 
{
	/**
	 * 判断用户账号密码是否输入正确
	 * @param UserName
	 * @param password
	 * @return
	 */
	Map<String, Object> isLegal(String UserName, String password, Model model);
	
	/**
	 * 查找所有
	 * @return
	 */
	List<User> findAll();
	
	/**
	 * 查找和条件的医生
	 * @param depID
	 * @param titleType
	 * @return
	 */
	List<Map<String, Object>> searchDoctor(String depID,String titleType);
}
