package com.his.service;

import com.his.entity.Caseresume;

public interface CaseresumeService
{
	/**
	 * 升级主诉
	 * @param registerID
	 * @param mainSuit
	 * @param HPI
	 * @param SHP
	 * @param PS
	 * @param allergies
	 * @param examination
	 */
	void saveMainSuit(String registerID, String mainSuit, String HPI, String SHP, String PS, String allergies, String examination);
	
	/**
	 * 以挂号号码查找病历
	 * @param registerID
	 * @return
	 */
	Caseresume searchByRegisterID(String registerID);
}
