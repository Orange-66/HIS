package com.his.entity;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class Register implements Serializable
{
	private Integer registerID;
	private Integer caseID;
	private Date createTime;
	private Integer registState;
	private Integer newNote;
	private Integer docID;
	private Integer levID;
	private Integer chargeID;
	private Integer chargeType;
	private String regType;
	private String depID;
	private String realName;
	private String depName;
	private String name;
	private String age;
	private String ageUnit;
	private String gender;
	
	public Integer getRegisterID() {
		return registerID;
	}
	public void setRegisterID(Integer registerID) {
		this.registerID = registerID;
	}
	public Integer getCaseID() {
		return caseID;
	}
	public void setCaseID(Integer caseID) {
		this.caseID = caseID;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getRegistState() {
		return registState;
	}
	public void setRegistState(Integer registState) {
		this.registState = registState;
	}
	public Integer getNewNote() {
		return newNote;
	}
	public void setNewNote(Integer newNote) {
		this.newNote = newNote;
	}
	public Integer getDocID() {
		return docID;
	}
	public void setDocID(Integer docID) {
		this.docID = docID;
	}
	public Integer getLevID() {
		return levID;
	}
	public void setLevID(Integer levID) {
		this.levID = levID;
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
	public String getRegType() {
		return regType;
	}
	public void setRegType(String regType) {
		this.regType = regType;
	}
	public String getDepID() {
		return depID;
	}
	public void setDepID(String depID) {
		this.depID = depID;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAgeUnit() {
		return ageUnit;
	}
	public void setAgeUnit(String ageUnit) {
		this.ageUnit = ageUnit;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Register [registerID=" + registerID + ", caseID=" + caseID + ", createTime=" + createTime
				+ ", registState=" + registState + ", newNote=" + newNote + ", docID=" + docID + ", levID=" + levID
				+ ", chargeID=" + chargeID + ", chargeType=" + chargeType + ", regType=" + regType + ", depID=" + depID
				+ ", realName=" + realName + ", depName=" + depName + ", name=" + name + ", age=" + age + ", ageUnit="
				+ ageUnit + ", gender=" + gender + "]";
	}
	
	

	
	
}
