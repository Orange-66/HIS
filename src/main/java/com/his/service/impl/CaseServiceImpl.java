package com.his.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.his.dao.CaseDao;
import com.his.entity.Case;
import com.his.service.CaseService;

@Service
public class CaseServiceImpl implements CaseService
{
	@Autowired
	private CaseDao caseDao;
	
	@Override
	public Case searchByCaseID(String caseID)
	{
		Case caseItem  = caseDao.searchByCaseID(caseID);
		
		if(caseItem == null)
		{
			System.out.println("未找到患者信息...");
		}
		else
		{
			System.out.println("找到患者信息:" + caseItem.getName());
		}
		
		return caseItem;
	}
	
	@Override
	public String newCaseID()
	{
		String caseID = caseDao.maxCaseID();
		
		System.out.println("生成病历号:" + caseID);
		caseDao.newCase(caseID);
		
		return caseID;
	}
	
	@Override
	public String cancelNewCaseID(String caseID)
	{

		System.out.println("删除生成病历号:" + caseID);
		caseDao.deleteCase(caseID);
		
		return caseID;
	}
	
	@Override
	public void modifyCase(String caseID, String name, String gender, String patientID, String birthday, String age, String ageUnit, String address)
	{
		caseDao.modifyCase(caseID, name, gender, patientID, birthday, age, ageUnit, address);
	}


}
