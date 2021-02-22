package com.his.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.his.dao.RegtableDao;
import com.his.service.RegtableService;

@Service
public class RegtableServiceImpl implements RegtableService
{
	@Autowired
	private RegtableDao regtableDao;
	
	@Override
	public String searchRemain(String date, String regType, String docID)
	{
		String number = regtableDao.searchRemain(date, regType, docID);
		
		return number;
	}
	
	@Override
	public boolean useATicket(String date, String docID, String regType)
	{
		regtableDao.modifyUsedticket(date, docID, regType);
		
		return true;
	}
	
	@Override
	public boolean cancelATicket(String date, String docID, String regType)
	{
		regtableDao.modifyCancelticket(date, docID, regType);
		
		return true;
	}
}
