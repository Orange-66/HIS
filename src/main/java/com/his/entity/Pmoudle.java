package com.his.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Pmoudle implements Serializable
{
	private String diseID;
	private String pPrescriptID;
	private String docID;
	private String crateTime;
	private String pMoudleType;
	private String pRange;
	private String moudleName;
	private String itemID;
	private String prescriptID;
	private String drugID;
	private String number;
	private String itemState;
	private String createTime;
	private String itemType;
	private Drug drug;
	public String getDiseID() {
		return diseID;
	}
	public void setDiseID(String diseID) {
		this.diseID = diseID;
	}
	public String getPPrescriptID() {
		return pPrescriptID;
	}
	public void setPPrescriptID(String pPrescriptID) {
		this.pPrescriptID = pPrescriptID;
	}
	public String getDocID() {
		return docID;
	}
	public void setDocID(String docID) {
		this.docID = docID;
	}
	public String getCrateTime() {
		return crateTime;
	}
	public void setCrateTime(String crateTime) {
		this.crateTime = crateTime;
	}
	public String getpMoudleType() {
		return pMoudleType;
	}
	public void setpMoudleType(String pMoudleType) {
		this.pMoudleType = pMoudleType;
	}
	public String getpRange() {
		return pRange;
	}
	public void setpRange(String pRange) {
		this.pRange = pRange;
	}
	public String getMoudleName() {
		return moudleName;
	}
	public void setMoudleName(String moudleName) {
		this.moudleName = moudleName;
	}
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	public String getPrescriptID() {
		return prescriptID;
	}
	public void setPrescriptID(String prescriptID) {
		this.prescriptID = prescriptID;
	}
	public String getDrugID() {
		return drugID;
	}
	public void setDrugID(String drugID) {
		this.drugID = drugID;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getItemState() {
		return itemState;
	}
	public void setItemState(String itemState) {
		this.itemState = itemState;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public Drug getDrug() {
		return drug;
	}
	public void setDrug(Drug drug) {
		this.drug = drug;
	}
	@Override
	public String toString() {
		return "Pmoudle [diseID=" + diseID + ", pPrescriptID=" + pPrescriptID + ", docID=" + docID + ", crateTime=" + crateTime
				+ ", pMoudleType=" + pMoudleType + ", pRange=" + pRange + ", moudleName=" + moudleName + ", itemID="
				+ itemID + ", prescriptID=" + prescriptID + ", drugID=" + drugID + ", number=" + number + ", itemState="
				+ itemState + ", createTime=" + createTime + ", itemType=" + itemType + ", drug=" + drug + "]";
	}

	
	
}
