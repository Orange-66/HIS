package com.his.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.his.dao.PrescriptionDao;
import com.his.service.PrescriptionService;

@Service
public class PrescriptionServieImpl implements PrescriptionService
{
	@Autowired
	private PrescriptionDao prescriptionDao;
	
	@Override
	public String maxPrescripID()
	{
		String prescriptionID = prescriptionDao.maxPrescriptID();
		
		return prescriptionID;
	}
	
	@Override
	public void addPrescription(String prescriptionID, String registerID, Timestamp currentTime)
	{
		prescriptionDao.addPrescription(prescriptionID, registerID, currentTime);
	}
}
