package com.his.service;

import java.util.List;

import org.springframework.ui.Model;

import com.his.entity.Drug;

public interface PmoudleService
{
	void displayAll(Model model);
	
	List<Drug> getPmoudle(String pPrescriptID);
}
