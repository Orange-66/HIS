package com.his.entity;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class Case implements Serializable
{
	private Integer caseID;
	private String patientID;
	private String name;
	private String gender;
	private Date birthday;
	private Integer age;
	private String ageUnit;
	private String address;
	
	public Integer getCaseID() {
		return caseID;
	}
	public void setCaseID(Integer caseID) {
		this.caseID = caseID;
	}
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAgeUnit() {
		return ageUnit;
	}
	public void setAgeUnit(String ageUnit) {
		this.ageUnit = ageUnit;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Case [caseID=" + caseID + ", patientID=" + patientID + ", name=" + name + ", gender=" + gender
				+ ", birthday=" + birthday + ", age=" + age + ", ageUnit=" + ageUnit + ", address=" + address + "]";
	}
	
}
