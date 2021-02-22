package com.his.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.his.entity.Drug;

@Service
public interface DrugItemService
{
	void addPrescription(String prescriptionID, List<Drug> prescriptionList, Timestamp currentTime, String docID);
	
	void changeState(List<Drug> prescriptionList, String state);
}
