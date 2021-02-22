package com.his.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.his.entity.User;

public interface UserDao 
{
	/**
	 * 查找所有用户
	 * @return
	 */
	List<User> findAll();
	
	/**
	 * 判断是否存在某用户
	 * @param userName
	 * @return
	 */
	User queryByName(@Param("userName") String userName);
	
	/**
	 * 查找符合相应科室和级别的医生
	 * @param depID
	 * @param titleID
	 * @return
	 */
	List<Map<String, Object>> searchDoctorByDT(@Param("depID") String depID, @Param("titleID") String titleID);
		
}
