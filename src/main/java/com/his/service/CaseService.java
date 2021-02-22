package com.his.service;

import com.his.entity.Case;

public interface CaseService
{
	/**
	 * 判断用户账号密码是否输入正确
	 * @param caseID
	 * @return
	 */
	Case searchByCaseID(String caseID);
	
	/**
	 * 生成新病历号
	 * @return
	 */
	String newCaseID();
	
	/**
	 * 取消生成新病历号
	 * @param caseID
	 * @return
	 */
	String cancelNewCaseID(String caseID);
	
	/**
	 * 修改病例
	 * @param caseID
	 * @param name
	 * @param gender
	 * @param patientID
	 * @param birthday
	 * @param age
	 * @param ageUnit
	 * @param address
	 * @return
	 */
	void modifyCase(String caseID, String name, String gender, String patientID, String birthday, String age, String ageUnit, String address);

	

}
