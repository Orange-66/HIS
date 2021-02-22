package com.his.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.his.dao.CaseresumeDao;
import com.his.entity.Caseresume;
import com.his.service.CaseresumeService;

@Service
public class CaseresumeServiceImpl implements CaseresumeService
{
	@Autowired
	private CaseresumeDao caseresumeDao;
	
	@Override
	public void saveMainSuit(String registerID, String mainSuit, String HPI, String SHP, String PS, String allergies, String examination)
	{
		caseresumeDao.updateByRegister(registerID, mainSuit, HPI, SHP, PS, allergies, examination);
	}
	
	@Override
	public Caseresume searchByRegisterID(String registerID)
	{
		return caseresumeDao.searchByRegisterID(registerID);	
	}
}
