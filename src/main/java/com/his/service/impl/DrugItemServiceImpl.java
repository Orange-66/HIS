package com.his.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.his.dao.DrugItemDao;
import com.his.entity.Drug;
import com.his.service.DrugItemService;

@Service
public class DrugItemServiceImpl implements DrugItemService
{
	@Autowired
	private DrugItemDao drugItemDao;
	
	@Override
	public void addPrescription(String prescriptionID, List<Drug> prescriptionList, Timestamp currentTime, String docID)
	{
		for(Drug d :prescriptionList)
		{
			drugItemDao.addDrugItem(prescriptionID, d.getDrugID(), d.getNumber(), currentTime, docID);
		}
	}
	
	@Override
	public void changeState(List<Drug> prescriptionList, String state)
	{
		for(Drug d : prescriptionList)
		{
			drugItemDao.changeState(d.getItemID(), state);
		}
	}
}
