package com.his.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Charge  implements Serializable
{
	private String caseID;
	private String name;
	private String drugID;
	private String itemID;
	private String drugName;
	private String price;
	private String number;
	private String createTime;
	private String itemState;
	private String realName;
	
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	public String getDrugID() {
		return drugID;
	}
	public void setDrugID(String drugID) {
		this.drugID = drugID;
	}
	public String getCaseID() {
		return caseID;
	}
	public void setCaseID(String caseID) {
		this.caseID = caseID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getItemState() {
		return itemState;
	}
	public void setItemState(String itemState) {
		this.itemState = itemState;
	}
	@Override
	public String toString() {
		return "Charge [caseID=" + caseID + ", name=" + name + ", drugID=" + drugID + ", itemID=" + itemID
				+ ", drugName=" + drugName + ", price=" + price + ", number=" + number + ", createTime=" + createTime
				+ ", itemState=" + itemState + ", realName=" + realName + "]";
	}



	
	
}
