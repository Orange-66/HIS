package com.his.dao;

import java.sql.Timestamp;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.his.entity.Receipt;

public interface ChargeDao
{
	
	/**
	 * 添加挂号发票项目
	 * @param registerID
	 * @param price
	 * @param chargeID
	 * @param chargeType
	 * @return
	 */
	void addRegisterCharge(@Param("registerID")String registerID, @Param("receiptNumber") Integer receiptNumber, @Param("price") String price, @Param("currentTime") Timestamp currentTime, @Param("chargeID") String chargeID, @Param("chargeType") String chargeType, @Param("settlement") String settlement);

	/**
	 * 生成一发票号在发票表中
	 * @return
	 */
	Map<String, Integer> createEmpty();
	
	/**
	 * 插入一空项目发票项目
	 * @param chaID
	 * @param receiptNumber
	 */
	void insertEmpty(@Param("chaID")Integer chaID ,@Param("receiptNumber")Integer receiptNumber);
	
	/**
	 * 修改发票项目的冲红发票内容
	 * @param registerID
	 * @param ItemType
	 * @param ItemID
	 * @param receiptNumber
	 */
	void modifyRefund(@Param("registerID")String registerID,@Param("ItemType")String ItemType,@Param("ItemID")String ItemID,@Param("receiptNumber")String receiptNumber);
	
	/**
	 * 通过registerID查找
	 * @param registerID
	 * @return
	 */
	Receipt searchByRegisterID(@Param("registerID")String registerID,@Param("ItemType")String ItemType,@Param("ItemID")String ItemID);
	
	/**
	 * 更改冲红发票的内容
	 * @param receiptNumber
	 * @param registerID
	 * @param itemID
	 * @param d
	 * @param itemType
	 * @param currentTime
	 * @param chargeID
	 * @param chargeType
	 * @param settlement
	 */
	void updateRefundInfo(@Param("receiptNumber") String receiptNumber, @Param("registerID") Integer registerID, @Param("itemID") Integer itemID,
			@Param("price") double price, @Param("itemType") Integer itemType,
			@Param("currentTime") Timestamp currentTime, @Param("chargeID") Integer chargeID,@Param("chargeType") Integer chargeType,@Param("settlement") Integer settlement);
	
	
	/**
	 * 修改发票中drugItme项目
	 * @param receiptNumber
	 * @param itemID
	 * @param price
	 * @param currentTime
	 * @param chargeID
	 * @param chargeType
	 * @param caseID
	 */
	void updateDrugItem(@Param("receiptNumber") String receiptNumber,@Param("itemID") String  itemID,@Param("price") String  price,@Param("currentTime") Timestamp  currentTime,@Param("chargeID") String  chargeID,@Param("chargeType") String  chargeType,@Param("caseID") String  caseID);


	/**
	 * 添加发票中drugItme项目
	 * @param receiptNumber
	 * @param itemID
	 * @param price
	 * @param currentTime
	 * @param chargeID
	 * @param chargeType
	 * @param caseID
	 */
	void addDrugItem(@Param("receiptNumber") String receiptNumber,@Param("itemID") String  itemID,@Param("price") String  price,@Param("currentTime") Timestamp  currentTime,@Param("chargeID") String  chargeID,@Param("chargeType") String  chargeType,@Param("caseID") String  caseID);

}
