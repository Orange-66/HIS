package com.his.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Drug implements Serializable
{
	private String drugID;
	private String drugCode;
	private String drugName;
	private String drugFormat;
	private String drugUnit;
	private String manufacturer;
	private String dosage;
	private String drugType;
	private String price;
	private String manemonicCode;
	private String createTime;
	private String constantID;
	private String typeID;
	private String conCode;
	private String conName;
	private String isDelete;
	private String number;
	private String itemID;
	
	
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDrugID() {
		return drugID;
	}
	public void setDrugID(String drugID) {
		this.drugID = drugID;
	}
	public String getDrugCode() {
		return drugCode;
	}
	public void setDrugCode(String drugCode) {
		this.drugCode = drugCode;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getDrugFormat() {
		return drugFormat;
	}
	public void setDrugFormat(String drugFormat) {
		this.drugFormat = drugFormat;
	}
	public String getDrugUnit() {
		return drugUnit;
	}
	public void setDrugUnit(String drugUnit) {
		this.drugUnit = drugUnit;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public String getDrugType() {
		return drugType;
	}
	public void setDrugType(String drugType) {
		this.drugType = drugType;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getManemonicCode() {
		return manemonicCode;
	}
	public void setManemonicCode(String manemonicCode) {
		this.manemonicCode = manemonicCode;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getConstantID() {
		return constantID;
	}
	public void setConstantID(String constantID) {
		this.constantID = constantID;
	}
	public String getTypeID() {
		return typeID;
	}
	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}
	public String getConCode() {
		return conCode;
	}
	public void setConCode(String conCode) {
		this.conCode = conCode;
	}
	public String getConName() {
		return conName;
	}
	public void setConName(String conName) {
		this.conName = conName;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	@Override
	public String toString() {
		return "Drug [drugID=" + drugID + ", drugCode=" + drugCode + ", drugName=" + drugName + ", drugFormat="
				+ drugFormat + ", drugUnit=" + drugUnit + ", manufacturer=" + manufacturer + ", dosage=" + dosage
				+ ", drugType=" + drugType + ", price=" + price + ", manemonicCode=" + manemonicCode + ", createTime="
				+ createTime + ", constantID=" + constantID + ", typeID=" + typeID + ", conCode=" + conCode
				+ ", conName=" + conName + ", isDelete=" + isDelete + ", number=" + number + ", itemID=" + itemID + "]";
	}


	
}
