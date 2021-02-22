package com.his.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.his.entity.Register;

public interface RegisterDao 
{
	/**
	 * 查找新挂号ID
	 * @return
	 */
	String newRegisterID();
	
	/**
	 * 插入新挂号项目
	 * @param registerID
	 * @param caseID
	 * @param currentTime
	 * @param newNote
	 * @param docID
	 * @param levID
	 * @param chargeID
	 * @param chargeType
	 */
	void insertRegister(@Param("registerID") String registerID, @Param("caseID") String caseID, @Param("currentTime") Timestamp currentTime, @Param("newNote") String newNote, @Param("docID") String docID, @Param("levID") String levID, @Param("chargeID") String chargeID, @Param("chargeType") String chargeType, @Param("regType") String regType, @Param("depID") String depID, @Param("appointDate") String appointDate);

	
	/**
	 * 查找当天与该caseID相同的项目
	 * @param caseID
	 * @return
	 */
	List<Register> searchByCaseID(@Param("caseID") String caseID);
	
	/**
	 * 改变项目state为4
	 * @param registerID
	 */
	void changeStateByRegisterID(@Param("registerID") String registerID, @Param("registState") String registState);
	
	/**
	 * 找出当前医生负责的所有患者
	 * @param docID
	 * @param currentTime
	 * @return
	 */
	List<Register> searchByDocID(@Param("docID") Integer docID, @Param("currentTime") Timestamp currentTime);
	
	Register isRepeatNow(@Param("caseID") String caseID,@Param("depID") String  depID,@Param("docID") String  docID);
}
