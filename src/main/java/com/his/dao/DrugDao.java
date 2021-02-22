package com.his.dao;

import java.util.List;

import com.his.entity.Drug;

public interface DrugDao
{
	/**
	 * 返回所有项目
	 * @return
	 */
	List<Drug> selectAll();
}
