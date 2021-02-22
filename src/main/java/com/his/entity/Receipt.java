package com.his.entity;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class Receipt implements Serializable
{
	private Integer chaID;
	private Integer registerID;
	private Integer receiptNumber;
	private Integer itemID;
	private Double price;
	private Integer itemType;
	private Date chargeTime;
	private Integer chargeID;
	private Integer chargeType;
	private Integer refundID;
	private Integer settlement;
	
	public Integer getChaID() {
		return chaID;
	}
	public void setChaID(Integer chaID) {
		this.chaID = chaID;
	}
	public Integer getRegisterID() {
		return registerID;
	}
	public void setRegisterID(Integer registerID) {
		this.registerID = registerID;
	}
	public Integer getReceiptNumber() {
		return receiptNumber;
	}
	public void setReceiptNumber(Integer receiptNumber) {
		this.receiptNumber = receiptNumber;
	}
	public Integer getItemID() {
		return itemID;
	}
	public void setItemID(Integer itemID) {
		this.itemID = itemID;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getItemType() {
		return itemType;
	}
	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}
	public Date getChargeTime() {
		return chargeTime;
	}
	public void setChargeTime(Date chargeTime) {
		this.chargeTime = chargeTime;
	}
	public Integer getChargeID() {
		return chargeID;
	}
	public void setChargeID(Integer chargeID) {
		this.chargeID = chargeID;
	}
	public Integer getChargeType() {
		return chargeType;
	}
	public void setChargeType(Integer chargeType) {
		this.chargeType = chargeType;
	}
	public Integer getRefundID() {
		return refundID;
	}
	public void setRefundID(Integer refundID) {
		this.refundID = refundID;
	}
	public Integer getSettlement() {
		return settlement;
	}
	public void setSettlement(Integer settlement) {
		this.settlement = settlement;
	}
	@Override
	public String toString() {
		return "Receipt [chaID=" + chaID + ", registerID=" + registerID + ", receiptNumber=" + receiptNumber
				+ ", itemID=" + itemID + ", price=" + price + ", itemType=" + itemType + ", chargeTime=" + chargeTime
				+ ", chargeID=" + chargeID + ", chargeType=" + chargeType + ", refundID=" + refundID + ", settlement="
				+ settlement + "]";
	}
	
	
}
