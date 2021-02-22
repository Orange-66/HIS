package com.his.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.his.dao.DrugDao;
import com.his.entity.Drug;
import com.his.service.DrugService;

@Service
public class DrugServiceImpl implements DrugService
{
	@Autowired
	private DrugDao drugDao;
	
	@Override
	public void displayAll(Model model)
	{
		List<Drug> drugList = drugDao.selectAll();
		
		model.addAttribute("drugList", drugList);
	}
}
