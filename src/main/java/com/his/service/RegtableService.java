package com.his.service;

public interface RegtableService
{
	/**
	 * 查询剩余挂号单
	 * @param caseID
	 * @return
	 */
	String searchRemain(String date, String regType, String docID);
	
	/**
	 * 减少剩余票额
	 * @param date
	 * @param docID
	 * @param regType
	 * @param remain
	 * @return 
	 */
	boolean useATicket(String date, String docID, String regType);
	
	/**
	 * 增加剩余票数
	 * @param date
	 * @param docID
	 * @param regType
	 * @return
	 */
	boolean cancelATicket(String date, String docID, String regType);
}
