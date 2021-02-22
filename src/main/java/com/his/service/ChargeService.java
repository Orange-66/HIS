package com.his.service;

import java.sql.Timestamp;
import java.util.List;

import com.his.entity.Charge;
import com.his.entity.Drug;
import com.his.entity.Receipt;

public interface ChargeService
{
	/**
	 * 添加发票项目-挂号
	 * @param registerID
	 * @param price
	 * @param chargeID
	 * @param chargeType
	 * @return
	 */
	boolean addRegisterCharge(String registerID, Integer receiptNumber, String price,Timestamp currentTime, String chargeID, String chargeType, String settlement);
	

	/**
	 * 在发票表中生成一发票号
	 * @return
	 */
	Integer createEmptyItem();
	
	/**
	 * 创建空冲红发票项目
	 * @param registerID
	 * @param ItemType
	 * @param ItemID
	 * @param receiptNumber
	 * @return
	 */
	Receipt addRefundID(String registerID, String ItemType, String ItemID, String receiptNumber);
	
	/**
	 * 向冲红发票中添加内容
	 * @param receiptItem
	 * @param receiptNumber
	 */
	void insertRefund(Receipt receiptItem, String receiptNumber);
	
	/**
	 * 查找所有当日开立项目
	 * @param caseID
	 * @return
	 */
	List<Charge> checkOutByCaseID(String caseID);
	
	/**
	 * 查找所有当日开立项目
	 * @param caseID
	 * @return
	 */
	List<Charge> distributeByCaseID(String caseID);
	
	void addDrugItems(String receiptNumber, List<Drug> prescriptionList, Timestamp currentTime, String chargeID, String settlement, String caseID);
}
