package com.his.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.his.entity.Charge;

public interface PrescriptionDao 
{
	/**
	 * 查找最大处方号
	 * @return
	 */
	String maxPrescriptID();
	
	/**
	 * 新建处方项目
	 * @param registerID
	 * @param currentTime
	 * @return
	 */
	void addPrescription(@Param("prescriptionID") String prescriptionID, @Param("registerID") String registerID,@Param("currentTime") Timestamp currentTime);
	
	/**
	 * 查找所有开立的收费项目
	 * @param caseID
	 * @return
	 */
	List<Charge> searchBycaseID(@Param("caseID") String caseID);
	
	/**
	 * 查找所有开立的收费项目
	 * @param caseID
	 * @return
	 */
	List<Charge> searchBycaseIDT(@Param("caseID") String caseID);
}
