package com.his.dao;

import java.sql.Timestamp;

import org.apache.ibatis.annotations.Param;

public interface DrugItemDao
{
	/**
	 * 添加药物项目
	 * @param prescriptionID
	 * @param drugID
	 * @param number
	 * @param currentTime
	 * @param docID
	 */
	void addDrugItem(@Param("prescriptionID") String prescriptionID, @Param("drugID") String drugID, @Param("number") String number, @Param("currentTime") Timestamp currentTime, @Param("docID") String docID);


	/**
	 * 改变项目状态
	 * @param itemID
	 * @param state
	 */
	void changeState(@Param("itemID") String itemID, @Param("state") String state);
}
