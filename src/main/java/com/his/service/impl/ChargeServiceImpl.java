package com.his.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.his.dao.ChargeDao;
import com.his.dao.PrescriptionDao;
import com.his.entity.Charge;
import com.his.entity.Drug;
import com.his.entity.Receipt;
import com.his.service.ChargeService;

@Service
public class ChargeServiceImpl implements ChargeService
{
	
	@Autowired
	private ChargeDao chargeDao;
	
	@Autowired
	private PrescriptionDao prescriptionDao;
	
	@Override
	public boolean addRegisterCharge(String registerID,Integer receiptNumber, String price, Timestamp currentTime, String chargeID, String chargeType, String settlement)
	{
		System.out.println("registerID"+registerID);
		System.out.println("receiptNumber"+receiptNumber);
		System.out.println("price"+price);
		System.out.println("currentTime"+currentTime);
		System.out.println("chargeID"+chargeID);
		System.out.println("chargeType"+chargeType);
		System.out.println("settlement"+settlement);
		chargeDao.addRegisterCharge(registerID, receiptNumber, price, currentTime, chargeID, chargeType, settlement);
		System.out.println("addRegisterCharge执行完毕...");
		return true;
	}
	
	@Override
	public Receipt addRefundID(String registerID, String ItemType, String ItemID, String receiptNumber)
	{
		chargeDao.modifyRefund(registerID, ItemType, ItemID, receiptNumber);
		
		Receipt receipt = chargeDao.searchByRegisterID(registerID, ItemType, ItemID);
		
		return receipt;
	}
	
	@Override
	public void insertRefund(Receipt receiptItem, String receiptNumber)
	{
		Date date = new Date();   
		Timestamp currentTime = new Timestamp(date.getTime());
		Integer ItemType = receiptItem.getItemType();
		Double price = receiptItem.getPrice();
		if(ItemType == 3 && (price == 9.0 || price == 51.0))
		{
			price = price - 1.0;
		}
		chargeDao.updateRefundInfo(receiptNumber, receiptItem.getRegisterID(), receiptItem.getItemID(),
				-price, ItemType, currentTime, receiptItem.getChargeID(),
				receiptItem.getChargeType(), receiptItem.getSettlement());
	}
	
	@Override
	public Integer createEmptyItem()
	{
		System.out.println("开始生成发票项目...");
		Map<String, Integer> receiptList = chargeDao.createEmpty();
		Integer chaID = receiptList.get("max(chaID)") + 1;
		Integer receiptNumber = receiptList.get("max(receiptNumber)") + 1;
		
		
		System.out.println("生成项目序号" + chaID); 
		System.out.println("生成发票号" + receiptNumber);
		
		//测试无误 解注释即可对数据库进行更改
		chargeDao.insertEmpty(chaID, receiptNumber);
		 		
		return receiptNumber;

	}
	
	@Override
	public List<Charge> checkOutByCaseID(String caseID)
	{
		List<Charge> chargeList = prescriptionDao.searchBycaseID(caseID);
		
		return chargeList;
	}
	
	@Override
	public List<Charge> distributeByCaseID(String caseID)
	{
		List<Charge> chargeList = prescriptionDao.searchBycaseIDT(caseID);
		
		return chargeList;
	}
	
	@Override
	public void addDrugItems(String receiptNumber, List<Drug> prescriptionList, Timestamp currentTime, String chargeID, String chargeType, String caseID)
	{
		Drug drug = prescriptionList.get(0);
		chargeDao.updateDrugItem(receiptNumber, drug.getItemID(), drug.getPrice(), currentTime, chargeID, chargeType, caseID);
		
		
		for(int i = 1; i < prescriptionList.size(); i++)
		{
			System.out.println("d:"+ i);
			drug = prescriptionList.get(i);
			double price = Double.parseDouble(drug.getPrice()) * Double.parseDouble(drug.getNumber());
			chargeDao.addDrugItem(receiptNumber, drug.getItemID(), Double.toString(price), currentTime, chargeID, chargeType, caseID);
		}
	}
}
