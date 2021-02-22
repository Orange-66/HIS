package com.his.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.his.dao.RegisterDao;
import com.his.entity.Register;
import com.his.service.ChargeService;
import com.his.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService
{
	@Autowired
	private RegisterDao registerDao;
	
	@Autowired
	private ChargeService chargeService;
	
	@Override
	public boolean addRegister(String caseID, String newNote, String docID, String depID, String levID, String chargeID, String chargeType, String price, String settlement, Integer receiptNumber, String regType, String appointDate)
	{
		String registerID = registerDao.newRegisterID();
		
		//date--> timestamp
		Date date = new Date();   
		Timestamp currentTime = new Timestamp(date.getTime());
		
		//levID与titleID转换
		levID = levID.equals("81") ? "1" : "2";
		System.out.println("registerDao.insertRegister方法执行...");
		registerDao.insertRegister(registerID, caseID, currentTime, newNote, docID, levID, chargeID, chargeType, regType, depID, appointDate);
		
		System.out.println("chargeService.addRegisterCharge方法执行...");
		chargeService.addRegisterCharge(registerID, receiptNumber, price, currentTime, chargeID, chargeType, settlement);
		
		return true;
	}
	
	@Override
	public List<Register> searchToday(String caseID)
	{
		List<Register> registerList = registerDao.searchByCaseID(caseID);
		
		return registerList;
	}
	
	@Override
	public void cancelRegister(String registerID)
	{
		registerDao.changeStateByRegisterID(registerID, "4");
	}
	
	@Override
	public List<Register> ownPatientToday(Integer docID)
	{	
		Date date = new Date();   
		Timestamp currentTime = new Timestamp(date.getTime());
		
		List<Register> patientList = registerDao.searchByDocID(docID, currentTime);
		
		return patientList;
	}
	
	@Override
	public void distinguishPatient(List<Register> patientQueue, Model model)
	{
		List<Register> waitingQueue = new ArrayList<Register>();
		List<Register> completionQueue = new ArrayList<Register>();
		
		for(Register r : patientQueue)
		{
			if(r.getRegistState() == 1)
			{
				waitingQueue.add(r);
			}
			if(r.getRegistState() == 2)
			{
				completionQueue.add(r);
			}
		}
		
		model.addAttribute("waitingQueue", waitingQueue);
		model.addAttribute("completionQueue", completionQueue);
		
		System.out.println("waitingQueue"+waitingQueue.size()+"completionQueue"+completionQueue.size());
	}
	
	@Override
	public void inTreatment(String registerID)
	{
		registerDao.changeStateByRegisterID(registerID, "2");
	}
	
	@Override
	public Register isRepeat(String caseID, String depID, String docID)
	{
		return registerDao.isRepeatNow(caseID, depID, docID);
	}
}
