package com.his.service;

import java.sql.Timestamp;

import org.springframework.stereotype.Service;

@Service
public interface PrescriptionService
{
	/**
	 * 选出最大ID
	 * @return
	 */
	String maxPrescripID();
	
	/**
	 * 新建发票项目
	 * @param prescriptionID
	 * @param registerID
	 * @param currentTime
	 */
	void addPrescription(String prescriptionID, String registerID, Timestamp currentTime);
}
