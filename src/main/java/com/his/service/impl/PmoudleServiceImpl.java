package com.his.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.his.dao.PmoudleDao;
import com.his.entity.Drug;
import com.his.entity.Pmoudle;
import com.his.service.PmoudleService;

@Service
public class PmoudleServiceImpl implements PmoudleService
{
	@Autowired
	private PmoudleDao pmoudleDao;
	
	@Override
	public void displayAll(Model model)
	{
		List<Pmoudle> pmoudleList = pmoudleDao.selectAll();
		
		model.addAttribute("pmoudleList", pmoudleList);
	}
	
	@Override
	public List<Drug> getPmoudle(String pPrescriptID)
	{
		List<Drug> pmoudleList = pmoudleDao.getPmoudleList(pPrescriptID);
		
		return pmoudleList;
	}
}
