package com.his.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RegisteInfo implements Serializable
{
	private String caseID;
	private boolean newCase;
	private boolean modifyCase;

	private String name;
	private String gender;
	private String patientID;
	private String birthday;
	private String age;
	private String ageUnit;
	private String address;

	private String appointmentDate;
	private String period;
	private String department;
	private String doctorType;
	private String doctor;
	
	private String settlement;
	private String amount;
	private String chargeType;
	private String newNote;
	public String getCaseID() {
		return caseID;
	}
	public void setCaseID(String caseID) {
		this.caseID = caseID;
	}
	public boolean isNewCase() {
		return newCase;
	}
	public void setNewCase(boolean newCase) {
		this.newCase = newCase;
	}
	public boolean isModifyCase() {
		return modifyCase;
	}
	public void setModifyCase(boolean modifyCase) {
		this.modifyCase = modifyCase;
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
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDoctorType() {
		return doctorType;
	}
	public void setDoctorType(String doctorType) {
		this.doctorType = doctorType;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public String getSettlement() {
		return settlement;
	}
	public void setSettlement(String settlement) {
		this.settlement = settlement;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getChargeType() {
		return chargeType;
	}
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}
	public String getNewNote() {
		return newNote;
	}
	public void setNewNote(String newNote) {
		this.newNote = newNote;
	}
	@Override
	public String toString() {
		return "RegisteInfo [caseID=" + caseID + ", newCase=" + newCase + ", modifyCase=" + modifyCase + ", name="
				+ name + ", gender=" + gender + ", patientID=" + patientID + ", birthday=" + birthday + ", age=" + age
				+ ", ageUnit=" + ageUnit + ", address=" + address + ", appointmentDate=" + appointmentDate + ", period="
				+ period + ", department=" + department + ", doctorType=" + doctorType + ", doctor=" + doctor
				+ ", settlement=" + settlement + ", amount=" + amount + ", chargeType=" + chargeType + ", newNote="
				+ newNote + "]";
	}
	
	
	
}
