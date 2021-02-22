package com.his.dao;

import org.apache.ibatis.annotations.Param;

import com.his.entity.Case;

public interface CaseDao 
{
	/**
	 * 按病历号查找病例
	 * @param caseID
	 */
	Case searchByCaseID(@Param("caseID")String caseID);
	
	/**
	 * 最大病历号
	 * @return
	 */
	String maxCaseID();
	
	/**
	 * 生成新病例
	 * @param caseID
	 * @return
	 */
	Case newCase(@Param("caseID") String caseID);
	
	/**
	 * 删除病例
	 * @param caseID
	 * @return
	 */
	Case deleteCase(@Param("caseID") String caseID);

	/**
	 *修改病例
	 * @param caseID
	 * @return
	 */
	Case modifyCase(@Param("caseID") String caseID, @Param("name") String name, @Param("gender") String gender, @Param("patientID") String patientID, @Param("birthday") String birthday, @Param("age") String age, @Param("ageUnit") String ageUnit, @Param("address") String address);
}
