package com.his.dao;

import org.apache.ibatis.annotations.Param;

import com.his.entity.Caseresume;

public interface CaseresumeDao
{
	/**
	 * 修改病例主诉
	 * @param registerID
	 * @param mainSuit
	 * @param HPI
	 * @param SHP
	 * @param PS
	 * @param allergies
	 * @param examination
	 */
	void updateByRegister(@Param("registerID") String registerID,@Param("mainSuit") String mainSuit,@Param("HPI") String HPI,@Param("SHP") String SHP,@Param("PS") String PS,@Param("allergies") String allergies,@Param("examination") String examination);
	
	/**
	 * 以挂号号码查找病历首页信息
	 * @param registerID
	 * @return
	 */
	Caseresume searchByRegisterID(@Param("registerID") String registerID);
}
