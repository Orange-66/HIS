package com.his.dao;

import org.apache.ibatis.annotations.Param;


public interface RegtableDao 
{
	/**
	 * 按病历号查找病例
	 * @param date
	 * @param regType
	 * @param depID
	 * @param docID
	 */
	String searchRemain(@Param("date") String date, @Param("regType") String regType, @Param("docID") String docID);
	
	/**
	 * 修改usedTicket数值
	 * @param date
	 * @param docID
	 * @param regType
	 */
	String modifyUsedticket(@Param("date") String date, @Param("docID") String docID, @Param("regType") String regType);
	
	/**
	 * 修改usedTicket数值
	 * @param date
	 * @param docID
	 * @param regType
	 */
	String modifyCancelticket(@Param("date") String date, @Param("docID") String docID, @Param("regType") String regType);
	
}
